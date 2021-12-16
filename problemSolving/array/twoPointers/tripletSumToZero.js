/*
MEDIUM

Problem Statement #
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
*/

const search_triplets = function(arr) {
  arr.sort((a, b) => a - b); // sort the array first
  const triplets = [];
  for (let i = 0; i < arr.length; i++) {
    if (i > 0 && arr[i] === arr[i - 1]) {
      continue; // if there's duplicate, skip that element
    }
    // X + Y + Z = 0 -> Y + Z = -X
    // finda pair Y,Z whose sum is = -X 
    // search_pair (arr, target_sum = -X = -arr[i], the position to start search from (left), triplets)
    search_pair(arr, -arr[i], i + 1, triplets); 
  }
  return triplets;
};

function search_pair (arr, target_sum, left, triplets) {
  let right = arr.length - 1;
  while (left < right) {
    const current_sum = arr[left] + arr[right];
    if (current_sum == target_sum) { // found a triplet
      triplets.push([-target_sum, arr[left], arr[right]]);
      left += 1;
      right -= 1;
      while (left < right && arr[left] === arr[left - 1]) { // skip same element to avoid duplicate triplets
        left += 1;
      }
      while (left < right && arr[right] === arr[right + 1]) { // skip same element to avoid duplicate triplets
        right -= 1;
      }
    } else if (target_sum > current_sum) {
      left += 1; // -X > Y + Z -> we need Y+Z to be bigger -> increment
    } else {
      right -= 1; // -X < Y + Z -> we need Y+Z to be smaller -> decrement
    }
  }
}


/* 
Time complexity #
Sorting the array will take O(N * logN). The searchPair() function will take O(N). As we are calling searchPair() for every number in the input array, this means that overall searchTriplets() will take O(N * logN + N^2), which is asymptotically equivalent to O(N^2)

Space complexity #
Ignoring the space required for the output array, the space complexity of the above algorithm will be O(N) which is required for sorting.
*/