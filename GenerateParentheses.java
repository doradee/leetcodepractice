package solutions;

import java.util.ArrayList;

/*
 Given n pairs of parentheses, write a function to generate all 
 combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
  
  /*
   * Inspired by the discussion. The idea is how to get n from n - 1. basically,
   * add a pair of parentheses on 0 to n - 1 possible res, and attach the rest n
   * - 1 to 0 possible res.
   */
  public static ArrayList<String> generateParenthesis(int n) {
    ArrayList<String> res = new ArrayList<String>();
    if (n <= 0) {
      res.add("");
      return res;
    }
    for (int i = 0; i < n; i++) {
      ArrayList<String> prefix = generateParenthesis(i);
      ArrayList<String> postfix = generateParenthesis(n - i - 1);
      for (String pre : prefix) {
        for (String post : postfix) {
          res.add('(' + pre + ')' + post);
        }
      }
    }
    return res;
  }
}
