package com.example.problems.Algorithms;

/**
 * @author Orhan Polat
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float arrLen = arr.size();
        Map<Integer,Long> counts = arr.stream().collect(Collectors.groupingBy(
                Integer::signum, Collectors.counting()));

        float positiveCount = counts.getOrDefault(1,0L);
        float negativeCount = counts.getOrDefault(-1,0L);
        float zeroCount = counts.getOrDefault(0,0L);

        System.out.printf(Locale.US, "%.6f%n", positiveCount / arrLen);
        System.out.printf(Locale.US, "%.6f%n", negativeCount / arrLen);
        System.out.printf(Locale.US, "%.6f%n", zeroCount / arrLen);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        plusMinus(arr);

        bufferedReader.close();
    }
}
