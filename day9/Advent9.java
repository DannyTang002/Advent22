package day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import inputread.InputListReader;

import java.awt.Point;

public class Advent9 {

    public static void main(String[] args) {

        InputListReader reader = new InputListReader("day9/input9.txt");
        List<String> files = reader.file();
        Set<Point> tailPositions = new HashSet<>();
        List<Point> headPositions = new ArrayList<>();
        Point tail = new Point(0, 0);

        int xt = 0;
        int yt = 0;
        int x = 0;
        int y = 0;
        Point head = new Point(0, 0);

        for (String file : files) {
            String[] parts = file.split(" ");
            String command = parts[0];
            int move = Integer.parseInt(parts[1]);
            switch (command) {
                case "D":
                    y += move;
                    break;
                case "U":
                    y -= move;
                    break;
                case "R":
                    x += move;
                    break;
                case "L":
                    x -= move;
                    break;
                default:
                    break;
            }
            head.move(x, y);
            headPositions.add(head.getLocation());
        }
        for (Point poss : headPositions) {
            System.out.println(poss.getX() + " : " + poss.getY());
        }

    }

}
