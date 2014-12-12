package solutions;

import java.util.HashMap;

/*
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 (I) to 3999 (IMMM).

 Roman numeral rules:see 
 http://www.factmonster.com/ipka/A0769547.html

 */
public class RomanToInteger {
  public static int romanToInt(String s) {
    if (s == null || s.length() == 0) {
      return -1;
    }
    HashMap<Character, Integer> m = new HashMap<Character, Integer>();
    m.put('I', 1);
    m.put('V', 5);
    m.put('X', 10);
    m.put('L', 50);
    m.put('C', 100);
    m.put('D', 500);
    m.put('M', 1000);
    int res = m.get(s.charAt(s.length() - 1));
    for (int i = s.length() - 2; i >= 0; i--) {
      if (m.get(s.charAt(i + 1)) > m.get(s.charAt(i))) {
        res -= m.get(s.charAt(i));
      } else {
        res += m.get(s.charAt(i));
      }
    }
    return res;
  }
}
