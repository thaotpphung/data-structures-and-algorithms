/*
EASY
Problem Statement #
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Example 1:

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
*/

const pair_with_targetsum = function(arr, target_sum) {
  let left = 0,
  right = arr.length - 1;
  /* 
  because it's a sorted array, add numbers at both end and check for condition until the sum = target_sum
  condition: if sum > target_sum -> need to decrement the end
              if sum < target_sum -> need to increment the start
  repeat until sum = target_sum or when left == right
  */
  while (left < right) {
    const sum = arr[left] + arr[right];
    if (sum == target_sum) {
      return [left, right];
    }

    if (sum > target_sum) {
      right -= 1;
    } else {
      left += 1;
    } 
  }
  return [-1, -1];
}

/* 
Time Complexity #
The time complexity of the above algorithm will be O(N), where ‘N’ is the total number of elements in the given array.

Space Complexity #
The algorithm runs in constant space O(1).

*/

/* alternative approach using hash table 
Instead of using a two-pointer or a binary search approach, we can utilize a HashTable to search for the required pair. We can iterate through the array one number at a time. Let’s say during our iteration we are at number ‘X’, so we need to find ‘Y’ such that “X + Y == TargetX+Y==Target”. We will do two things here:

Search for ‘Y’ (which is equivalent to “Target−X”) in the HashTable. If it is there, we have found the required pair.
Otherwise, insert “X” in the HashTable, so that we can search it for the later numbers.
*/

function pair_with_target_sum(arr, targetSum) {
  const nums = {}; // Hash table to store numbers and their indices 
  // 1,2,3,4,5,6   target = 6
  for (let i = 0; i < arr.length; i++) {
    const num = arr[i];   // num = arr[3] = 4
    if ( (targetSum - num) in nums) {     // targetSum - num = 6 - 4 = 2, 2 is in hash map
      return [nums[targetSum - num], i];  // nums[2] = 2 => return (1, 3)
    }
    nums[arr[i]] = i;
    /*
    hashmap nums:
    {1 - 0}
    {2 - 1}
    {3 - 2}
    */
  }
  
  return [-1, -1];
}

console.log(pair_with_target_sum([1, 2, 3, 4, 6], 6));
console.log(pair_with_target_sum([2, 5, 9, 11], 11));


/*
Time Complexity #
The time complexity of the above algorithm will be O(N)O(N), where ‘N’ is the total number of elements in the given array.

Space Complexity #
The space complexity will also be O(N)O(N), as, in the worst case, we will be pushing ‘N’ numbers in the HashTable.
*/