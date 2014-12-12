package solutions;

/*
 * Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
  
  /*
   * Learned from 9Z. The idea is similar to Digit to Integer but the trick is
   * have 900, 400, 90, 40 9, 4 listed instead of complex branching
   */
  public static String intToRoman(int num) {
    String res = "";
    if (num < 0) {
      return res;
    }
    int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
        "V", "IV", "I" };
    int digit = 0;
    while (num > 0) {
      int mul = num / nums[digit];
      num -= mul * nums[digit];
      for (; mul > 0; mul--) {
        res += symbols[digit];
      }
      digit++;
    }
    return res;
  }
}
