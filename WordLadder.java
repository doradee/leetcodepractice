package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 Given two words (start and end), and a dictionary, find the length of shortest 
 transformation sequence from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 * 
 */
public class WordLadder {
  
  /* solution from 9Z. */
  public static int ladderLength_9Z(String start, String end, Set<String> dict) {
    if (dict == null || dict.size() == 0) {
      return 0;
    }
    Queue<String> queue = new LinkedList<String>();
    queue.offer(start);
    dict.remove(start);
    int length = 1;
    while (!queue.isEmpty()) {
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        String current = queue.poll();
        for (char c = 'a'; c <= 'z'; c++) {
          for (int j = 0; j < current.length(); j++) {
            if (c == current.charAt(j)) {
              continue;
            }
            String tmp = replace(current, j, c);
            if (tmp.equals(end)) {
              return length + 1;
            }
            if (dict.contains(tmp)) {
              queue.offer(tmp);
              dict.remove(tmp);
            }
          }
        }
      }
      length++;
    }
    return 0;
  }
  
  private static String replace(String s, int index, char c) {
    char[] chars = s.toCharArray();
    chars[index] = c;
    return new String(chars);
  }
  
  /* Modification based on 9Z's solution. TLE anyway. */
  public static int ladderLength_Failed2(String start, String end,
      Set<String> dict) {
    if (dict == null | dict.size() == 0) {
      return 0;
    }
    Queue<String> queue = new LinkedList<String>();
    queue.offer(start);
    dict.remove(start);
    int length = 0;
    ArrayList<String> currdic = new ArrayList<String>();
    for (String s : dict) {
      currdic.add(s);
    }
    while (!queue.isEmpty()) {
      String current = queue.poll();
      if (isValid(current, end)) {
        return length + 1;
      }
      for (int i = 0; i < currdic.size(); i++) {
        String s = currdic.get(i);
        if (isValid(current, s)) {
          queue.offer(s);
          currdic.remove(s);
          i--;
        }
      }
      length++;
    }
    return 0;
  }
  
  /* First try. got TLE. Time complexity is too high dict.size()! */
  public static int ladderLength_Failed(String start, String end,
      Set<String> dict) {
    if (dict == null || dict.size() == 0) {
      return 0;
    }
    Set<String> used = new HashSet<String>();
    int[] min = new int[1];
    min[0] = Integer.MAX_VALUE;
    int length = 0;
    landderLengthCal(start, end, dict, used, length, min);
    return min[0] == Integer.MAX_VALUE ? 0 : min[0];
  }
  
  public static boolean isValid(String a, String b) {
    int count = 0;
    if (a.length() != b.length()) {
      return false;
    }
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        count++;
      }
      if (count > 1) {
        break;
      }
    }
    return count == 1;
  }
  
  public static void landderLengthCal(String start, String end,
      Set<String> dict, Set<String> used, Integer length, int[] min) {
    if (isValid(start, end)) {
      min[0] = length + 1;
      return;
    }
    for (String s : dict) {
      if (used.contains(s)) {
        continue;
      }
      if (s.equals(start) && length != 0) {
        continue;
      }
      if (isValid(s, start) && length < min[0] - 1) {
        used.add(s);
        landderLengthCal(s, end, dict, used, length + 1, min);
        used.remove(s);
      }
    }
    return;
  }
  
  public static void main(String[] args) {
    String start = "hit";
    String end = "cog";
    Set<String> dict = new HashSet<String>(Arrays.asList("hot", "dot", "dog",
        "lot", "log"));
    System.out.println(ladderLength_9Z(start, end, dict));
  }
}
