import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countAnalogousArrays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY consecutiveDifference
     *  2. INTEGER lowerBound
     *  3. INTEGER upperBound
     */

    public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {
        // find sub array with largest absolute distance
        int maxDistance = Math.max( findExtremeSum(true, consecutiveDifference), 
                                    findExtremeSum(false, consecutiveDifference)
                                   ) ;
        return Math.max(0, upperBound - lowerBound + 1 - maxDistance);
    }
    
    // contiguous array with maximum sum -> return maximum sum
    // find the sub array the has the largest effect on the analogous array
    private static int findExtremeSum(boolean mode, List<Integer> nums) {
        int global = nums.get(0);
        int local = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (mode) { // max
                local = Math.max(local + nums.get(i), nums.get(i));
                global = Math.max(global, local);
            } else {
                local = Math.min(local + nums.get(i), nums.get(i));
                global = Math.min(global, local);
            }
            
        }
        return Math.abs(global);
    }

}
