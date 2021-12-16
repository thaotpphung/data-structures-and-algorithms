/*
EASY
 Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 */

class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int windowStart = 0;
    int minLen = Integer.MAX_VALUE;
    int winLen;
    int winSum = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      winSum += arr[windowEnd]; // add the next element to the sum
      while (winSum >= S) {
        winLen = windowEnd - windowStart + 1; // current length of window
        minLen = Math.min(winLen, minLen);  // choose the smaller one to be min length
        winSum -= arr[windowStart];  // subtract the element going out as window slides
        windowStart++; // shrink the window by moving start forward
      } 
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
}

/*
Time Complexity #
The time complexity of the above algorithm will be O(N)O(N). The outer for loop runs for all elements, and the inner while loop processes each element only once; therefore, the time complexity of the algorithm will be O(N+N)O(N+N), which is asymptotically equivalent to O(N)O(N).

Space Complexity #
The algorithm runs in constant space O(1)O(1).
*/
