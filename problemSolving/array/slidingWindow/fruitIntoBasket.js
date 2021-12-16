/*
MEDIUM
Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
*/

// longest substring with k distict char when k = 2
const fruits_into_baskets = function(fruits) {
  let start = 0,
  frequencyMap = {},
  maxlen = 0;

  for (let end = 0; end < fruits.length; end++) {
    // fill frequency char
    const rightChar = fruits[end]; // right char is char at the end index
    // increment count
    // edge case: if right char has not been added to the map, need to create new entry
    if (!(rightChar in frequencyMap)) {
      frequencyMap[rightChar] = 0;
    }
    frequencyMap[rightChar]++;
    // shrink the window until the character count is 2 again
    while (Object.keys(frequencyMap).length > 2) {
      const leftChar = fruits[start];
      frequencyMap[start]--;
      if (frequencyMap[leftChar] == 0) {
        delete frequencyMap[leftChar];
      }
      start++;
    }
    // assign the new max length
    maxlen = Math.max(maxlen, end - start + 1);
  }
  return maxlen;
};

// Time Complexity #
// The time complexity of the above algorithm will be O(N) where ‘N’ is the number of characters in the input array. The outer for loop runs for all characters and the inner while loop processes each character only once, therefore the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N)

// Space Complexity #
// The algorithm runs in constant space O(1) as there can be a maximum of three types of fruits stored in the frequency map.