package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 */
public class Anagrams {
  /* TLE */
  public static ArrayList<String> anagrams1(String[] strs) {
    ArrayList<String> result = new ArrayList<String>();
    if (strs.length <= 1) {
      return result;
    }
    char[] comb;
    int first = -1;
    HashMap<Integer, char[]> dic = new HashMap<Integer, char[]>();
    for (int i = 0; i < strs.length; i++) {
      char[] temp = strs[i].toCharArray();
      Arrays.sort(temp);
      if (dic.containsValue(temp)) {
        result.add(strs[i]);
        comb = temp;
        if (first < 0) {
          for (int j = 0; j < dic.size(); j++) {
            if (dic.get(j).equals(comb)) {
              first = j;
              break;
            }
          }
          result.add(strs[first]);
        }
      } else {
        dic.put(i, temp);
      }
    }
    return result;
  }
  
  /* Accetped Solution. Inspired by discussion based on the problem */
  public static ArrayList<String> anagrams(String[] strs) {
    ArrayList<String> result = new ArrayList<String>();
    HashMap<String, ArrayList<Integer>> dic = new HashMap<String, ArrayList<Integer>>();
    if (strs.length <= 1) {
      return result;
    }
    for (int i = 0; i < strs.length; i++) {
      String key = sort(strs[i]);
      if (dic.containsKey(key)) {
        dic.get(key).add(i);
      } else {
        ArrayList<Integer> index = new ArrayList<Integer>();
        index.add(i);
        dic.put(key, index);
      }
    }
    for (String key : dic.keySet()) {
      if (dic.get(key).size() > 1) {
        for (int j: dic.get(key)) {
          result.add(strs[j]);
        }
      }
    }
    
    return result;
  }
  
  public static String sort(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    return Arrays.toString(chars);
  }
  
  public static void main(String[] args) {
    String[] strs = {"abbb", "babb", "bcbb", "bbab"};
    System.out.println(anagrams(strs).toString());
    for (String s : strs) {
      System.out.println(sort(s).toString());
    }
  }
  
}
