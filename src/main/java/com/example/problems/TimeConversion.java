package com.example.problems;

import java.io.*;
import java.text.*;

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversionResult.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
class TimeConversionResult {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

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
}
