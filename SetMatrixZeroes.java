package solutions;

/*
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. 
 Do it in place.
 */
/* Discussion:
 An easy way to solve this problem is to use extra O(m + n) space, 
 storing the zero row and column indices.

 We can improve it by not using the extra O(m + n) space, instead, 
 we can use the space inside that input matrix (inspired by Shangrila's solution, 
 which use the first row and column for storage).

 In this solution, at the beginning, I find the first zero element, and use that 
 row and column as the temp place for storing the other zero element indices. 
 After we get all the zero indices, then set the corresponding row and columns to zero.

 */
public class SetMatrixZeroes {
  
  /*
   * very nice algorithm. Easy to make mistakes on col and row indexes. be
   * careful about that.
   */
  public static void setZeroes(int[][] matrix) {
    int rowTemp = -1, colTemp = -1;
    /* record those rows and columns that should be filled with 0 */
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          if (rowTemp == -1) {
            rowTemp = i;
            colTemp = j;
          } else {
            matrix[rowTemp][j] = 0;
            matrix[i][colTemp] = 0;
          }
        }
      }
    }
    if (rowTemp == -1) {
      return;
    }
    /* fill rows */
    for (int i = 0; i < matrix.length; i++) {
      if (i == rowTemp) {
        continue;
      }
      if (matrix[i][colTemp] == 0) {
        for (int j = 0; j < matrix[i].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    /* fill columns */
    for (int j = 0; j < matrix[rowTemp].length; j++) {
      if (matrix[rowTemp][j] == 0) {
        for (int i = 0; i < matrix.length; i++) {
          matrix[i][j] = 0;
        }
      }
    }
    /* fill out rowTemp */
    for (int j = 0; j < matrix[0].length; j++) {
      matrix[rowTemp][j] = 0;
    }
  }
}
