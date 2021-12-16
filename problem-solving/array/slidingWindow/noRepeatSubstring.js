/*
HARD
Problem Statement #
Given a string, find the length of the longest substring which has no repeating characters.

Example 1:

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".

We can use a HashMap to remember the last index of each character we have processed. Whenever we get a repeating character we will shrink our sliding window to ensure that we always have distinct characters in the sliding window.

*/

const non_repeat_substring = function(str) {
  let charIndexMap = {},
  start = 0,
  maxLen = 0;


  for (let end = 0; end < str.length; end++) {
    const rightChar = str[end];
    if (rightChar in charIndexMap) { 
      // if found the character at end index to be in the map, it means that ther has already been that char in the map, with the index of the first occurence of this character
      // There're two cases when reset the start index
      /* 1. abccd -> repeating char is c, last apperance is at 2, which leads to new start index = map(c) + 1 = 2 + 1 = 3. next distict char is d, which hasn't appeared before, so next distinct subset is "cd"
       2. abbaa -> first repeating : b , when encouter the second b 
       -> b hasn't appeared before ->  reset start = map(b) + 1 = 1 + 1 = 2.
       now start = 2
       end is now at index 3, a is unique 'ba', put in map (a, 3), length = 
       end is now at index 4, a is not unique.
        start = 2
        map.get(a) = 3, > 2 -> 
       so if reset start = map(a) + 1 = 0 + 1 = 1 -> length = 3 - 1 + 1 = 3 -> WRONG
       SO if next distinct char appear before, check if start is already ahead of that index, if it is ahead then simply keep start = start.
      */
      // have a repeating character, need to shrink the window
      start = Math.max(start, charIndexMap[rightChar] + 1)
    }
    charIndexMap[rightChar] = end;
    maxLen = Math.max(maxLen, end - start + 1);
  }
  return maxLen;
};

/* 
Time Complexity #
The time complexity of the above algorithm will be O(N)where ‘N’ is the number of letters in the input string.

Space Complexity #
As we are expecting only the lower case letters in the input string, we can conclude that the space complexity will be O(26), to store each letter’s frequency in the HashMap, which is asymptotically equal to O(1).
*/
