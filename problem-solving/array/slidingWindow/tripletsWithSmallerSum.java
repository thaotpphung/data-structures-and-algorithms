import java.util.*;

class TripletWithSmallerSum {

  public static int searchTriplets(int[] arr, int target) {
    Arrays.sort(arr);
    int count = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      int left = i + 1;
      int right = arr.length - 1;
      while (left < right) {
        int sum = arr[left] + arr[right] + arr[i];
        if (sum < target) {
          count += right - left; // any sum less than when we found the spot when sum < target is valid
          left++;
        } else {
          right--; // we need a pair with smaller sum
        }
      }
    }

    return count;
  }
}