
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Elf{


    public static void main(String[]args){
        List<Integer> calories = new ArrayList<>();
        int calorie = 0;
        try{
           List<String> allLines = Files.readAllLines(Paths.get("C:\\Users\\Danny\\advent\\d1\\input.txt"));
           for(String line:allLines){
                if(line.equals("")){
                    calories.add(calorie);
                    calorie=0;
                }else{
                    calorie+=Integer.parseInt(line);
                }
           }
        }catch (IOException e) {
			e.printStackTrace();
		}

        int temp = 0;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < calories.size()-1; i++) {
                if (calories.get(i).compareTo(calories.get(i + 1)) > 0) {
                    temp = calories.get(i);
                    calories.set(i, calories.get(i + 1));
                    calories.set(i + 1, temp);
                    sorted = false;
                }
            }
        }

        for(int n : calories){
            System.out.println(n);
        }
    }

}