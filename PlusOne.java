package solutions;

import java.util.Arrays;

/*Given a non-negative number represented as an array of digits, 
 * plus one to the number.
 * The digits are stored such that the most significant digit 
 * is at the head of the list.
 */
public class PlusOne {
  
  /* This solution is accepted. However, the complexity is o(n) */
  public static int[] plusOne1(int[] digits) {
    if (digits == null) {
      return null;
    }
    int length = digits.length;
    int carry = 1;
    int[] result = new int[length + 1];
    for (int i = length; i >= 1; i--) {
      result[i] = (digits[i - 1] + carry) % 10;
      carry = (digits[i - 1] + carry) / 10;
    }
    if (carry != 0) {
      result[0] = 1;
      return result;
    } else {
      return Arrays.copyOfRange(result, 1, length + 1);
    }
  }
  
  /* This solution improves the above one by avoiding non-necessary cal
   * Inspired by 9Z */
  public static int[] plusOne(int[] digits) {
    if (digits == null) {
      return null;
    }
    int length = digits.length;
    int carry = 1;
    for (int i = length - 1; i >= 0; i--) {
      if (digits[i] + carry == 10) {
        digits[i] = 0;
      } else {
        digits[i] = digits[i] + carry;
        carry = 0;
        break;
      }
    }
    
    if (carry != 0) {
      int[] result = new int[length + 1];
      result[0] = 1;
      for (int i = 0; i < length; i++) {
        result[i+1] = digits[i];
      }
      return result;
    } else {
      return digits;
    }
  }
  
  public static void main(String[] args) {
    int[] num = { 0 };
    System.out.println(Arrays.toString(plusOne(num)));
  }
}
