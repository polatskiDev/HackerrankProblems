package com.example.problems.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/**
 * @author Orhan Polat
 */
public class MiniMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        arr.sort(Comparator.comparing(Integer::intValue));
        long minSum = arr.get(0);
        long maxSum = arr.get(4);
        long totalSum = 0L;
        for (int i =1; i < 4; i++) {
            totalSum += arr.get(i);
        }
        minSum += totalSum;
        maxSum += totalSum;

        System.out.println(minSum + " " + maxSum);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }
}
