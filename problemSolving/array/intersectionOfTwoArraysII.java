package array;
/**
 Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */
public class intersectionOfTwoArraysII {
    /*
    #1: HashMap
    
    #2: Follow up 1: Array is sorted
    -- binary search approach
    
    #3: Follow up 2: What if nums1's size is small compared to nums2's size? Which algorithm is better?
    
    nums1 size = K, nums2 size = N, K << N
    => we'll do binary search for each element in nums1 in nums2. Each lookup is O(logN) so we have O(K log N)
    
    If K is small enough, O(K log N) < O(max(N, K) = O(N)), otherwise 2 pointers is a better approach
    
let's say A = [1, 2, 2, 2, 2, 2, 2, 2, 1], B = [2, 2]. For each element in B, we start a binary search in A. To deal with duplicate entry, once you find an entry, all the duplicate element is around that that index, so you can do linear search scan afterward.

Time complexity, O(K(logN) + N). Plus N is worst case scenario which you have to linear scan every element in A. But on average, that shouldn't be the case.
So Time complexity is O(K(logN) + c), c (constant) is number of linear scan you did.

    #4: Follow up 3: What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once
external sort 
    
    
    */
    
    // #1 hashmap
//     public int[] intersect(int[] nums1, int[] nums2) {
//         Map<Integer, Integer> map = new HashMap<>();
//         ArrayList<Integer> result = new ArrayList<>();
        
//         for (int num : nums1) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
        
//         for (int num : nums2) {
//             if (map.containsKey(num) && map.get(num) > 0) {
//                 result.add(num);
//                 map.put(num, map.get(num) - 1);
//             }
//         }
    
//        int[] r = new int[result.size()];
//        for(int i = 0; i < result.size(); i++)
//        {
//            r[i] = result.get(i);
//        }
    
//        return r;
//     }
    
    // #2 binary search
    public int[] intersect(int[] nums1, int[] nums2) {
      int i = 0;
      int j = 0;
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      List<Integer> result = new ArrayList<>();
      while (i < nums1.length && j < nums2.length) {
          if (nums1[i] == nums2[j]) {
              result.add(nums1[i]);
              i++;
              j++;
          } else if (nums1[i] > nums2[j]) {
              j++;
          } else {
              i++;
          }
      }
      
      int[] r = new int[result.size()];
     for(int k = 0; k < result.size(); k++)
     {
         r[k] = result.get(k);
     }
  
     return r;
      
  }
  
}
