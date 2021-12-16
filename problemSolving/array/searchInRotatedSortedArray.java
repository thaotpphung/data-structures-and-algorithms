package array;

/*
MEDIUM
You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
*/
public class searchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    // check edge cases
    if (nums == null || nums.length == 0)
      return -1;

    // pivot is the index of the smallest element of the array
    int pivot = findPivot(nums);

    // check which side to do binary search on
    int left = 0;
    int right = nums.length - 1;
    if (target >= nums[pivot] && target <= nums[right]) {
      // means that target is on the right side, so search on the right side by
      // setting left to pivot
      left = pivot;
    } else {
      // means that target is on the leftt side, so search on the left side by setting
      // right to pivot - 1
      right = pivot - 1;
    }

    // do binary search
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  // find index of smallest element in the array
  private int findPivot(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) { // means that mid is in the rotated part (the part before the pivot), needs to
                                     // narrow down the search for smallest element by setting left to after mid
                                     // point
        left = mid + 1;
      } else { // mid is in the part after the pivot, narrow down search for pivot by setting
               // the right to mid (bring the right closer to the pivot)
        right = mid;
      }
    }
    // now left = right
    return left;
  }
}
