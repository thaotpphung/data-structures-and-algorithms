/*
EASY

Problem Statement #
Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
*/

const smallest_subarray_with_given_sum = function(s, arr) {
  let start = 0,
  minLen = Infinity;
  winSum = 0;

  // first, add to window sum until it reaches s or greater
  // remember that sub array length as minLen
  // shrink the array while make sure its sum is still >= s
  // assign new sub array to be minLen
  for (let end = 0; end < arr.length; end++) {
    winSum += arr[end];
    while (winSum >= s) {
      // capture the min length
      minLen = Math.min(minLen, end - start + 1);
      // then shrink the window
      winSum -= arr[start];
      start++;
    }
  }

  if (minLen == Infinity) {
    return 0;
  }

  return minLen;
};


// Time Complexity #
// The time complexity of the above algorithm will be O(N)O(N). The outer for loop runs for all elements and the inner while loop processes each element only once, therefore the time complexity of the algorithm will be O(N+N)O(N+N) which is asymptotically equivalent to O(N)O(N).

// Space Complexity #
// The algorithm runs in constant space O(1)O(1).

