/*
MEDIUM
Problem Statement #
Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Example 1:

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.

Example 2:

Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.

Example 3:

Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.

*/

const triplet_sum_close_to_target = function(arr, target_sum) {
  arr.sort((a,b) => a - b); // sort array nlogn
  let smallestDiff = Infinity;
  for (i = 0; i < arr.length; i++) {
    let low = i + 1; high = arr.length - 1;
    while (low < high) {
      let sum = arr[high] + arr[low] + arr[i];
      if (Math.abs(target_sum - sum) < Math.abs(smallestDiff)) { // set the smallest sum
        smallestDiff = target_sum - sum;
      }
      if (sum < target_sum) {
        low += 1;
      } else {
        high -= 1;
      }
    }
  }
  // return the closest sum by subtracting smallest diff between sum and target sum from target sum
  return target_sum - smallestDiff;
};

/*

Complexity Analysis

Time Complexity: \mathcal{O}(n^2)O(n 
2
 ). We have outer and inner loops, each going through nn elements.

Sorting the array takes \mathcal{O}(n\log{n})O(nlogn), so overall complexity is \mathcal{O}(n\log{n} + n^2)O(nlogn+n 
2
 ). This is asymptotically equivalent to \mathcal{O}(n^2)O(n 
2
 ).

Space Complexity: from \mathcal{O}(\log{n})O(logn) to \mathcal{O}(n)O(n), depending on the implementation of the sorting algorithm.

*/

