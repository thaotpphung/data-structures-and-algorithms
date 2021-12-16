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
https://leetcode.com/discuss/interview-question/428244/Cutting-Metal-Audible-Online-Assesment
https://www.hackerrank.com/contests/juniper-hackathon/challenges/metals/forum
*/

class Result {

  /*
   * Complete the 'maxProfit' function below.
   *
   * The function is expected to return an INTEGER. The function accepts following
   * parameters: 1. INTEGER costPerCut 2. INTEGER salePrice 3. INTEGER_ARRAY
   * lengths
   */
    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {

        // int maxLength = 0;
    	// for (int length : lengths) {
    	// 	if (length > maxLength) {
    	// 		maxLength = length;
    	// 	}
    	// }
    	
    	// int maxProfit = 0;
    	
    	// for (int i = 1; i < maxLength; i++) {
    		
    	// 	int sumOfLengths = 0;
        // 	int sumOfCutCounts = 0;
        // 	int sumOfCutWastes = 0;
    		
    	// 	for (int length : lengths) {
    			
        // 		sumOfLengths += length;
        		
        // 		if (length % i == 0) {
        // 			sumOfCutCounts += (length/i - 1);
        // 		} else {
        // 			sumOfCutCounts += (length/i);
        // 		}
        		
        // 		sumOfCutWastes += (length%i);
        // 	}
    		
    	// 	int profit = sumOfLengths*salePrice - sumOfCutCounts*costPerCut - sumOfCutWastes*salePrice;
    		
    	// 	if (profit > maxProfit) {
    	// 		maxProfit  = profit;
    	// 	}
    	// }
    	
        // return maxProfit;
        

        int maxLength = 0;
        // Find the maximum rod length
        for (int currentLength : lengths) {
            maxLength = Math.max(maxLength, currentLength);
        }

        int currentProfit = 0;
        int totalRods = 0;
        int totalCuts = 0;
        // For each rod length, calculate the profit
        for (int currentLength = 1; currentLength < maxLength; currentLength++) {
            totalRods = 0;
            totalCuts = 0;

            // Cut each rod into smaller rod of size currentLength
            // Count total rods and total cuts
            for (int length : lengths) {
                totalRods += (length / currentLength);
                totalCuts += ((length - 1) / currentLength);
            }

            // Calculate the current profit
            currentProfit = totalRods * currentLength * salePrice - totalCuts * costPerCut;

            // Calculate the maximum profit
            maxProfitResult = Math.max(maxProfitResult, currentProfit);
        }

        return maxProfitResult;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int costPerCut = Integer.parseInt(bufferedReader.readLine().trim());

        int salePrice = Integer.parseInt(bufferedReader.readLine().trim());

        int lengthsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> lengths = IntStream.range(0, lengthsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.maxProfit(costPerCut, salePrice, lengths);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
