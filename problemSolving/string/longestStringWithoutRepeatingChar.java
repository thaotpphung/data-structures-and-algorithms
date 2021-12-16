package string;

// Time Complexity: O(n); Space Complexity: O(n)
class Solution {
  public int lengthOfLongestSubstring(String s) {
      // edge case
      if (s == null || s.length() == 0) return 0;
      
      int maxLength = 0;
      Map<Character,Integer> indexMap = new HashMap<>();
      int start = 0;
      
      for (int end = 0; end < s.length(); end++) {
          // if character exists in the map already, it means that the character is repeated
          if (indexMap.containsKey(s.charAt(end))) {
              // reset the start position to be one after the previous position of the repeating character -> indexMap.get(s.chartAt(end)) + 1
              // note that the start position will always have to be incremented
              // if indexMap.get(s.chartAt(end)) + 1 < start, don't need to reset the start anymore
              /*
              ex: abba 
              
              at end = 2. start = 0, character b is repeated,
              indexMap.get(s.chartAt(end)) = 1 -> indexMap.get(s.chartAt(end)) + 1 = 2
              2 > start = 0 => start = indexMap.get(s.chartAt(end)) + 1 = 2
              
              at end = 3, start = 2, character a is repeated
              indexMap.get(s.chartAt(end)) = 0 -> indexMap.get(s.chartAt(end)) + 1 = 1
              1 < start = 2 => start = 2, not change back to indexMap.get(s.chartAt(end)) + 1 = 1
              because otherwise if start = 1 again, we'll encounter repeated b again
              */
              start = Math.max(start, indexMap.get(s.charAt(end)) + 1);
          }
          indexMap.put(s.charAt(end), end);
          maxLength = Math.max(maxLength, end - start + 1);
      }
      return maxLength;
  }
}

