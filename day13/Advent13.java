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
        int sum = 0;

        for(Entry<String, String> t: pairs.entrySet()){
            sum+=compare(t.getKey(),t.getValue());
        }
    }


    public static int compare(String left, String right){
        int value = 0;
        String startLeft = left.substring(0, left.length());
        String startRight = right.substring(0,right.length());
        String[]leftArray = startLeft.split(" , ");
        String[]rightArray = startRight.split(" , ");
        if(rightArray.length==1 && leftArray.length>1){
            int rightValue = Integer.parseInt(rightArray[0]);
            for(int i = 0; i<leftArray.length;i++){
                if(leftArray[i].length()==1){
                    if(Integer.parseInt(leftArray[i])>rightValue){
                        return 0;
                    }
                }else if(leftArray[i].contains("[")){
                    value +=compare(leftArray[i], rightArray[0]);
                }
            }
        }
        else if(leftArray.length==1 && rightArray.length>1){
            int leftValue = Integer.parseInt(leftArray[0]);
            for(int i = 0; i<rightArray.length;i++){
                if(rightArray[i].length()==1){
                    if(Integer.parseInt(rightArray[i])<leftValue){
                        return 0;
                    }
                }else if(leftArray[i].contains("[")){
                    value +=compare(leftArray[0], rightArray[i]);
                }
            }
        }
        else if(leftArray.length>rightArray.length && rightArray.length>1){
            return 0;
        }else{
            for(int i = 0; i<leftArray.length;i++){
                if(leftArray[i].length()==1 && rightArray[i].length()==1){
                    if(Integer.parseInt(leftArray[i])<Integer.parseInt(rightArray[i])){
                        return 0;
                    }
                }else if(leftArray[i].contains("[") || rightArray[i].contains("[")){
                    value +=compare(leftArray[i], rightArray[i]);
                }
            }
        }
        value++;  
        return value;
    }
}