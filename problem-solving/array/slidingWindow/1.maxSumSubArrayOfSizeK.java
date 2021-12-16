/*
EASY

Problem Statement #
Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.

Example 1:

Input: [2, 1, 5, 1, 3, 2], k=3 
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
Example 2:

Input: [2, 3, 4, 1, 5], k=2 
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
*/

class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int windowStart = 0;
    int windowSum = 0;
    int maxSum = 0;
    // loop through the array until the end
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      // add to the window sum
      windowSum += arr[windowEnd];
      // check if it is the end of a window
        // if (windowEnd - windowStart == k - 1) { => this is not necessary because after the first k - 1 
        // elements, everytime windowEnd increments, the size of window would always be enough i.e k
      if (windowEnd >= k - 1) {
        // compare maxSum and windowSum
        if (maxSum < windowSum) {
          maxSum = windowSum;
        }
        // subtract the element at the start
        windowSum -= arr[windowStart];
        // slide to the next window
        windowStart++;
      }
    }
    return maxSum;
  }
}


/*
Brute force

O(N*K)
*/

class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int maxSum = 0, windowSum;
    for (int i = 0; i <= arr.length - k; i++) {
      windowSum = 0;
      for (int j = i; j < i + k; j++) {
        windowSum += arr[j];
      }
      maxSum = Math.max(maxSum, windowSum);
    }

    return maxSum;
  }
  
  public static void main(String[] args) {
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
  }
}

/*
Time: O(N)
Space: O(1)
*/