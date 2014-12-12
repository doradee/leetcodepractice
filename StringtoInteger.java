package solutions;

/*
 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. 
 If you want a challenge, please do not see below and ask yourself 
 what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely 
 (ie, no given input specs). 
 You are responsible to gather all the input requirements up front.
 */
public class StringtoInteger {
  
  /* Second Attempt. Learned from 9Z */
  /*
   * Accetped. Did a small change on 9Z's solution which is not acceptable The
   * mistake of 9Z's code is ignoring the case when num is big and sign = -1 The
   * code added is: else if (num > (long) Integer.MAX_VALUE + 1 && sign == -1) {
   * break;
   */
  public static int atoi(String str) {
    if (str == null) {
      return 0;
    }
    str = str.trim();
    if (str.length() == 0) {
      return 0;
    }
    int index = 0;
    int sign = 1;
    if (str.charAt(0) == '-') {
      sign = -1;
      index++;
    } else if (str.charAt(0) == '+') {
      index++;
    }
    long num = 0;
    for (; index < str.length(); index++) {
      if (str.charAt(index) < '0' || str.charAt(index) > '9') {
        break;
      }
      num = num * 10 + (str.charAt(index) - '0');
      if (num > Integer.MAX_VALUE && sign == 1) {
        break;
      } else if (num > (long) Integer.MAX_VALUE + 1 && sign == -1) {
        break;
      }
    }
    if (num * sign > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    if (num * sign < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    return (int) num * sign;
  }
  
  /* First Attempt. Messed up */
  public static int atoi_Failed(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    char sign = ' ';
    String value = "";
    str = str.trim();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '+' || str.charAt(i) == '-') {
        sign = str.charAt(i);
        continue;
      }
      if (Character.isDigit(str.charAt(i))) {
        value += str.charAt(i);
      }
    }
    String digits = value;
    if (sign == '-') {
      digits = sign + value;
    }
    // System.out.println(digits);
    if (value.length() == 0) {
      return 0;
    }
    int res = (int) (value.charAt(0) - '0');
    // System.out.println("First res:" + res);
    if (validNum(digits)) {
      for (int i = 1; i < value.length(); i++) {
        res = res * 10 + (int) (value.charAt(i) - '0');
        // System.out.println(i + "th res: " + res);
      }
    }
    if (sign == '-') {
      return (0 - res);
    } else {
      return res;
    }
  }
  
  public static boolean validNum(String str) {
    String max = "2147483647";
    String min = "-2147483648";
    if (str.charAt(0) == '-') {
      // compare with min
      int length = str.length();
      if (length > min.length()) {
        return false;
      } else if (length < min.length()) {
        return true;
      } else {
        // same length 11
        for (int i = 1; i < length; i++) {
          if (str.charAt(i) > min.charAt(i)) {
            return false;
          } else if (str.charAt(i) < min.charAt(i)) {
            return true;
          } else {
            continue;
          }
        }
      }
    } else {
      // compare with max
      if (str.charAt(0) == '+') {
        str = str.substring(1, str.length() - 1);
      }
      int length = str.length();
      if (length > max.length()) {
        return false;
      } else if (length < max.length()) {
        return true;
      } else {
        // same length 10
        for (int i = 0; i < length; i++) {
          if (str.charAt(i) > max.charAt(i)) {
            return false;
          } else if (str.charAt(i) < max.charAt(i)) {
            return true;
          } else {
            continue;
          }
        }
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    String input = "             33a  ,  b  3         ";
    System.out.println(atoi(input));
  }
}
