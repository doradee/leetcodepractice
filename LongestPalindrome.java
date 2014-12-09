package solutions;

/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */
public class LongestPalindrome {
  
  public static String find_LPS(String input) {
    if (input.isEmpty()) {
      return "";
    }
    int count = 0;
    int max = -1;
    String result = "";
    for (int i = 0; i < input.length(); i++) {
      while ((i - count) >= 0 && (i + count) < input.length()
          && (input.charAt(i - count) == input.charAt(i + count))) {
        if ((2 * count + 1) > max) {
          max = 2 * count + 1;
          result = input.substring(i - count, i + count + 1);
        }
        count++;
      }
      count = 0;
    }
    return result;
  }
  
  public static void main(String[] args) {
    String input = "abcdcccccccccccdddddddddc";
    System.out.println(find_LPS(input));
  }
}
