package misc.searching;
class BinarySearch {
  // Returns index of x if it is present, else return -1
  int binarySearchRecursive(int arr[], int left, int right, int x) {
    if (right >= left) {
      int mid = left + (right - left) / 2;

      // If the element is present at the middle itself, we found the element
      if (arr[mid] == x)
        return mid;

      // If element is smaller than mid, then it can only be present in left subarray
      if (arr[mid] > x)
        return binarySearchRecursive(arr, left, mid - 1, x);

      // Else the element can only be present in right subarray
      return binarySearchRecursive(arr, mid + 1, right, x);
    }
    return -1;
  }

  int binarySearch(int arr[], int x) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      // compute mid index
      int mid = left + (right - left) / 2;

      // if x is present at mid, we found x
      if (arr[mid] == x)
        return mid;

      // If x greater that element at mid, ignore the left part before mid 
      if (arr[mid] < x)
        left = mid + 1;

      // If x is smaller that element at mid, ignore right half after mid
      else
        right = mid - 1;
    }

    // if we reach here, then element was not present
    return -1;
  }

  // Driver method to test above
  public static void main(String args[]) {
    BinarySearch ob = new BinarySearch();
    int arr[] = { 2, 3, 4, 10, 40 };
    int n = arr.length;
    int x = 10;
    int result = ob.binarySearchRecursive(arr, 0, n - 1, x);
    if (result == -1)
      System.out.println("Element not present");
    else
      System.out.println("Element found at index " + result);
  }

}

/*
sorting the n-item vector is ∈ O(lg n)

• for our purposes, the simplest definition of a logarithm is
  How many times can you divide a number n by 2 (using integer division) before the result is 1 or 0?  
• binary search works by dividing the size of the vector by two for each recursion
• this division is what causes the algorithm to have logarithmic analysis

*/