/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
      if (root == null)
      return false;

      // if the current node is a leaf and its value is equal to the sum, we've found a path
      if (root.val == sum && root.left == null && root.right == null)
          return true;

      // recursively call to traverse the left and right sub-tree
      // return true if any of the two recursive call return true
      return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }
}

/*
Time complexity #
The time complexity of the above algorithm is O(N)O(N), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N)O(N) in the worst case. This space will be used to store the recursion stack. The worst case will happen when the given tree is a linked list (i.e., every node has only one child).
*/