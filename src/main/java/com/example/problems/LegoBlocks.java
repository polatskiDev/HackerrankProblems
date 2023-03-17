package com.example.problems;

import java.io.*;
import java.util.Scanner;
/**
 * @author Orhan Polat
 */
public class LegoBlocks {

    public static final int Max = 1001;
    public static int modMult(int x, int y, int module){

        int tempX = x > module ? x % module : x;
        int tempy = y > module ? y % module : y;
        int tempResult = (tempX) * (tempy);

        return tempResult > module ? (tempResult) % module : tempResult;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int module = 1000000007;
            System.out.println(countWays(m, n, module));
        }
        scanner.close();

    }

    private static long countWays(int n , int m , int module) {
        int[] solidWallArray = new int[Max]; // array is indexed by M for the give value of N
        int[] arrayNMWallCombos = new int[Max];
        int[] array1MWallCombos = new int[Max];

        for(int x = 1 ; x <= n ; x ++){


            /*
             * load array1MWallCombos
             */

            if(x == 1)
                array1MWallCombos[x] = 1;
            if(x == 2)
                array1MWallCombos[x] = 2;
            if(x == 3)
                array1MWallCombos[x] = 4;
            if(x == 4)
                array1MWallCombos[x] = 8;

            if(x >= 5){
                array1MWallCombos[x] =  ( (array1MWallCombos[x-1] % module) +
                        (array1MWallCombos[x-2] % module) +
                        (array1MWallCombos[x-3] % module) +
                        (array1MWallCombos[x-4] % module) ) % module;
            }


            /*
             * load arrayNMWallCombos
             */

            //long numCombsFor1MWall = array1MWallCombos[m];
            int temp = 1;

            for(int i = 1 ; i <= m ; i ++){
                temp = modMult(array1MWallCombos[x], temp, module);
            }
            arrayNMWallCombos[n] = temp;

        }

        for(int x = 1 ; x <= n ; x ++){
            /*
             * load solidWallArray
             */

            if(x == 1)
                solidWallArray[x] = 1;

            if(x == 2){
                solidWallArray[x] = ( getModPowerOf2(m, module) - 1 ) % module;
            }

            if(x == 3){
                //	System.out.println("Mod of 4 ^ 40 "+Solution.getModPowerOf2(2*N, module));
                //	System.out.println("Mod of 2 ^ 40 "+Solution.getModPowerOf2(N, module));
                //	System.out.println("Final Modded value "+  ( Solution.getModPowerOf2(2*N, module)  - 2 * Solution.getModPowerOf2(N, module) + 1 ) % module);
                solidWallArray[x] =  ( getModPowerOf2(2*m, module)  - 2 * getModPowerOf2(m, module) + 1 ) % module;
            }

            if(x == 4){
                solidWallArray[x] =  ( ( getModPowerOf2(3*m, module) - 3 *
                        getModPowerOf2(2*m, module) + 3 *
                        getModPowerOf2(m, module) - 1) ) % module;
            }

            if( x >= 5 ){

                solidWallArray[x] = arrayNMWallCombos[x];

                for(int i = 1 ; i <= x -1 ; i ++){
                    solidWallArray[x] -= (solidWallArray[i] * arrayNMWallCombos[x-i]) % module;
                }

            }
            while (solidWallArray[x] < 0 )
                solidWallArray[x] +=  module;

        }
        return solidWallArray[n];
    }

    public static int getModPowerOf2(int n , int modulo){

        int result = 2;

        for(int i = 1 ; i <= n-1 ; i ++){

            result = result % modulo;

            result = result << 1;

        }

        return result;

    }
}