package array;

public class containerWithMostWater {
  /*
   Because the width is always decreasing. The only way to get a larger area is
   to increase the height of the rectangle. And since the height is determined
   by the shorter end, you move the shorter end in the hope of increasing the
   height of the rectangle.
   */

  public int maxArea(int[] height) {
    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;

    while (left < right) {
      if (height[left] < height[right]) {
        maxArea = Math.max(maxArea, height[left] * (right - left));
        left++;
      } else {
        maxArea = Math.max(maxArea, height[right] * (right - left));
        right--;
      }
    }

    return maxArea;
  }
}
