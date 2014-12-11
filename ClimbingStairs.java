package solutions;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
  /* Trivial solution using DP */
  public static int climbStairs(int n) {
    int[] record = new int[n];
    record[0] = 1;
    return (climbStairsDP(n - 1, record) + climbStairsDP(n - 2, record));
  }
  
  public static int climbStairsDP(int n, int[] record) {
    if (n < 0) {
      return 0;
    }
    if (record[n] != 0) {
      return record[n];
    } else {
      if (n <= 2) {
        record[n] = n;
        return record[n];
      } else {
        record[n] = climbStairsDP(n - 1, record) + climbStairsDP(n - 2, record);
        return record[n];
      }
    }
  }
  
  public static void main(String[] args) {
    System.out.println(climbStairs(30));
  }
}
