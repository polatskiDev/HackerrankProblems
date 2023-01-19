package com.example.problems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Result {

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long minNum = arr.get(0);
        long maxNum = arr.get(4);
        long total = 0;
        for (Integer num : arr){
            if(num < minNum)
                minNum = num;
            if (num> maxNum)
                maxNum = num;
            total += num;
        }
        long maxSum = total - minNum;
        long minSum = total - maxNum;
        System.out.println(minSum + " " + maxSum);
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        arr.sort(Collections.reverseOrder());
        float negativeCount = 0;
        float positiveCount = 0;
        float zeroCount = 0;
        float arrLen = arr.size();

        for (Integer num : arr){
            if (num > 0){
                positiveCount++;
            }
            if( num == 0){
                zeroCount++;
            }
            if (num < 0) {
                negativeCount++;
            }
        }
        System.out.printf(Locale.US, "%.6f%n", positiveCount / arrLen);
        System.out.printf(Locale.US, "%.6f%n", negativeCount / arrLen);
        System.out.printf(Locale.US, "%.6f%n", zeroCount / arrLen);
    }

    public static String timeConversion(String s) {
        // Write your code here
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ssaaa");
            SimpleDateFormat finalFormat = new SimpleDateFormat("HH:mm:ss");
            return finalFormat.format(sdf.parse(s));
        }catch (ParseException e){
            System.out.println("error parsing!!");
        }
        return "";
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int n = arr.size();
        int medianLoc = n / 2;
        return arr.get(medianLoc);
    }

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        Collections.sort(a);
        int n = a.size();
        int nonLonely = a.get(0);
        for (int i = 1; i < n ; i= i + 2){
            if(nonLonely == a.get(i)){
                nonLonely = a.get(i+1);
            }else
                return nonLonely;
        }
        return nonLonely;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        int len = arr.size();
        int i =0;
        while (i< len) {
            for (List<Integer> innerList : arr){
                primaryDiagonal += innerList.get(i);
                secondaryDiagonal += innerList.get(len-1-i);
                i++;
            }
        }
        int total = primaryDiagonal - secondaryDiagonal;
        return Math.abs(total);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i<100; i++){
            returnList.add(0);
        }
        for(Integer num : arr){
            returnList.set(num, returnList.get(num)+1);
        }
        return returnList;
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int x = matrix.size() /2;
        int max = 0;
        int total = 0;
        for (int row = 0; row<x ; row++){
            for (int col = 0; col < x; col++){
                max = Integer.MIN_VALUE;
                max = Math.max(matrix.get(row).get(col), max);
                max = Math.max(matrix.get(row).get( 2*x-col-1),max);
                max = Math.max(matrix.get(2*x -row -1).get(col),max);
                max = Math.max(matrix.get(2*x - row -1).get(2*x - col - 1), max);
                total += max;
            }
        }
        return total;
    }
}
