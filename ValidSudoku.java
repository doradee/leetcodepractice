package solutions;

import java.util.ArrayList;
import java.util.HashMap;

/*
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 The Sudoku board could be partially filled, where empty cells are filled 
 with the character '.'.

 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. 
 Only the filled cells need to be validated.
 */
public class ValidSudoku {
  
  /* valid board should be 9*9 */
  /* Accepted */
  public static boolean isValidSudoku(char[][] board) {
    HashMap<Integer, ArrayList<Character>> record = new HashMap<Integer, ArrayList<Character>>();
    /*
     * Initialize 27 lists to record horizontal, vertical, and 9-block
     * neighbors. i represents for horizontal; i* 10 for vertical; i* 100 for
     * 9-block;
     */
    for (int i = 1; i <= 9; i++) {
      record.put(i, new ArrayList<Character>());
      record.put(i * 10, new ArrayList<Character>());
      record.put(i * 100, new ArrayList<Character>());
    }
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char num = board[i][j];
        if (num == '.') {
          continue;
        } else {
          if (record.get(i + 1).contains(num)) {
            return false;
          } else {
            record.get(i + 1).add(num);
          }
          if (record.get(10 * (j + 1)).contains(num)) {
            return false;
          } else {
            record.get(10 * (j + 1)).add(num);
          }
          if (record.get(100 * (getBlock(i, j))).contains(num)) {
            return false;
          } else {
            record.get(100 * (getBlock(i, j))).add(num);
          }
        }
      }
    }
    return true;
  }
  
  public static int getBlock(int i, int j) {
    i = i / 3;
    j = j / 3;
    if ((j * 10 + i) < 10) {
      return i + 1;
    }
    if ((j * 10 + i) < 20) {
      return i + 4;
    }
    return i + 7;
  }
  
  /* Another solution learned from OJdiscussion. Pretty clear */
  public boolean isValidSudoku_OJ(char[][] board) {
    boolean[][] rowCheck = new boolean[9][10];
    boolean[][] colCheck = new boolean[9][10];
    boolean[][] boxCheck = new boolean[9][10];
    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {
        char charToCheck = board[i][j];
        if (charToCheck != '.') {
          int box = (i / 3) * 3 + (j / 3); // find the corresponding box index
          if (boxCheck[box][charToCheck - '0'])
            return false;
          boxCheck[box][charToCheck - '0'] = true;
          if (rowCheck[i][charToCheck - '0'])
            return false;
          rowCheck[i][charToCheck - '0'] = true;
          if (colCheck[j][charToCheck - '0'])
            return false;
          colCheck[j][charToCheck - '0'] = true;
        }
      }
    }
    return true;
  }
}
