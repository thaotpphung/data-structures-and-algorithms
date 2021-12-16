/*
MEDIUM
Problem Statement #
Given a string, find the length of the longest substring in it with no more than K distinct characters.

You can assume that K is less than or equal to the length of the given string.

Example 1:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
Example 2:

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
Example 3:

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

*/

import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    if (str == null || str.length() == 0 || str.length() < k)
      throw new IllegalArgumentException();
    
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    // in the following loop we'll try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      // put the current char in the map => key
      // increment the count of current char if exists, else set to 0
      charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1); 
      // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
      while (charFrequencyMap.size() > k) {
        // start from the left,
        char leftChar = str.charAt(windowStart);
        // decrement the count of going out character
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1); 
        // if after decrement, the count is 0 then remove the element in order to size count to be correct
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.remove(leftChar);
        }
        windowStart++; // shrink the window
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
    }

    return maxLength;
  }
}

/*
Time Complexity #
The above algorithm’s time complexity will be O(N)O(N), where NN is the number of characters in the input string. The outer for loop runs for all characters, and the inner while loop processes each character only once; therefore, the time complexity of the algorithm will be O(N+N)O(N+N), which is asymptotically equivalent to O(N)O(N).

Space Complexity #
The algorithm’s space complexity is O(K)O(K), as we will be storing a maximum of K+1K+1 characters in the HashMap.
*/