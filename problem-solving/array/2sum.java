package array;
import java.util.*;  

/*
EASY
https://leetcode.com/problems/two-sum/
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
*/

/*
Approach: 
Use HashMap to store element and its index (for returning index)
For each element, check if its complement exists in the HashMap
*/

// HashMap 2 Pass
class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> map = new HashMap<>();
    // put (element, its index) in the map, because we need to return the index
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    // check if the map contains the complement
    // if it does, it means that we found a pair, (nums[i], complement of nums[i])
    // (i, get(complement) to get index of complement)
    // in case complement = nums[i] => i = get(complement) => needs to check for
    // that
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] { i, map.get(complement) };
      }
    }
    throw new IllegalArgumentException("wrong");
  }
}

/*
 * Time complexity : O(n). We traverse the list containing nn elements only
 * once. Each look up in the table costs only O(1) time.
 * 
 * Space complexity : O(n). The extra space required depends on the number of
 * items stored in the hash table, which stores at most n elements.
 */

// HashMap 1 pass
class Solution2 {
  public int[] twoSum(int[] nums, int target) {
      
      Map<Integer,Integer> map = new HashMap<>();
      // put (element, its index) in the map, because we need to return the index
      for (int i = 0; i < nums.length; i++) {
          // check complement after adding an element
          // is more efficient because in optimal case, don't have to add as many element to hash map
          int complement = target - nums[i];
          if (map.containsKey(complement) && map.get(complement) != i) {
              return new int[] {i, map.get(complement)};
          }
          map.put(nums[i], i);
      }
      throw new IllegalArgumentException("No two sum solution");
  }
}