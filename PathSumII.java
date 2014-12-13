package solutions;

import java.util.ArrayList;

/*
 Given a binary tree and a sum, find all root-to-leaf paths where 
 each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]

 */
public class PathSumII {
  
  /*
   * Accepted solution. However, this solution needs lots of memory to store
   * path branches.
   */
  public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return res;
    }
    ArrayList<Integer> path = new ArrayList<Integer>();
    findPathSum(root, sum, path, res);
    return res;
  }
  
  /* This is my solution using lots of paths */
  public static void findPathSum(TreeNode root, int sum,
      ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      if (root.val == sum) {
        path.add(root.val);
        result.add(path);
        return;
      } else {
        return;
      }
    } else {
      ArrayList<Integer> pathleft = new ArrayList<Integer>();
      ArrayList<Integer> pathright = new ArrayList<Integer>();
      for (int i : path) {
        pathleft.add(i);
        pathright.add(i);
      }
      pathleft.add(root.val);
      pathright.add(root.val);
      findPathSum(root.left, sum - root.val, pathleft, result);
      findPathSum(root.right, sum - root.val, pathright, result);
    }
  }
  
  /*
   * This solution is inspired by 9Z, which use only 1 path to record every
   * possibility
   */
  public static void findPathSum_9Z(TreeNode root, int sum,
      ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      if (root.val == sum) {
        path.add(root.val);
        result.add(new ArrayList<Integer>(path));
        path.remove(path.size() - 1);
      }
      return;
    } else {
      path.add(root.val);
      findPathSum_9Z(root.left, sum - root.val, path, result);
      findPathSum_9Z(root.right, sum - root.val, path, result);
      path.remove(path.size() - 1);
    }
  }
}
