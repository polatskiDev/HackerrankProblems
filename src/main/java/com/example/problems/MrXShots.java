package com.example.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/**
 * @author Orhan Polat
 */
public class MrXShots {

    public static int solve(List<List<Integer>> shots, List<List<Integer>> players) {
        // Write your code here

        shots.sort(Comparator.comparing(s -> s.get(0)));
        players.sort(Comparator.comparing(p -> p.get(0)));
        int count = 0;

        for (List<Integer> playerList : players) {
            Iterator<List<Integer>> iterator = shots.iterator();
            while (iterator.hasNext()) {
                List<Integer> shotList = iterator.next();
                if (shotList.get(0) > playerList.get(1))
                    break;
                if (shotList.get(1) < playerList.get(0)) {
                    iterator.remove();
                } else
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> shots = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                shots.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> players = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                players.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = solve(shots, players);
        System.out.println(result);

        bufferedReader.close();
    }
}
