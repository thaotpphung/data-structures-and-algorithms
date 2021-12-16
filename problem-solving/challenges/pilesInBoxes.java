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

/*
https://leetcode.com/discuss/interview-question/364618Microsoft-or-OA-2019-or-Min-Steps-to-Make-Piles-Equal-Height

https://leetcode.com/discuss/interview-question/390456/Google-or-Phone-Screen-or-Piles-of-Boxes/350904
*/

class Result {

    /*
     * Complete the 'pilesOfBoxes' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY boxesInPiles as parameter.
     */

    public static long pilesOfBoxes(List<Integer> boxesInPiles) {
        if (boxesInPiles == null || boxesInPiles.size() == 0){
            return 0;
        }
        
        long steps = 0;
        Collections.sort(boxesInPiles, Collections.reverseOrder());
        
        for( int i = 1; i < boxesInPiles.size(); i++){
            if(boxesInPiles.get(i) < boxesInPiles.get(i - 1)){
                steps += i;
            }
        }
        return steps;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int boxesInPilesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> boxesInPiles = IntStream.range(0, boxesInPilesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.pilesOfBoxes(boxesInPiles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
