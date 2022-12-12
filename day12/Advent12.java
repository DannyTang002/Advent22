package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import inputread.InputListReader;

public class Advent12 {
    private static char[][] grid;
    private static List<Integer> length = new ArrayList<>();
    private static Map<Character, Integer> mapOfChar = new HashMap<>();

    public static void main(String[] args) {

        InputListReader read = new InputListReader("day12/input12.txt");
        int x = 0;
        int y = 0;

        List<String> file = read.file();
        grid = new char[file.size()][file.get(0).length()];
        for (int i = 0; i < file.size(); i++) {
            char[] array = file.get(i).toCharArray();
            for (int j = 0; j < array.length; j++) {
                grid[i][j] = array[j];
                System.out.print(grid[i][j]);
                if (grid[i][j] == 'S') {
                    y = i;
                    x = j;

                }
            }
            System.out.println();
        }
        String alfabet = "abcdefghijklmnopqrstuvwxyz";
        char[] alfabetSeq = alfabet.toCharArray();
        int sum = 0;
        for (char c : alfabetSeq) {
            sum++;
            mapOfChar.put(c, sum);
        }
        mapOfChar.put('S', 0);

        boolean check = true;

        System.out.println(grid[y][x]);

    }

    public static void char(int x, int y) {

        for (int i = y - 1; i <= y + 1; i++) {

            for (int j = x - 1; j <= x + 1; j++) {

                if (mapOfChar.get(grid[i][j]) >= mapOfChar.get(grid[y][x]) && i != y && j != x) {

                }

            }

        }

    }

}
