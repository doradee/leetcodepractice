package solutions;

/*
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree {
  
  /* Accepted. Same logic as from List. But easier to code since the length of an
   * array is known, and the elements in an array is easier to access.
   */
  public TreeNode sortedArrayToBST(int[] num) {
    if (num == null || num.length == 0) {
      return null;
    }
    return aTob (num, 0, num.length - 1);
    
  }
  
  private TreeNode aTob(int[] num, int left, int right) {
    if (left > right) {
      return null;
    }
    if (left == right) {
      return new TreeNode(num[left]);
    }
    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(num[mid]);
    root.left = aTob(num, left, mid - 1);
    root.right = aTob(num, mid + 1, right);
    return root;
  }
}
