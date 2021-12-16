/*
MEDIUM
*/

const longest_substring_with_k_distinct = function(str, k) {
  let start = 0,
  maxlen = 0,
  charFrequencyMap = {};

  for (let end = 0; end < str.length; end ++) {
    const rightChar = str[end];
    // increment the character count at the end index
    if (!(rightChar in charFrequencyMap)) {
      charFrequencyMap[rightChar] = 0; 
    }
    
    charFrequencyMap[rightChar] += 1;
    // shrink window if length of hash map > k =  shrink the sliding window, until we are left with // 'k' distinct characters in the char_frequency
    while (Object.keys(charFrequencyMap).length > k) { // the distict elements more than k
      const leftChar = str[start]; // char at start index = left
      charFrequencyMap[leftChar] -= 1; // decrease count because we're taking out that char
      if (charFrequencyMap[leftChar] == 0) {  
        // after decrement count, delete the char if count is 0
        // this is to make sure the count of total distict characters is correct
        delete charFrequencyMap[leftChar]; 
      }
      start += 1; // shrink the window from the start
    } 
    // remember max length so far
    maxlen = Math.max(maxlen, end - start + 1);
  }
  return maxlen;
};

// Time Complexity #
// The time complexity of the above algorithm will be O(N)O(N) where ‘N’ is the number of characters in the input string. The outer for loop runs for all characters and the inner while loop processes each character only once, therefore the time complexity of the algorithm will be O(N+N)O(N+N) which is asymptotically equivalent to O(N)O(N).

// Space Complexity #
// The space complexity of the algorithm is O(K)O(K), as we will be storing a maximum of ‘K+1’ characters in the HashMap.