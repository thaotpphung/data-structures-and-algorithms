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
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> curPath = new ArrayList<>();
      findPath(root, sum, curPath, res);
      return res;
  }
  
  private void findPath (TreeNode node, int sum, List curPath, List res) {
      if (node == null) {
         return;
      }
      curPath.add(node.val);
      
      // if the current node is a leaf and its value is equal to sum, save the current path
      if (node.val == sum && node.left == null && node.right == null) {
          //  when the recursion goes up, the sol size will always decrease by1. As a result, the final size of sol will be 0. So if you write res.add(sol), it will be null list finally. The function of new ArrayList(sol) is to create a new list which has same value as sol, rather than res.add(sol) offering the reference to sol.
      // We have to make a brand new copy of all the nodes in path. If we do not, we are just adding a reference to the variable path. That's an issue right? Because when path changes, so will our result. We don't want that to happen right - when something is added to our result it shouldn't change.

// Path is empty by the time the while loop is done since there are no nodes left. So just adding path will return an array of empty arrays.
          
          res.add(new ArrayList<Integer>(curPath));
      } else {
          findPath(node.left, sum - node.val, curPath, res);
          findPath(node.right, sum - node.val, curPath, res);
      }
      
      // remove the current node from the path to backtrack, 
      // we need to remove the current node while we are going up the recursive call stack.
      //  It is called "backtracking". During the execution, we first blindly add (or use) the node, and check if it satisfies the condition we expect to meet. If it satisfies, we return a final result or in the case of this question, add to the resulting list. After removing ourselves from the partial list, we basically say that "let's try this without me" and explore other branches of decision tree
      curPath.remove(curPath.size() - 1);        
  }
}

/*
Time complexity #
The time complexity of the above algorithm is O(N^2), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once (which will take O(N), and for every leaf node we might have to store its path which will take O(N).

We can calculate a tighter time complexity of O(NlogN) from the space complexity discussion below.

Space complexity #
If we ignore the space required for the allPaths list, the space complexity of the above algorithm will be O(N) in the worst case. This space will be used to store the recursion stack. The worst case will happen when the given tree is a linked list (i.e., every node has only one child).
  
*/ 



