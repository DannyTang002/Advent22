package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Advent4{

    public static void main(String[]args){
        List<String> list = new ArrayList<>();
        int sum = 0;


        try (BufferedReader br = new BufferedReader(new FileReader("input4.txt"))) {
            for (String line; (line = br.readLine()) != null;) {
                list.add(line);
            }
            // line is not visible here.
        } catch (IOException e) {
            e.getStackTrace();
        }

        for(String line: list){
            String[]split = line.split(",");
            sum+=match(split[0], split[1]);
        }
        System.out.println(sum);


    }


    public static int match(String pair1, String pair2){
        String[]range1 = pair1.split("-");
        String[]range2 = pair2.split("-");
        int lower1 = Integer.parseInt(range1[0]);
        int upper1 = Integer.parseInt(range1[1]);
        int lower2 = Integer.parseInt(range2[0]);
        int upper2 = Integer.parseInt(range2[1]);
        int rangeval1 = upper1-lower1;
        int rangeval2 = upper2-lower2;

        if(rangeval1>=rangeval2){
            return value(lower1,upper1,lower2,upper2);
        }else if(rangeval2>=rangeval1){
            return value(lower2, upper2,lower1, upper1);
        }else{
            return 0;
        }
    }


    public static int value (int lower1, int upper1, int lower2, int upper2){
        int checker = 0;
        List<Integer> smalllist = new ArrayList<>();
        for(int k = lower2; k<=upper2; k++){
            smalllist.add(k);
        }
        for(int i = lower1; i<=upper1; i++){
            if(smalllist.contains(i)){
                checker+=1;
            }
        }
        if(checker>0){
            return 1;
        }
        return 0;
    }





}