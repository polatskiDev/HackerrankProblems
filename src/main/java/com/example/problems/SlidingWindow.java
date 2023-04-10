package com.example.problems;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author Orhan Polat
 */
public class SlidingWindow {

    public static void main(String[] args) {
        char [] valArray = {'1','3','6','7','8','4','2','2'};
        int digit = 4;
        System.out.println(calculateMaxProduct(valArray, digit));
        System.out.println(calculateWithStrem(valArray, digit));

    }

    private static int calculateMaxProduct(char[] valArr, int digit){
        int result = Integer.MIN_VALUE;
        for (int i = 0; i< valArr.length - digit; i++) {
            int subResult = 1;
            for (int j = i; j < i+digit; j++) {
               subResult *= Character.getNumericValue(valArr[j]);
            }
            result = Math.max(subResult, result);
        }
        return result;
    }

    private static int calculateWithStrem(char[] valArr, int digit) {

        OptionalInt maxResult = IntStream.range(0, valArr.length -digit +1)
                        .mapToObj(i -> new String(Arrays.copyOfRange(valArr,i, i+ digit)))
                        .map(str -> str.chars().map(Character::getNumericValue).reduce(1, (a,b) -> a *b))
                        .mapToInt(Integer::intValue)
                        .max();

        if (maxResult.isPresent()) {
            System.out.println("Max result: " + maxResult.getAsInt());
        } else {
            System.out.println("No sub-lists of length " + digit + " found in the input array.");
        }
        return maxResult.getAsInt();
    }
}
