/*
MEDIUM

Problem Statement #
Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

Example 1:

Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into 
one [1,5].

*/

class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }

  get_interval() {
    return "[" + this.start + ", " + this.end + "]";
  }
}


const merge = function(intervals) {
  if (intervals.length < 2) {
    return intervals;
  }

  // sort intervals by start number
  intervals.sort((a,b) => a.start - b.start);

  let prevStart = intervals[0].start,  // previous is the interval with the smaller start
  prevEnd = intervals[0].end
  mergedIntervals = [];

  for (let i = 1; i < intervals.length; i++) {
    currInterval = intervals[i];  
    if (currInterval.start < prevEnd) { // overlapping intervals, adjust the end of the merged interval
      prevEnd = Math.max(currInterval.end, prevEnd);
      // because a.end maybe > or < than b.end, so we have to compare those to find out the biggest end
    } else { // there is no overlap, add the interval to the merged list
      mergedIntervals.push(new Interval (prevStart, prevEnd)); 
      prevEnd = currInterval.end;
      prevStart = currInterval.start;
    }
  }
  // add the last interval
  mergedIntervals.push(new Interval(prevStart, prevEnd));
  return mergedIntervals;
};

merged_intervals = merge([new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)]);
result = "";
for(i=0; i < merged_intervals.length; i++) {
  result += merged_intervals[i].get_interval() + " ";
}
console.log(`Merged intervals: ${result}`)


merged_intervals = merge([new Interval(6, 7), new Interval(2, 4), new Interval(5, 9)]);
result = "";
for(i=0; i < merged_intervals.length; i++) {
  result += merged_intervals[i].get_interval() + " ";
}
console.log(`Merged intervals: ${result}`)


merged_intervals = merge([new Interval(1, 4), new Interval(2, 6), new Interval(3, 5)]);
result = "";
for(i=0; i < merged_intervals.length; i++) {
  result += merged_intervals[i].get_interval() + " ";
}
console.log(`Merged intervals: ${result}`)

/*
Time complexity #
The time complexity of the above algorithm is O(N * logN) where ‘N’ is the total number of intervals. We are iterating the intervals only once which will take O(N), in the beginning though, since we need to sort the intervals, our algorithm will take O(N * logN)

Space complexity #
The space complexity of the above algorithm will be O(N) as we need to return a list containing all the merged intervals. We will also need O(N) space for sorting. For Java, depending on its version, Collection.sort() either uses Merge sort or Timsort, and both these algorithms need O(N) space. Overall, our algorithm has a space complexity of O(N)
*/