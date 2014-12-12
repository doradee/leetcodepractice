package solutions;

/*
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
  
  /* Copied from 9Z. BORING MATH */
  public static String convert(String s, int nRows) {
    int length = s.length();
    if (length <= nRows || nRows == 1)
      return s;
    char[] chars = new char[length];
    int step = 2 * (nRows - 1);
    int count = 0;
    for (int i = 0; i < nRows; i++) {
      int interval = step - 2 * i;
      for (int j = i; j < length; j += step) {
        chars[count] = s.charAt(j);
        count++;
        if (interval < step && interval > 0 && j + interval < length
            && count < length) {
          chars[count] = s.charAt(j + interval);
          count++;
        }
      }
    }
    return new String(chars);
  }
  
  /* First Attempt. Failed. Got TLE */
  public static String convert_Failed(String s, int nRows) {
    String res = "";
    if (s == null || s.length() == 0) {
      return res;
    }
    if (nRows == 1) {
      return s;
    }
    int index = 0;
    int colindex = 0;
    String[] temp = new String[nRows];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = "";
    }
    while (index < s.length()) {
      for (int i = 0; i < nRows && index < s.length(); i++) {
        if (colindex % (nRows - 1) == 0) {
          temp[i] += "" + s.charAt(index);
          index++;
        } else if ((colindex + i) % (nRows - 1) == 0) {
          temp[i] += "" + s.charAt(index);
          index++;
        } else {
          temp[i] += " ";
        }
      }
      colindex++;
    }
    for (int i = 0; i < temp.length; i++) {
      res += temp[i] + '\n';
    }
    return res;
  }
  
  public static void main(String[] args) {
    String input = "twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd";
    System.out.println(convert(input, 4));
  }
}
