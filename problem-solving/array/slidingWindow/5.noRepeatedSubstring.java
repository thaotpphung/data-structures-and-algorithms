/*
HARD

Problem Statement #
Given a string, find the length of the longest substring, which has no repeating characters.

Example 1:

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".
Example 2:

Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".
Example 3:

Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
*/

import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
     int maxLength = 0;
    int windowStart = 0;
    Map<Character, Integer> charIndexMap = new HashMap<>();
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (charIndexMap.containsKey(rightChar)) {
        // check if the map already contains the 'rightChar'
          // if yes => repetition => need to shrink window
        if (charIndexMap.get(rightChar) >= windowStart ) {
          windowStart = charIndexMap.get(rightChar) + 1;
        }
      }
      charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
    }
    return maxLength;
  }
}

/*

Time Complexity #
The above algorithm’s time complexity will be O(N)O(N), where ‘N’ is the number of characters in the input string.

Space Complexity #
The algorithm’s space complexity will be O(K)O(K), where KK is the number of distinct characters in the input string. This also means K<=NK<=N, because in the worst case, the whole string might not have any repeating character, so the entire string will be added to the HashMap. Having said that, since we can expect a fixed set of characters in the input string (e.g., 26 for English letters), we can say that the algorithm runs in fixed space O(1)O(1); in this case, we can use a fixed-size array instead of the HashMap.

*/