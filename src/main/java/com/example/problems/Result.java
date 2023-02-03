package com.example.problems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        int max;
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

    public static int towerBreakers(int n, int m) {
        // Write your code here
        return (n % 2 == 0 || m == 1) ? 2 : 1;
    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder finalResult = new StringBuilder();
        for (int i= 0; i< s.length(); i++){
            if (Character.isLetter(s.charAt(i))){
                if (Character.isUpperCase(s.charAt(i))) {
                    char ch = (char)(((int)s.charAt(i) + k - 65) % 26 + 65);
                    finalResult.append(ch);
                }
                else {
                    char ch = (char)(((int)s.charAt(i) + k - 97) % 26 + 97);
                    finalResult.append(ch);
                }
            } else
                finalResult.append(s.charAt(i));
        }
        return finalResult.toString();
    }

    public static int palindromeIndex(String s) {
        // Write your code here
        int low = 0, high = s.length() - 1;

        // loop until low and
        // high cross each other
        while (low < high)
        {

            // If both characters are equal then
            // move both pointer towards end
            if (s.charAt(low) == s.charAt(high))
            {
                low++;
                high--;
            }
            else
            {

                /*
                 * If removing str[low] makes the
                 * whole string palindrome. We basically
                 * check if substring str[low+1..high]
                 * is palindrome or not.
                 */
                if (isPalindrome(s, low + 1, high))
                    return low;

                /*
                 * If removing str[high] makes the whole string
                 * palindrome. We basically check if substring
                 * str[low+1..high] is palindrome or not.
                 */
                if (isPalindrome(s, low, high - 1))
                    return high;
                return 0;
            }
        }

        // We reach here when complete string
        // will be palindrome if complete string
        // is palindrome then return mid character
        return -1;
    }

    static boolean isPalindrome(String str, int low, int high) {
        while (low < high)
        {
            if (str.charAt(low) != str.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        boolean result = true;
        List<String> gridList = new ArrayList<>();
        for (int i=0; i< grid.size(); i++){
            char [] gridArray = grid.get(i).toCharArray();
            Arrays.sort(gridArray);
            gridList.add(new String(gridArray));
        }
        for (int x= 0; x< grid.get(0).length(); x++){
            for (int y = 1; y < grid.size(); y++){
                if (gridList.get(y).charAt(x) < gridList.get(y-1).charAt(x)) {
                    result = false;
                    break;
                }
            }
        }
        return result ? "YES" : "NO";
    }

    public static int superDigit(String n, int k) {
        // Write your code here
        int temp = findSum(n) * k ;
        if (temp > 9)
            temp = findSum(String.valueOf(temp));
        return temp;
    }

    private static int findSum(String num){
        if (num.length() == 1)
            return Integer.parseInt(num);
        int sum = 0;
        for (int x =0; x< num.length(); x++){
            sum = sum + Integer.parseInt(String.valueOf(num.charAt(x)));
        }
        return findSum(String.valueOf(sum));
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribeNo = 0;
        boolean chaotic = false;
        for (int i = 0; i < q.size(); i++){
            if (q.get(i) - (i+1) > 2){
                chaotic = true;
                break;
            }
            for (int j = i - 1; j >= q.get(i) - 2 && j >= 0; j--) {
                if (q.get(j) > q.get(i))
                    bribeNo++;
            }
        }
        if (!chaotic){
            System.out.println(bribeNo);
        } else {
            System.out.println("Too chaotic");
        }
    }

    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here
        final int size = petrolpumps.size();

        for (int start = 0; start < size; start++) {
            if (petrolpumps.get(start).get(0) < petrolpumps.get(start).get(1)) continue;

            long tank = 0;
            int position = start;
            int pumpCount = 0;

            while (true) {
                if (pumpCount == size) return start; // all pumps has been visited
                if (tank < 0) break;                 // not enough petrol to move further

                tank += petrolpumps.get(position % size).get(0) - petrolpumps.get(position % size).get(1);

                position++;
                pumpCount++;
            }
        }
        return -1;
    }
}
