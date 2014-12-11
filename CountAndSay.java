package solutions;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 */
public class CountAndSay {
  
  /* Accepted. The trick is using recursion, and turn n to String */
  public static String countAndSay1(int n) {
    if (n == 1) {
      return "1";
    }
    return countAndSayProcess(countAndSay(n - 1));
  }
  
  public static String countAndSayProcess(String digits) {
    String res = "";
    int length = digits.length();
    int count = 1;
    char cur = digits.charAt(0);
    for (int i = 1; i < length; i++) {
      if (digits.charAt(i) == digits.charAt(i - 1)) {
        count++;
      } else {
        res = res + count + cur;
        count = 1;
        cur = digits.charAt(i);
      }
    }
    res = res + count + cur;
    return res;
  }
  
  /* Inspired by 9Z. An interation solution */
  public static String countAndSay(int n) {
    String old = "1";
    int position = 1;
    while (position < n) {
      String temp = "";
      int count = 1;
      char cur = old.charAt(0);
      for (int i = 1; i < old.length(); i++) {
        if (old.charAt(i) == old.charAt(i - 1)) {
          count++;
        } else {
          temp = temp + count + cur;
          count = 1;
          cur = old.charAt(i);
        }
      }
      temp = temp + count + cur;
      old = temp;
      position++;
    }
    return old;
  }
  
  /* 9Z's solution. More compact */
  public String countAndSay_9Z(int n) {
    String oldString = "1";
    while (--n > 0) {
      StringBuilder sb = new StringBuilder();
      char[] oldChars = oldString.toCharArray();
      for (int i = 0; i < oldChars.length; i++) {
        int count = 1;
        while ((i + 1) < oldChars.length && oldChars[i] == oldChars[i + 1]) {
          count++;
          i++;
        }
        sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
      }
      oldString = sb.toString();
    }
    return oldString;
  }
  
  public static void main(String[] args) {
    int n = 14;
    System.out.println(countAndSay(n));
  }
}
