package day6;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import inputread.*;
public class Advent6Part2 {


    public static void main(String[]args){
        int count = 0;
        InputListReader reader = new InputListReader("day6/input6.txt");
        List<String>file = reader.file();
        String input = file.get(0);
        char[]c = input.toCharArray();
        Set<Character> set = new HashSet<>();
        outer:for(int i = 0; i<c.length;i++){
            set.clear();
            for(int p = 0; p<14;p++){
                if(((i+p)<c.length)){
                    System.out.print(c[i+p]);
                    set.add(c[i+p]);
                    if(set.size()==14){
                        count=i+14;
                        break outer;
                    }
                }
            }
            System.out.println();
        }
        System.out.println(count);
    }
}
