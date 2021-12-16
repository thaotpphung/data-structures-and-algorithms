package array;

// https://leetcode.com/problems/maximum-subarray/

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
*/

/*
dynamic programming -> kadane algorithm
maxAtIndex = Max of (maxAt(Index - 1) + nums[i]) and nums[i])
*/
public class maximumSubarray {
  public int maxSubArray(int[] nums) {
    int globalMax = nums[0];
    int localMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
        localMax = Math.max(localMax + nums[i], nums[i]);
        globalMax = Math.max(localMax, globalMax);
    }
    return globalMax;
  }
}
