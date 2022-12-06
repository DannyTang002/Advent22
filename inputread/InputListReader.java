package inputread;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class InputListReader {

    private String input;

    public InputListReader(String input){
        this.input = input;
    }

    public List<String>file(){
        List<String> list = new ArrayList<>();
        int sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            for (String line; (line = br.readLine()) != null;) {
                list.add(line);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return list;

    }

}
