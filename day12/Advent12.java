package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import inputread.InputListReader;

public class Advent12 {
    private static char[][] grid;
    private static List<String> length = new ArrayList<>();
    private static Map<Character, Integer> mapOfChar = new HashMap<>();

    public static void main(String[] args) {

        InputListReader read = new InputListReader("day12/input12.txt");
        int x = 0;
        int y = 0;

        String alfabet = "abcdefghijklmnopqrstuvwxyz";
        char[] alfabetSeq = alfabet.toCharArray();
        int sum = 0;
        for (char c : alfabetSeq) {
            sum++;
            mapOfChar.put(c, sum);
        }

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

        mapOfChar.put('S', 0);
        mapOfChar.put('E', 1000);

        boolean check = true;

        System.out.println(grid[y][x]);
        length = paths(x, y);

        for (String j : length) {
            System.out.println(j);
        }

    }

    public static List<String> paths(int x, int y) {
        List<String> paths = new ArrayList<>();
        move(x, y, paths, "");
        return paths;
    }

    public static void move(int x, int y, List<String> paths, String path) {

        path += grid[y][x];
        System.out.println(grid[y][x]);
        System.out.println(path);
        if (grid[y][x] == 'E') {
            paths.add(path);
        } else {
            for (int i = y - 1; i < y + 1; i += 2) {
                for (int j = x - 1; j < j + 1; j += 2) {
                    if (i < grid.length && j < grid[y].length && j >= 0 && i >= 0) {
                        if (mapOfChar.get((grid[i][j])) >= mapOfChar.get(grid[x][y])) {
                            System.out.println("y " + i + " x " + j);
                            move(j, i, paths, path);
                        }
                    }
                }
            }
        }
    }

}
