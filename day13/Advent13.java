package day13;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import inputread.InputListReader;

class Advent13{

    public static void main(String[]args){

        InputListReader read = new InputListReader("day13/test13.txt");
        Map<String,String> pairs = new HashMap<>();

        List<String> files= read.file();

        for(int i = 1; i<files.size();i+=3) {
            System.out.println();
            pairs.put(files.get(i-1),files.get(i));
        }

        for(Entry<String, String> t: pairs.entrySet()){
            System.out.println(t.getKey() + "pair left");
            System.out.println(t.getValue() + "pair right");   
        }
    }


    public static int compare(String left, String right){
        boolean value = false;
        String startLeft = left.substring(0, left.length());
        String startRight = right.substring(0,right.length());
        String[]leftArray = startLeft.split(" , ");
        String[]rightArray = startRight.split(" , ");

        //check left small right big
    
        return 1;
    }

    public static void comparing(String left, String right){
        if(left.length()==1 && right.length()==1){
            if(Integer.parseInt(left)>Integer.parseInt(right)){

            }
        }else{
            
            String startLeft = left.substring(0, left.length());
            String startRight = right.substring(0,right.length());
            String[]leftArray = startLeft.split(" , ");
            String[]rightArray = startRight.split(" , ");


        }




    }


    







}