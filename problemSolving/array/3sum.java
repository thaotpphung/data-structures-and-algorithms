package array;
import java.util.*;  ;
/*
MEDIUM
https://leetcode.com/problems/3sum/

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.
Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
*/
 
/*
Approach: 
use 2sum and 2 pointers
*/
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList<>();
      // for each element, check for duplicate before finding other 2 sum
      // because if we find two sum for the same number, we'll get 2 duplocate triplets
      for (int i = 0; i < nums.length - 2; i++) {
          if (i == 0 || (i > 0 && nums[i] != nums[i - 1]) ) {
              // target of 2 sum
              // 2 pointers
              int target = 0 - nums[i];
              int high = nums.length - 1;
              int low = i + 1;
              while (low < high ) {
                  int tempSum = nums[low] + nums[high];
                  if (tempSum == target) {
                      res.add(Arrays.asList(nums[low], nums[high], nums[i]));
                      // move both high and low because if move only one, we can never achieve the sum == target again
                      // avoid duplicate when move high and low, because
                      // [1,1,1,2,2] 
                      // 1 + 2 = target, add to res, low++
                      // next 1 we also get 1 + 2 = target => duplicate triplet
                      while (low < high &&  nums[low] == nums[low + 1]) low++;
                      while (low < high && nums[high] == nums[high - 1]) high --;
                      low++;
                      high--;
                  } else if (tempSum < target) {
                      low++;
                  } else {
                      high--;
                  }
              }  
          }
      }
      return res;
  }
}

/*
Time Complexity
Sorting: O(nlogn)
Two loops: O(n^2)
Duplicate check: O(n^2)
Total: O(n^2) + O(nlogn) -> O(n^2)

Space Complexity   = O(1)
*/