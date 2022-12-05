package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Advent5 {

    public static void main(String[] args) {
        Map<Integer, Stack<Character>> map = new TreeMap<>();
        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input5.txt"))) {
            for (String line; (line = br.readLine()) != null;) {
                list.add(line);
            }
            // line is not visible here.
        } catch (IOException e) {
            e.getStackTrace();
        }

        map = makeStack();
        for (int i = 7; i >= 0; i--) {
            int count = 0;
            char[] arr = list.get(i).toCharArray();
            for (int k = 0; k < arr.length; k++) {
                int t = -3;
                if (k > 0 && (t + k * 4) < arr.length) {
                    count++;
                    if (arr[t + k * 4] != ' ') {
                        System.out.print(arr[t + k * 4]);
                        map.get(count).push(arr[t + k * 4]);
                    }
                }
            }
            System.out.println();
        }

        for (int l = 10; l < list.size(); l++) {
            String[] strings = list.get(l).split(" ");
            int amout = Integer.parseInt(strings[1]);
            int from = Integer.parseInt(strings[3]);
            int to = Integer.parseInt(strings[5]);
            map = stackInstructions(amout, from, to, map);
        }
        for (var entry : map.entrySet()) {
            System.out.print(entry.getValue().peek());
        }

    }

    public static Map<Integer, Stack<Character>> makeStack() {
        Map<Integer, Stack<Character>> map = new TreeMap<>();
        for (int i = 1; i <= 9; i++) {
            Stack<Character> s = new Stack<>();
            map.put(i, s);
        }
        return map;
    }

    public static Map<Integer, Stack<Character>> stackInstructions(int amout, int from, int to,
            Map<Integer, Stack<Character>> map) {
        for (int i = 0; i < amout; i++) {
            map.get(to).push(map.get(from).pop());
        }
        return map;
    }
}