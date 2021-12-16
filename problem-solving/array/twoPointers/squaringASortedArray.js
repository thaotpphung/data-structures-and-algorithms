/*
EASY

Problem Statement #
Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

Example 1:

Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

*/

const make_squares = function(arr) {
  const n = arr.length;
  squares = [];
  let right = n - 1, left = 0, highestSquareIndex = n - 1;

  while (left <= right) {
    let leftSquare = Math.pow(arr[left], 2),
    rightSquare = Math.pow(arr[right], 2);

    if (leftSquare < rightSquare) {
      squares[highestSquareIndex] = rightSquare
      right -= 1;
    } else {
      squares[highestSquareIndex] = leftSquare
      left += 1;
    } 
    highestSquareIndex -= 1;
  }
  return squares;
};

/*

Time complexity #
The time complexity of the above algorithm will be O(N)O(N) as we are iterating the input array only once.

Space complexity #
The space complexity of the above algorithm will also be O(N)O(N); this space will be used for the output array.

*/


