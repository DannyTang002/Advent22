package day2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Advent2 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        int sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("input2.txt"))) {
            for (String line; (line = br.readLine()) != null;) {
                list.add(line);
                System.out.println(line);
            }
            // line is not visible here.
        } catch (IOException e) {
            e.getStackTrace();
        }

        for (String l : list) {
            String[] parts = l.split(" ");
            System.out.println(parts[0]);
            System.out.println(parts[1]);
            sum += outCome(parts[0], parts[1]);
        }
        System.out.println(sum);

    }

    public static int outCome(String o1, String o2) {
        Map<String, Integer> mapValues = new HashMap<>();
        mapValues.put("X", 1);
        mapValues.put("Y", 2);
        mapValues.put("Z", 3);
        Map<String, String> mapLetter = new HashMap<>();
        mapLetter.put("X", "A");
        mapLetter.put("Y", "B");
        mapLetter.put("Z", "C");
        Map<String, String> mapLetterWin = new HashMap<>();
        mapLetterWin.put("C", "X");
        mapLetterWin.put("A", "Y");
        mapLetterWin.put("B", "Z");

        Map<String, String> mapLetterLose = new HashMap<>();
        mapLetterLose.put("B", "X");
        mapLetterLose.put("C", "Y");
        mapLetterLose.put("A", "Z");
        Map<String, Integer> o1Values = new HashMap<>();
        o1Values.put("A", 1);
        o1Values.put("B", 2);
        o1Values.put("C", 3);

        if (o2.equals("Y")) {
            return 3 + o1Values.get(o1);
        } else if (o2.equals("Z")) {
            return 6 + mapValues.get(mapLetterWin.get(o1));
        } else {
            return mapValues.get(mapLetterLose.get(o1));
        }
    }
}
