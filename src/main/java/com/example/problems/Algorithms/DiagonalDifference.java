package com.example.problems.Algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/**
 * @author Orhan Polat
 */
public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int len = arr.size();
        int primaryDiagonal = IntStream.range(0, len)
                .map(i -> arr.get(i).get(i))
                .sum();
        int secondaryDiagonal = IntStream.range(0, len)
                .map(i -> arr.get(i).get(len - 1 - i))
                .sum();
        return Math.abs(primaryDiagonal - secondaryDiagonal);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);
        System.out.println(result);
        bufferedReader.close();
    }
}
