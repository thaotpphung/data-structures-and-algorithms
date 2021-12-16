package array;

class rotateArray {
  /*
  Medium - https://leetcode.com/problems/rotate-array/

  #1: brute force
      nested for loop, move each element to the right k times 
          time: O(n * k)
          space: O(1)
          
  #2: extra array
      correct index of each element: i + k % n
  
  #3: using reverse
  nums = "----->-->"; k =3
  result = "-->----->";

  reverse "----->-->" we can get "<--<-----"
  reverse "<--" we can get "--><-----"
  reverse "<-----" we can get "-->----->"

  note: need to modular k in case k > len -> k = k % len, for ex: k = 3, 10, len = 7 both move 3 = 3 % 7 or 10 % 7

  
  */
  // #2
  // public void rotate(int[] nums, int k) {
  //     int n = nums.length;
  //     int[] copy = new int[nums.length];
  //     for (int i = 0; i < n; i++) {
  //         int correctIndex = (i + k) % n;
  //         copy[correctIndex] = nums[i];
  //     }
  //     for (int i = 0; i < n; i++) {
  //         nums[i] = copy[i];
  //     }
  // }
  
  // #3
  public void rotate(int[] nums, int k) {
      int n = nums.length;
      k = k % n; 
      // "----->-->" we can get "<--<-----"
      reverse(nums, 0, n - 1);
      // "<--" we can get "--><-----"
      reverse(nums, 0, k - 1);
      // "<-----" we can get "-->----->"
      reverse(nums, k, n - 1);
  }
  
  private void reverse(int[] nums, int start, int end) {
      while (start < end) {
          int temp = nums[start];
          nums[start] = nums[end];
          nums[end] = temp;
          start++;
          end--;
      }   
  }
}