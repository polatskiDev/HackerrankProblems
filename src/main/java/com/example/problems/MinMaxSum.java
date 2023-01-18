package com.example.problems;

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


public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MinMaxSumResult.miniMaxSum(arr);

        bufferedReader.close();
    }
}

class MinMaxSumResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long minNum = arr.get(0);
        long maxNum = arr.get(4);
        long total = 0;
        for (Integer num : arr){
            if(num < minNum)
                minNum = num;
            if (num> maxNum)
                maxNum = num;
            total += num;
        }
        long maxSum = total - minNum;
        long minSum = total - maxNum;
        System.out.println(minSum + " " + maxSum);
    }

}
