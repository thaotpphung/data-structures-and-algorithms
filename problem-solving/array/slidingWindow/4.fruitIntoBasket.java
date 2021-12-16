/*
MEDIUM
Problem Statement #
Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both baskets.

Example 1:

Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
Example 2:

Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
*/

import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(final char[] arr) {
    Map<Character, Integer> charCount = new HashMap<>();
    int winStart = 0;
    int maxNum = 0;
    for (int winEnd = 0; winEnd < arr.length; winEnd++) {
      char rightChar = arr[winEnd];
      charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
      // shrink the window until size is == 2
      while (charCount.size() > 2) {
        char leftChar = arr[winStart];
        charCount.put(leftChar, charCount.getOrDefault(leftChar, 0) - 1);
        if (charCount.get(leftChar) == 0) {
          charCount.remove(leftChar);
        }
        winStart++;
      }

      maxNum = Math.max(maxNum, winEnd - winStart + 1);

    }
    return maxNum;
  }
}

/*
Time Complexity #
The above algorithm’s time complexity will be O(N)O(N), where ‘N’ is the number of characters in the input array. The outer for loop runs for all characters, and the inner while loop processes each character only once; therefore, the time complexity of the algorithm will be O(N+N)O(N+N), which is asymptotically equivalent to O(N)O(N).

Space Complexity #
The algorithm runs in constant space O(1)O(1) as there can be a maximum of three types of fruits stored in the frequency map.

*/
