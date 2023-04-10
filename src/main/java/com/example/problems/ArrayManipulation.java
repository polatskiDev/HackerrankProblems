package com.example.problems;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/**
 * @author Orhan Polat
 */
public class ArrayManipulation {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        long[] arr = new long[n];

        for (List<Integer> subQuery : queries) {
            int fromIndex = subQuery.get(0) - 1;
            int toIndex = subQuery.get(1) - 1;
            int value = subQuery.get(2);

            arr[fromIndex] += value;
            if (toIndex + 1 < n) {
                arr[toIndex + 1] -= value;
            }
        }

        long max = 0;
        long prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum > max) {
                max = prefixSum;
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = arrayManipulation(n, queries);
        System.out.println(result);

        bufferedReader.close();
    }
}
