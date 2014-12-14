package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 Given a digit string, return all possible letter combinations that the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, 
 your answer could be in any order you want.
 */
public class LetterCombinationsofaPhoneNumber {
  
  /* Accepted. But very slow */
  public static ArrayList<String> letterCombinations_Slow(String digits) {
    ArrayList<String> res = new ArrayList<String>();
    res.add("");
    if (digits == null || digits.length() == 0) {
      return res;
    }
    int index = 0;
    HashMap<Character, char[]> dic = new HashMap<Character, char[]>();
    dic.put('2', new char[] { 'a', 'b', 'c' });
    dic.put('3', new char[] { 'd', 'e', 'f' });
    dic.put('4', new char[] { 'g', 'h', 'i' });
    dic.put('5', new char[] { 'j', 'k', 'l' });
    dic.put('6', new char[] { 'm', 'n', 'o' });
    dic.put('7', new char[] { 'p', 'q', 'r', 's' });
    dic.put('8', new char[] { 't', 'u', 'v' });
    dic.put('9', new char[] { 'w', 'x', 'y', 'z' });
    while (index < digits.length()) {
      char digit = digits.charAt(index);
      if (digit == '1') {
        index++;
        continue;
      } else {
        int size = res.size();
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
          char[] chars = dic.get(digit);
          for (int j = 0; j < chars.length; j++) {
            temp.add(res.get(i) + chars[j]);
          }
        }
        res = temp;
      }
      index++;
    }
    return res;
  }
  
  /* A recursive solution. Better than previous one. */
  public static ArrayList<String> letterCombinations(String digits) {
    ArrayList<String> res = new ArrayList<String>();
    res.add("");
    if (digits == null || digits.length() == 0) {
      return res;
    }
    HashMap<Character, char[]> dic = new HashMap<Character, char[]>();
    dic.put('2', new char[] { 'a', 'b', 'c' });
    dic.put('3', new char[] { 'd', 'e', 'f' });
    dic.put('4', new char[] { 'g', 'h', 'i' });
    dic.put('5', new char[] { 'j', 'k', 'l' });
    dic.put('6', new char[] { 'm', 'n', 'o' });
    dic.put('7', new char[] { 'p', 'q', 'r', 's' });
    dic.put('8', new char[] { 't', 'u', 'v' });
    dic.put('9', new char[] { 'w', 'x', 'y', 'z' });
    letterCombinationsFind(dic, digits, res, "");
    res.remove(0);
    return res;
  }
  
  private static void letterCombinationsFind(HashMap<Character, char[]> dic,
      String digits, ArrayList<String> res, String pre) {
    if (digits.length() == 1) {
      if (digits.charAt(0) != 1) {
        char[] chars = dic.get(digits.charAt(0));
        for (int i = 0; i < chars.length; i++) {
          res.add(pre + chars[i]);
        }
        return;
      } else {
        res.add(pre);
        return;
      }
    }
    char digit = digits.charAt(0);
    if (digit == '1') {
      letterCombinationsFind(dic, digits.substring(1, digits.length()), res,
          pre);
    } else {
      char[] chars = dic.get(digits.charAt(0));
      for (int i = 0; i < chars.length; i++) {
        letterCombinationsFind(dic, digits.substring(1, digits.length()), res,
            pre + chars[i]);
      }
    }
  }
  
  /* Solution from 9Z. Really concise */
  public ArrayList<String> letterCombinations_9Z(String digits) {
    ArrayList<String> result = new ArrayList<String>();
    if (digits == null) {
      return result;
    }
    Map<Character, char[]> map = new HashMap<Character, char[]>();
    map.put('0', new char[] {});
    map.put('1', new char[] {});
    map.put('2', new char[] { 'a', 'b', 'c' });
    map.put('3', new char[] { 'd', 'e', 'f' });
    map.put('4', new char[] { 'g', 'h', 'i' });
    map.put('5', new char[] { 'j', 'k', 'l' });
    map.put('6', new char[] { 'm', 'n', 'o' });
    map.put('7', new char[] { 'p', 'q', 'r', 's' });
    map.put('8', new char[] { 't', 'u', 'v' });
    map.put('9', new char[] { 'w', 'x', 'y', 'z' });
    StringBuilder sb = new StringBuilder();
    helper(map, digits, sb, result);
    return result;
  }
  
  private void helper(Map<Character, char[]> map, String digits,
      StringBuilder sb, ArrayList<String> result) {
    if (sb.length() == digits.length()) {
      result.add(sb.toString());
      return;
    }
    for (char c : map.get(digits.charAt(sb.length()))) {
      sb.append(c);
      helper(map, digits, sb, result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
