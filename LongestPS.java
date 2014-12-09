package LeetCodeAnswers;

public class LongestPS {

  public static boolean isPalindromic(String strings) {
    for (int i = 0; i < strings.length() / 2; i++) {
      if (strings.charAt(i) != strings.charAt(strings.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static String longestPalindrome(String s) {
    char[] input = s.toCharArray();
    int max = 0;
    String output = "";
    for (int i = 0; i < input.length; i++) {
      String substring = "";
      for (int j = 0; j < input.length - i; j++) {
        substring = substring + input[i + j];
        if (substring.length() >= max && isPalindromic(substring)) {
          if (substring.length() > max) {
            max = substring.length();
            output = substring;
          }
        }
      }
    }
    return output;
  }

  public static void main(String[] args) {
    String x = "zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir";
    System.out.println(longestPalindrome(x));
  }
}
