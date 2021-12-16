/*
EASY
Problem Statement #
Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the values of all nodes of each level from left to right in separate sub-arrays.

ex: [[1], [2,3], [3,4,5]]

*/

class TreeNode {

  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null; 
  }
};

// leetcode

const traverse = function(root) {
  let result = [];
  
  if (root === null) {
      return result;
  }
  
  let queue = [];
  queue.push(root);
  
  while (queue.length > 0) {
      let row = [];
      let rowSize = queue.length;
      
      while (rowSize > 0) {
          let currentNode = queue.shift();
          
          if (currentNode.left !== null) {
              queue.push(currentNode.left);
          }
          
          if (currentNode.right !== null) {
              queue.push(currentNode.right);
          }
          
          row.push(currentNode.val);
          rowSize--;
      }
      
      result.push(row);
  }
  
  return result;
};



var root = new TreeNode(12);
root.left = new TreeNode(7);
root.right = new TreeNode(1);
root.left.left = new TreeNode(9);
root.right.left = new TreeNode(10);
root.right.right = new TreeNode(5);
console.log(`Level order traversal: ${traverse(root)}`);

/*
Time complexity #
The time complexity of the above algorithm is O(N)O(N), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N)O(N) as we need to return a list containing the level order traversal. We will also need O(N)O(N) space for the queue. Since we can have a maximum of N/2N/2 nodes at any level (this could happen only at the lowest level), therefore we will need O(N)O(N) space to store them in the queue.
*/