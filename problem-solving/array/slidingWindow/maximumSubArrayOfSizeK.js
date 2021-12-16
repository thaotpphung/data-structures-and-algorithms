
/*
EASY
Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

Input: [2, 3, 4, 1, 5], k=2 
Output: 7
Explanation: Subarray with maximum sum is [3, 4].

*/
const max_sub_array_of_size_k = function(k, arr) {
  let windowSum = 0,
  maxSum = 0,
  start = 0;
  
  for (let end = 0; end < arr.length; end++) {
    // add to window sum
    windowSum += arr[end];
    if (end >= k - 1) {
      // if window size >= k
      maxSum = Math.max(windowSum, maxSum);
      windowSum -= arr[start];
      start++;
    }
  }
  
  return maxSum;
};
