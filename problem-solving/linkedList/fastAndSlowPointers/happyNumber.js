/*
MEDIUM
Problem Statement #
Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

Example 1:

Input: 23   
Output: true (23 is a happy number)  
Explanations: Here are the steps to find out that 23 is a happy number:
*/

const find_happy_number = function(num) {
  // happy number will be stuck in a cycle of 1
  // normal number will eventually get stuck, but not 1
  // we need to search until find a cycle and check if it's 1
    // first, we need to find a cycle by the fast and slow pointer method
    // because if a cycle exists, a fast and slow poitner are guaranteed to meet in a cycle
    // then we can check if the cycle are stuck at number 1
  let slow = num, fast = num
  while (true) {
    slow = find_square_sum (slow); // compute 1 ahead
    fast = find_square_sum (find_square_sum(fast)); // compute 2 ahead
    if (slow === fast)  // found the cycle 
    {
      break;
    }
  }
  return slow === 1; 
};

function find_square_sum (num) {
  let sum = 0; // 89
  while ((num > 0)) {                                             // num = 8 > 0        // num = 0
    // first, rem to get the right most digit so far                                       
    digit = num % 10;  // digit = 9.                              // digit = 8 % 10 = 8 
    // now add the square digit to sum
    sum += digit * digit; // sum += 9^2 = 0 += 81                 // sum = 9 * 9 + 8 * 8
    // now divide the sum by 10 to get the the next unit (100 -> 10 -> 0)
    num = Math.floor(num / 10); // num = math.floor(89/10) = 8.   // num = 8/10 = 0
  }
  return sum;
}

console.log(`${find_happy_number(23)}`)
console.log(`${find_happy_number(12)}`)