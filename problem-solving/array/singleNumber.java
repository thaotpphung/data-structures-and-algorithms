package array;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
*/
public class singleNumber {
     /* 
     #1 Hashset
     
     #2 bitwise XOR in Java 
        0 ^ N = N
        N ^ N = 0
    */
    
    // #2
//     public int singleNumber(int[] nums) {
       
//         int result = 0;
//         for (int i = 0; i < nums.length; i++) {
//             result ^= nums[i];
//         }
//         return result;
        
//     }
    
    // #1
    public int singleNumber(int[] nums) {
       
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
          // if set already contains nums[i], add will return false, so we will remove this element. In the end, only element left is the single element
          if (!set.add(nums[i])) {
              set.remove(nums[i]);
          } 
      }
      
      return set.iterator().next();
      
  }
    
}
}
