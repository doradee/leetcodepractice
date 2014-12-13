package solutions;

/*
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, 
 or -1 if needle is not part of haystack.

 Update (2014-11-02):
 The signature of the function had been updated to return the index instead of 
 the pointer. If you still see your function signature returns a char * or String, 
 please click the reload button  to reset your code definition.
 */
public class ImplementstrStr {
  
  /*Accepted
   * However, be sure to know:
   *   the stopping point for loop is haystack.length() - needle.length + 1;
   *       ie: "abc".length = 3, "ab".length = 2, the end index should be 3 - 2 = 1;
   *       and the stopping point should be 1 + 1 = 2.
   *   substring for comparing is (i, i+needlelength); end index is exclusive.
   *       ie: "abc".substring(0, 0) = "";
   *           "abc".substring(0, 1) = "a" 
   */
  public static int strStr(String haystack, String needle) {
    if (haystack == null) {
      return -1;
    }
    if (needle == null || needle == "") {
      return 0;
    }
    int needlelength = needle.length();
    System.out.println(needlelength);
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      System.out.println("Str: " + haystack.substring(i, i + needlelength));
      if (haystack.substring(i, i + needlelength).equals(needle)) {
        
        return i;
      }
    }
    return -1;
  }
  
  public static void main(String[] args) {
    String haystack = "abbb";
    String needle = "a";
    System.out.println(strStr(haystack, needle));
  }
}
