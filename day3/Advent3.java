import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Advent3{

    public static void main(String[]args){

        
        List<String> list = new ArrayList<>();
        int sum = 0;
        int sum2 = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("day3/input3.txt"))) {
            for (String line; (line = br.readLine()) != null;) {
                list.add(line);
                
            }
            // line is not visible here.
        } catch (IOException e) {
            e.getStackTrace();
        }
        for(String line:list){
            sum+=matchValue(match(line));
        }

        for(int i = 2 ; i<list.size();i+=3){
            char x = match2(list.get(i), list.get(i-1), list.get(i-2));
            sum2+=matchValue(x);
        }


        System.out.println("part 1 is " + sum);
        System.out.println("part 2 is " + sum2);
    }


    public static int matchValue(Character c){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] bigAlphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        Map<Character,Integer> values = new HashMap<>();

        for(int i = 0 ; i<alphabet.length;i++){
            values.put(alphabet[i], i+1);
            values.put(bigAlphabet[i], 1+alphabet.length+i);
        }
        return values.get(c);

    }


    public static char match(String item){
        int mid = item.length()/2;
        String[]parts = {item.substring(0, mid),item.substring(mid)};
        char a = 'x';
        char b = 'x';
        char m = 'x';
        for(int i = 0; i<mid;i++){
            a = parts[0].charAt(i);
            for(int y = 0; y<mid;y++){
                b = parts[1].charAt(y);
                if(a==b){
                    m = a; 
                    break;
                }
            }
        }
        return m;
    }

    public static char match2(String item,String item2, String item3){

        char[] list1 = item.toCharArray();
        char[] list2 = item2.toCharArray();
        char[] list3 = item3.toCharArray();

        char m = 'a';

        for(char a: list1){
            for(char b: list2 ){
                for(char c: list3){
                    if(a==b && b==c){
                        m = a;
                        break;
                    }
                }
            }
        }

        return m;

        
    }

}