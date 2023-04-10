package com.example.problems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Orhan Polat
 */
public class TwoDArrayDs {

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        return IntStream.range(0, arr.get(0).size() -2)
                .flatMap(i-> IntStream.range(0, arr.get(0).size()-2)
                        .map(j -> arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2)
                                + arr.get(i+1).get(j+1)
                                + arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2)))
                .max()
                .getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
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

        int result = hourglassSum(arr);

        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
