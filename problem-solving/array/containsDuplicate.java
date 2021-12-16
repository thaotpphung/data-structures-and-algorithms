package array;
import java.util.*;  

// 1. Sort
public class containsDuplicate {
  public boolean containsDuplicate(int[] nums) {
      Arrays.sort(nums);
      for (int i = 1; i < nums.length; i++) {
          if (nums[i] == nums[i - 1]) {
              return true;
          }
      }
      return false;
  }



/*
Time complexity : O(n log n). Sorting is O(n log n) and the sweeping is O(n). The entire algorithm is dominated by the sorting step, which is O(n \log n)

Space complexity : O(1). Space depends on the sorting implementation which, usually, costs O(1) auxiliary space if heapsort is used.
*/


// 2. Hash Table

  public boolean containsDuplicate2(int[] nums) {
    Set<Integer> set = new HashSet<>(nums.length);
    for (int x: nums) {
        if (set.contains(x)) return true;
        set.add(x);
    }
    return false;
  }
}

/*
Time complexity : O(n). We do search() and insert(), each cost O(1) for n times and each operation takes constant time.

Space complexity : O(n). The space used by a hash table is linear with the number of elements in it.
*/