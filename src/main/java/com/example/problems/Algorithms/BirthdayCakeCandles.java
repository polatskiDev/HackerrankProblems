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
public class BirthdayCakeCandles {

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        candles.sort(Comparator.reverseOrder());
        int count = 1;
        int maxVal = candles.get(0);
        for(int i = 1; i< candles.size(); i++) {
            if (maxVal == candles.get(i)) {
                count++;
            } else
                return count;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = birthdayCakeCandles(candles);
        System.out.println(result);

        bufferedReader.close();
    }
}
