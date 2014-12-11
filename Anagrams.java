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
  public static ArrayList<String> anagrams(String[] strs) {
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
}
