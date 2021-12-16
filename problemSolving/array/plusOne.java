package array;

public class plusOne {
  /**
   You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

    Increment the large integer by one and return the resulting array of digits.

    Solution: 
    add 1 to whatever digit that is < 9
    if a digit is 9, then it must be turned to 0, (also need to add 1 to its previous index)
    if we have been through the array but we haven't returned yet, that means the number must be something like : [9,9] so we need to increase the array size by 1 
    and assign 1 to be the first element
    
    ex: [1,3,9] -> [1,4,0], [9,9] -> [1,0,0]
    */
    public int[] plusOne(int[] digits) {
      int n = digits.length;
      for (int i = n - 1; i >= 0; i--) {
          if (digits[i] < 9) {
              digits[i]++; 
              return digits;
          }
          digits[i] = 0;
      }
      
      int[] newNum = new int[n + 1];
      newNum[0] = 1;
      return newNum;
  }
}
