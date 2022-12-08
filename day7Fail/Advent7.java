package day7Fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;


import inputread.InputListReader;

public class Advent7 {
    private static Directory currentDir;
    private static Set<Directory>  directories = new HashSet<>();
    private static Set<String>  directoryNames = new HashSet<>();
    private static List<String> currentDirectories= new ArrayList<>();
        
    public static void main(String[]args){
       
        InputListReader reader = new InputListReader("test.txt");
        List<String> file = reader.file();
    
        for(String s: file){
            if(s.startsWith("$")){
                if(s.contains("cd") && !s.contains("..")){
                    String[]parts = s.split(" ");
                    if(directoryNames.contains(parts[2])){
                        getDir(parts[2]);
                    }else{
                        currentDir= new Directory(parts[2]);
                        directories.add(currentDir);
                        directoryNames.add(parts[2]);
                    }
                    currentDirectories.add(parts[2]);
                }else if(s.contains("cd") && s.contains("..")){
                    String previous = currentDirectories.get(currentDirectories.size()-2);
                    currentDirectories.add(previous);
                    getDir(previous);
                }
            }else{
                currentDir.add(build(s));
                
            }
        }
        //directories.stream().forEach(x->System.out.println(x.getName() + " size:" + x.fileSize()));
        directories.stream().forEach(x->x.printInfo());
        int all = directories.stream().mapToInt(x->x.fileSize()).filter(x->x<=100000).sum();
        System.out.println(all);
    }

    public static void getDir(String s){
        for(Directory dir: directories){
            if(dir.getName().equals(s)){
                currentDir=dir;
                break;
            }
        }
    }
    public static Data build(String input){
        String[]parts = input.split(" ");

        if(parts[0].equals("dir")){
            directoryNames.add(parts[1]);
            Directory dir = new Directory(parts[1]);
            directories.add(dir);
            return dir;
        }else{
            return new FileData(input);
        }
    }
}

