package com.example.problems.Algorithms;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/**
 * @author Orhan Polat
 */
public class AVeryBigSum {

    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        return ar.stream().reduce(0L, Long::sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long result = aVeryBigSum(ar);
        System.out.println(result);
        bufferedReader.close();
    }
}
