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
  
  public static int atoi(String str) {
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
      if (Character.isDigit(str.charAt(i))){
        value += str.charAt(i);
      }
    }
    String digits = sign + value;
    if (value.length() == 0) {
      return 0;
    }
    int res =(int) value.charAt(0);
    if (validNum(digits)) {
      for (int i = 1; i < value.length(); i++) {
        res += res * 10 + value.charAt(i);
      }
    }
    if (sign == '-') {
      return (0 - res);
    } else {
      return res;
    }
  }
  
  public static boolean validNum (String str) {
    String max = "2147483647";
    String min = "-2147483648";
    if (str.charAt(0) == '-') {
      //compare with min
      int length = str.length();
      if (length > min.length()) {
        return false;
      } else if (length < min.length()){
        return true;
      } else {
        //same length 11
        for (int i = 1; i < length; i++) {
          if (str.charAt(i)> min.charAt(i)) {
            return false;
          } else if (str.charAt(i) < min.charAt(i)) {
            return true;
          } else {
            continue;
          }
        }
      }
    } else {
      //compare with max
      if (str.charAt(0) == '+') {
        str = str.substring(1, str.length() - 1);
      }
      int length = str.length();
      if (length > max.length()) {
        return false;
      } else if (length < max.length()){
        return true;
      } else {
        //same length 10
        for (int i = 0; i < length; i++) {
          if (str.charAt(i)> max.charAt(i)) {
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
    String input = "333";
    System.out.println(atoi(input));
  }
}
