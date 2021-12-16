package tree;
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
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) {
          return res;
      }
      
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      
      while (!queue.isEmpty()) {
          
          int levelSize = queue.size();
          List<Integer> curLevelNodes = new ArrayList<>();
          for (int i = 0; i < levelSize; i++) {
              TreeNode node = queue.poll();
              // add the values of the
              if (node.left != null) {
                  queue.add(node.left);
              }
              if (node.right != null) {
                  queue.add(node.right);
              }
              
              curLevelNodes.add(node.val);
          }
          res.add(curLevelNodes);
      }
      
      return res;
  }
}

/*
Time complexity #
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) as we need to return a list containing the level order traversal. We will also need O(N) space for the queue. Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level), therefore we will need O(N)O(N) space to store them in the queue.
*/