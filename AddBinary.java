package solutions;

public class AddBinary {
  
  /*
   * Given two binary strings, return their sum (also a binary string).
   * 
   * For example, a = "11" b = "1" Return "100".
   */
  /*
   * First atempt is accepted. However some mistakes are made during practice:
   * such as: use 1 iterator for both String. If the length of a, b is
   * different, the index for the last element will be different. use num[i] ==
   * 0. Note num[i] should be a char not a number.
   */
  public static String addBinary1(String a, String b) {
    String result = "";
    if (a == null || a.length() == 0) {
      return b;
    }
    if (b == null || b.length() == 0) {
      return a;
    }
    // num1's length will be shorter than num2's length
    char[] num1 = a.length() < b.length() ? a.toCharArray() : b.toCharArray();
    char[] num2 = a.length() < b.length() ? b.toCharArray() : a.toCharArray();
    int sum = 0;
    int carry = 0;
    for (int i = num1.length - 1, j = num2.length - 1; i >= 0 && j >= 0; i--, j--) {
      if (num1[i] == '1' && num2[j] == '1') {
        sum = carry;
        carry = 1;
      } else if (num1[i] == '0' && num2[j] == '0') {
        sum = carry;
        carry = 0;
      } else {
        if (carry == 1) {
          sum = 0;
          carry = 1;
        } else {
          sum = 1;
          carry = 0;
        }
      }
      result = Integer.toString(sum) + result;
    }
    for (int i = num2.length - num1.length - 1; i >= 0; i--) {
      if (carry == 1 && num2[i] == '1') {
        sum = 0;
        carry = 1;
      } else if (carry == 0 && num2[i] == '0') {
        sum = 0;
        carry = 0;
      } else {
        sum = 1;
        carry = 0;
      }
      result = Integer.toBinaryString(sum) + result;
    }
    if (carry == 1) {
      result = "1" + result;
    }
    return result;
  }
  
  /*
   * second solution is also accepted. Inspired by 九章 Tricks: 
   *    switch a and b to  make sure a longer than b at the first step; 
   *    get a value of a char c by (int) c - '0'; 
   *    in binary addition, a + b + carry: 
   *        sum = (a + b + carry) % 2; 
   *        carry = (a + b + carry) / 2;
   */
  public static String addBinary(String a, String b) {
    String result = "";
    // make sure a is not shorter than b
    if (a.length() < b.length()) {
      String temp = a;
      a = b;
      b = temp;
    }
    int cura = a.length() - 1;
    int curb = b.length() - 1;
    int sum = 0;
    int carry = 0;
    while (curb >= 0) {
      int tp = (int) (a.charAt(cura) - '0') + (int) (b.charAt(curb) - '0')
          + carry;
      sum = tp % 2;
      carry = tp / 2;
      result = sum + result;
      cura--;
      curb--;
    }
    while (cura >= 0) {
      int tp = (int) (a.charAt(cura) - '0') + carry;
      sum = tp % 2;
      carry = tp / 2;
      result = sum + result;
      cura--;
    }
    if (carry == 1) {
      result = 1 + result;
    }
    return result;
  }
  
  public static void main(String[] args) {
    String a = "1000";
    String b = "1111";
    System.out.println(addBinary(a, b));
  }
}
