package misc.sorting;

public class mergeSort {
  public void mergeSort(int[] array) {
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
  }

  private void mergeSort(int[] array, int[] helper, int low, int high) {
    if (low < high) {
      int middle = (low + high) / 2;
      mergeSort(array, helper, low, middle);
      mergeSort(array, helper, middle + 1, high);
      merge(array, helper, low, middle, high);
    }
  }

  private void merge(int[] array, int[] helper, int low, int middle, int high) {
    // copy content of current merge range (both halves) to helper array
    for (int i = low; i <= high; i++) {
      helper[i] = array[i];
    }

    // pointer for helper array (helper array is used to compare 2 merge sides without having to create separate sub arrays)
    int helperLeft = low;
    int helperRight = middle + 1;
    int mainCurrent = low;

    // merge by copying smaller element of the two halves to the main array
    while (helperLeft <= middle && helperRight <= high) {
      if (helper[helperLeft] <= helper[helperRight]) {
        array[mainCurrent] = helper[helperLeft];
        helperLeft++;
      } else {
        array[mainCurrent] = helper[helperRight];
        helperRight++;
      }
      mainCurrent++;
    }

    // after either helperLeft or helperRight reaches their maximum and exits the while loop, we need to copy the rest of the elements of whichever side that still have more elements back to main array
    // note that we don't need to copy the right side if it is the remaining side, because at the beginning the remaining elements have always been at the end of the right side
    int remaining = middle - helperLeft;
    for (int i = 0; i <= remaining; i++) {
      array[mainCurrent + i] = helper[helperLeft + i];
    }
  }
}
