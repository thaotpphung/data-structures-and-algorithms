package misc.sorting;

public class heapSort {
  void heapSort (int arr[], int n) {
    // n / 2 - 1 is root index of the last sub-tree in the tree
    for (int i = n / 2 - 1; i >= 0; i--) 
      heapify(arr, n, i); // create a max heap from initial array

    for (int i = n - 1; i >=0; i--) {
      swap(arr, 0, i); // swap first and last node
      heapify(arr, i, 0); // create max heap on reduced array
    }
  }

  /*
  @param n: size of the heap to be heapify
  @param root: rootIndex of the heap
  */
  void heapify (int[] arr, int n, int rootIndex) {
    int largestIndex = rootIndex; // index of largest element
    int left = 2 * rootIndex + 1;
    int right = 2 * rootIndex + 2;

    // find the index of the largest element in the current heap
    if (left < n && arr[left] > arr[largestIndex]) 
      largestIndex = left;
    
    if (right < n && arr[right] > arr[largestIndex])
      largestIndex = right;
    
    // swap the largest element with the root of the heap if they're not already the same
    if (largestIndex != rootIndex) {
      swap (arr, rootIndex, largestIndex);
      // recursively heapify the affected sub-tree, with the largestIndex as the root of sub-tree
      heapify(arr, n, largestIndex);
    }
  }

  void swap (int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
