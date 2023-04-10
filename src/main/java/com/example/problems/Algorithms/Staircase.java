package com.example.problems.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Orhan Polat
 */
public class Staircase {

    public static void staircase(int n) {
        // Write your code here
        char[] arr = new char[n];
        Arrays.fill(arr,' ');
        for (int i = n-1; i >=0 ; i--) {
            arr[i] = '#';
            System.out.println(arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        staircase(n);

        bufferedReader.close();
    }
}
