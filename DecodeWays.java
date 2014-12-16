package solutions;

/*
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 */
public class DecodeWays {
  
  /* solution learned from 9Z. Good one to MEMORIZE */
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int[] sum = new int[s.length() + 1];
    sum[0] = 1;
    sum[1] = s.charAt(0) == '0'? 0 : 1;
    for (int i = 2; i <= s.length(); i++) {
      if (s.charAt(i - 1) != '0') {
        sum[i] = sum[i - 1];
      }
      int digits = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
      if (digits >= 10 && digits <= 26) {
        sum[i] += sum[i - 2];
      }
    }
    return sum[s.length()];
  }
  
  /* elegant solution from discussion, just for the art of code */
  public int numDecodings_discussion(String s) {
    int n = s.length();
    if (n == 0)
      return 0;
    int[] memo = new int[n + 1];
    memo[n] = 1;
    memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
    for (int i = n - 2; i >= 0; i--)
      if (s.charAt(i) == '0')
        continue;
      else
        memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1]
            + memo[i + 2] : memo[i + 1];
    return memo[0];
  }
}
