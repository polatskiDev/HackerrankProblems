package com.example.problems.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/**
 * @author Orhan Polat
 */
public class CompareTheTriplets {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(0);
        resultList.add(0);
        for (int i = 0; i<a.size();i++){
            if (a.get(i) > b.get(i))
                resultList.set(0, resultList.get(0) +1);
            else if (a.get(i) < b.get(i))
                resultList.set(1, resultList.get(1) +1);
        }
        return resultList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);
        System.out.println(result);
        bufferedReader.close();
    }
}
