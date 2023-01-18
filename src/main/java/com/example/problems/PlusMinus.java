package com.example.problems;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        arr.sort(Collections.reverseOrder());
        float negativeCount = 0;
        float positiveCount = 0;
        float zeroCount = 0;
        float arrLen = arr.size();

        for (Integer num : arr){
            if (num > 0){
                positiveCount++;
            }
            if( num == 0){
                zeroCount++;
            }
            if (num < 0) {
                negativeCount++;
            }
        }
        System.out.printf(Locale.US, "%.6f%n", positiveCount / arrLen);
        System.out.printf(Locale.US, "%.6f%n", negativeCount / arrLen);
        System.out.printf(Locale.US, "%.6f%n", zeroCount / arrLen);
    }

}
