package solutions;

/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */
public class LongestPalindrome {
  /* this solution is wrong because it only works for odd length substrings */
  public static String find_LPS1(String s) {
    if (s.isEmpty()) {
      return "";
    }
    int count = 0;
    int max = -1;
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      while ((i - count) >= 0 && (i + count) < s.length()
          && (s.charAt(i - count) == s.charAt(i + count))) {
        if ((2 * count + 1) > max) {
          max = 2 * count + 1;
          result = s.substring(i - count, i + count + 1);
        }
        count++;
      }
      count = 0;
    }
    return result;
  }
  
  /* this is a dynamic programming approach */
  /* This is the accepted answer */
  public static String find_LPS2(String s) {
    String result = s.substring(0, 1);
    if (s.isEmpty()) {
      return result;
    }
    for (int i = 1; i < s.length(); i++) {
      String lp1 = lps(s, i-1, i);
      String lp2 = lps(s, i-1, i+1);
      String longer = lp1.length() > lp2.length()? lp1: lp2;
      result = longer.length() > result.length()? longer: result;
    }
    return result;
  }
  
  public static String lps(String s, int left, int right) {
    while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return s.substring(left + 1, right);
  }
  
  public static void main(String[] args) {
    String input = "a";
    System.out.println(find_LPS2(input));
  }
}
