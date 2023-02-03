package com.example.problems;

import java.io.*;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TwoStacksQueue {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, n).forEach(tItr -> {
            try {
                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList());
                if (q.get(0) == 1){
                    stack1.push(q.get(1));
                }else {
                    if (stack2.isEmpty()){
                        while (!stack1.empty()){
                            stack2.push(stack1.peek());
                            stack1.pop();
                        }
                    }
                    if (!stack2.isEmpty()){
                        if (q.get(0) == 2){
                            stack2.pop();
                        }else{
                            System.out.println(stack2.peek());
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bufferedReader.close();
        //bufferedWriter.close();
    }
}
