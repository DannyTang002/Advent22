package day7Sucsess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.List;


import inputread.InputListReader;

public class Advent7 {
    private static Map<String,List<String>> map = new HashMap<>();
    public static Stack<String> currentDirectories=  new Stack<>();
    public static void main(String[]args){
       
        InputListReader reader = new InputListReader("day7Sucsess/input7.txt");
        List<String> files = reader.file();
        
        String currentDirectory = " ";
        List<Integer> values = new ArrayList<>();

        for(String file: files){
            if(file.charAt(0)=='$'){
                String command = file.substring(2);
                if(command.startsWith("cd")){
                    currentDirectory = command.substring(3);
                    if(currentDirectory.equals("..")){
                        currentDirectories.pop(); 
                    }else if("/".equals(currentDirectory)){
                        currentDirectories.push("/");
                    }else{
                        currentDirectories.push(currentDirectories.peek() + "/" + currentDirectory);
                    }
                    
                }else if(command.startsWith("ls"));
                List<String> s = new ArrayList<>();
                map.putIfAbsent(currentDirectories.peek(),s );
            }else{
                String[]part = file.split(" ");
                if(file.startsWith("dir")){
                    map.get(currentDirectories.peek()).add(currentDirectories.peek() + "/" + part[1]);
                }else{
                    map.get(currentDirectories.peek()).add(part[0]);
                }
            }
        }
        for (Entry<String, List<String>> entry : map.entrySet()) {
            //System.out.println(entry.getKey() + entry.getValue());
            values.add(value(entry.getValue()));
        }
        int sum = values.stream().mapToInt(x->x).filter(x->x<=100000).sum();
        System.out.println(sum);

    }
    public static int value(List<String> list){
        int sum = 0;
        for(String s: list ){
            if(!s.startsWith("/")){
                sum+=Integer.parseInt(s);
            }
            else{
                System.out.println();
                sum+=value(map.get(s));
            }
        }
        return sum;
    }
}