/*
EASY

Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.

Example 1:

Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
Output: 4
Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].

*/

function remove_element(arr, key) {
  nextNonReplaceIndex = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] !== key) {
      arr[nextNonReplaceIndex] = arr[i];
      nextNonReplaceIndex += 1;
    }
  }
  return nextNonReplaceIndex;
}


console.log(`Array new length: ${remove_element([3, 2, 3, 6, 3, 10, 9, 3], 3)}`);
console.log(`Array new length: ${remove_element([2, 11, 2, 2, 1], 2)}`);

/*
Time and Space Complexity: The time complexity of the above algorithm will be O(N)O(N), where ‘N’ is the total number of elements in the given array.

The algorithm runs in constant space O(1)O(1).
*/