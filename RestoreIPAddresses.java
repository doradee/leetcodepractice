package solutions;

import java.util.ArrayList;

/*
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {
  
  /* Learned from discussion. Very nice non-DP solution */
  public ArrayList<String> restoreIpAddresses(String s) {
    ArrayList<String> res = new ArrayList<String>();
    if (s == null || s.length() < 4) {
      return res;
    }
    int length = s.length();
    for (int i = 1; i < 4 && i < length - 2; i++) {
      for (int j = i + 1; j < i + 4 && j < length - 1; j++) {
        for (int k = j + 1; k < j + 4 && k < length; k++) {
          String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s
              .substring(j, k), s4 = s.substring(k, length);
          if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
            res.add(s1 + "." + s2 + "." + s3 + "." + s4);
          }
        }
      }
    }
    return res;
  }
  
  private boolean isValid(String s) {
    if (s.length() == 0 || s.length() > 3
        || (s.charAt(0) == '0' && s.length() > 1) || Integer.valueOf(s) > 255) {
      return false;
    }
    return true;
  }
  
  /* You may want to see 9Z's solution which is DP */
  public ArrayList<String> restoreIpAddresses_9Z(String s) {
    ArrayList<String> result = new ArrayList<String>();
    ArrayList<String> list = new ArrayList<String>();
    if (s.length() < 4 || s.length() > 12)
      return result;
    helper(result, list, s, 0);
    return result;
  }
  
  public void helper(ArrayList<String> result, ArrayList<String> list,
      String s, int start) {
    if (list.size() == 4) {
      if (start != s.length())
        return;
      StringBuffer sb = new StringBuffer();
      for (String tmp : list) {
        sb.append(tmp);
        sb.append(".");
      }
      sb.deleteCharAt(sb.length() - 1);
      result.add(sb.toString());
      return;
    }
    for (int i = start; i < s.length() && i <= start + 3; i++) {
      String tmp = s.substring(start, i + 1);
      if (isvalid_9Z(tmp)) {
        list.add(tmp);
        helper(result, list, s, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }
  
  private boolean isvalid_9Z(String s) {
    if (s.charAt(0) == '0')
      return s.equals("0"); // to eliminate cases like "00", "10"
    int digit = Integer.valueOf(s);
    return digit >= 0 && digit <= 255;
  }
}
