package solutions;

import java.util.Arrays;

/*
 * Write a function to find the longest common prefix 
 * string amongst an array of strings.
 */
public class LongestCommonPrefix {
  /* Accepted after several failures for corner cases */
  public static String longestCommonPrefix(String[] strs) {
    String res = "";
    if (strs == null || strs.length == 0) {
      return res;
    }
    if (strs.length == 1) {
      return strs[0]; //avoid case such as {"a"}
    }
    Arrays.sort(strs); //avoid case such as {"aa", "a"}
    int lcp = strs[0].length();
    res = strs[0];
    for (int i = 0; i < strs.length - 1; i++) {
      int index = 0;
      int temp = 0;
      while (index < strs[i].length() && index < strs[i + 1].length()) {
        if (strs[i].charAt(index) == strs[i + 1].charAt(index)) {
          temp++;
          if (temp > lcp) {
            break;
          }
          index++;
        } else {
          if (lcp > temp) {
            lcp = temp;
            res = strs[i].substring(0, index);
          }
          break;
        }
      }
    }
    return res;
  }
  
  public static void main(String[] args) {
    String[] strs = { "aa", "a" };
    System.out.println(longestCommonPrefix(strs));
  }
}
