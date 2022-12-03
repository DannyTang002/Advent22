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

        try (BufferedReader br = new BufferedReader(new FileReader("input3.txt"))) {
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

        System.out.println(sum);
    }


    public static int matchValue(Character c){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] bigAlphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        Map<Character,Integer> values = new HashMap<>();

        for(int i = 0 ; i<alphabet.length;i++){
            values.put(alphabet[i], i+1);
            values.put(bigAlphabet[i], 1+alphabet.length+i);
        }

        System.out.println(values.get('p'));
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

}