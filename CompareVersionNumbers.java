package solutions;

/*
 Compare two version numbers version1 and version1.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {
  
  /* learned from discussion */
  public static int compareVersion(String s1, String s2) {
    int l1 = s1.length(), l2 = s2.length();
    int i = 0, j = 0;
    int v1 = 0, v2 = 0;
    while (i < l1 && j < l2) {
      while (i < l1 && s1.charAt(i) != '.') {
        v1 = v1 * 10 + (int) (s1.charAt(i) - '0');
        i++;
      }
      while (j < l2 && s2.charAt(j) != '.') {
        v2 = v2 * 10 + (int) (s2.charAt(j) - '0');
        j++;
      }
      if (v1 > v2)
        return 1;
      if (v1 < v2)
        return -1;
      v1 = 0;
      v2 = 0;
      i++;
      j++;
    }
    while (i < l1 && s1.charAt(i) != '.') {
      v1 = v1 * 10 + (int) (s1.charAt(i) - '0');
      i++;
    }
    while (j < l2 && s2.charAt(j) != '.') {
      v2 = v2 * 10 + (int) (s2.charAt(j) - '0');
      j++;
    }
    if (v1 > v2)
      return 1;
    if (v1 < v2)
      return -1;
    return 0;
  }
  
  /*
   * this problem is much harder than first glance. The rule of version
   * comparison is not clear, which causes lots of corner cases.
   */
  public static int compareVersion_Attempt1(String version1, String version2) {
    double val1 = toNum(version1);
    double val2 = toNum(version2);
    if (val1 > val2) {
      return 1;
    } else if (val2 > val1) {
      return -1;
    } else {
      int dotindex1 = version1.indexOf(".");
      int dotindex2 = version2.indexOf(".");
      if (dotindex1 > 0 && dotindex2 > 0) {
        String afterdot1 = version1.substring(dotindex1, version1.length());
        String afterdot2 = version2.substring(dotindex2, version2.length());
        if (afterdot1.length() == afterdot2.length()) {
          return 0;
        } else {
          return afterdot1.length() > afterdot2.length() ? 1 : -1;
        }
      } else if (dotindex1 < 0 && dotindex2 < 0) {
        return 0;
      } else {
        return dotindex1 < 0 ? -1 : 1;
      }
    }
  }
  
  private static double toNum(String str) {
    int index = str.indexOf(".");
    int lengthbeforedot = index > 0 ? index : str.length();
    double num = 0;
    for (int i = 0; i < lengthbeforedot; i++) {
      num = num * 10 + str.charAt(i) - '0';
    }
    if (index > 0) {
      for (int i = lengthbeforedot + 1; i < str.length(); i++) {
        num += (str.charAt(i) - '0') * 1.0 / 10;
      }
    }
    return num;
  }
  
  public static void main(String[] args) {
    System.out.println(toNum("1.2"));
    System.out.println(toNum("1.10"));
  }
}
