package solutions;

/*
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
  
  /* Accepted. The trick is to skip not valid chars */
  public static boolean isPalindrome(String s) {
    if (s.isEmpty()) {
      return true;
    }
    s = s.toLowerCase();
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (!validChar(s.charAt(left))) {
        left++;
      } else if (!validChar(s.charAt(right))) {
        right--;
      } else {
        if (s.charAt(left) != s.charAt(right)) {
          return false;
        } else {
          left++;
          right--;
        }
      }
    }
    return true;
  }
  
  public static boolean validChar(char c) {
    int v = c - 'a';    
    return (v>=0 && v<=25) || (v>=-49 && v<=-40);
  }
  
  /* Learned from 9Z..There is a built-in method to check */
  private boolean isvalid(char c) {
    return Character.isLetter(c) || Character.isDigit(c);
  }
  
  public static void main(String[] args) {
    String test = "ab@a";
    System.out.println(isPalindrome(test));
  }
}
