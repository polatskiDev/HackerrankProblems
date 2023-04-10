package com.example.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/**
 * @author Orhan Polat
 */
public class DynamicArray {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here

        List<int[]> arr = new ArrayList<int[]>();
        for (int i = 0; i< n; i++){
            arr.add(new int[0]);
        }
        int lastAnswer = 0;
        List<Integer> resultList = new ArrayList<>();
        for (List<Integer> intList : queries) {
            int idx = (intList.get(1) ^ lastAnswer) % n;
            if (intList.get(0) == 1) {
                saveToArray(arr, idx, intList.get(2));
            } else {
                int size = arr.get(idx).length;
                lastAnswer = arr.get(idx)[intList.get(2) % size];
                resultList.add(lastAnswer);
            }
        }
        return resultList;

    }

    private static void saveToArray(List<int[]> arr, int idx, Integer val) {

        int[] newArr = new int[arr.get(idx).length + 1];
        int i;
        for (i = 0; i < arr.get(idx).length; i++) {
            newArr[i] = arr.get(idx)[i];
        }
        newArr[i] = val;

        arr.set(idx, newArr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
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

        List<Integer> result = dynamicArray(n, queries);
        System.out.println(result);
        /*bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
