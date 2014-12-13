package solutions;

import java.util.HashMap;
import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 but "(]" and "([)]" are not.
 */
public class ValidParentheses {
  
  /*Accepted. Trivial using stack */
  
  public static boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    HashMap<Character, Character> dic = new HashMap<Character, Character>();
    dic.put(')', '(');
    dic.put('}', '{');
    dic.put(']', '[');
    Stack<Character> tokens = new Stack<Character>();
    for (int i = 0; i < s.length();i++) {
      if (tokens.isEmpty() || !tokens.peek().equals(dic.get(s.charAt(i)))){
        tokens.push(s.charAt(i));
      } else {
        tokens.pop();
      }
    }
    return tokens.isEmpty();
  }
  
  public static void main(String[] args) {
    String s = "({[([])]})";
    System.out.println(isValid(s));
  }
}
