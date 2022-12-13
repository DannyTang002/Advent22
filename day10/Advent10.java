package day10;

import java.util.ArrayList;
import java.util.List;

import inputread.InputListReader;

public class Advent10 {

    public static void main(String[]args){
        InputListReader read = new InputListReader("day10/input10.txt");
        List<String> files = read.file();
        int x = 1;
        int cycle = 0;

        List<Integer>list = new ArrayList<>();
        String[][]grid= new String[6][40];
        String[]sprite = new String[40];
        for(int i = 0; i<sprite.length;i++){
            sprite[i]=".";
        }
        for(int i=20;i<=220;i+=40){
            list.add(i);
        }
        
        for(String line: files){
            String[]parts = line.split(" ");
            String command = parts[0];
            if(command.equals("noop")){
                draw(cycle, grid, x);
                cycle++;     
            }else if(command.equals("addx")){
                int value = Integer.parseInt(parts[1]);
                for(int i= 0; i<2 ; i++){
                    draw(cycle, grid, x);
                    cycle++;
                    
                }
                x+=value;
            }
        }
        for(int i= 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    public static int checkCyle(List<Integer> list, int sum, int cycle, int value){
        if(list.contains(cycle)){
            System.out.println(cycle*value + " cycle " + cycle);
            sum += cycle*value;
            return cycle*value;
        }
        else{
            return 0;
        }
    }


    public static String[][]draw (int cycle,String[][]grid,int value){
      if(cycle<40){
        if(checkValue(value, cycle)){
            grid[0][cycle]="#";
        }else{
            grid[0][cycle]=" ";
        }
      }else if(cycle<80){
        if(checkValue(value, cycle-40)){
            grid[1][cycle-40]="#";
        }else{
            grid[1][cycle-40]=" ";
        }
        
      }else if(cycle<120){
        if(checkValue(value, cycle-80)){
            grid[2][cycle-80]="#";
        }else{
            grid[2][cycle-80]=" ";
        }
        
      }else if(cycle<160){
        if(checkValue(value, cycle-120)){
            grid[3][cycle-120]="#";
        }else{
            grid[3][cycle-120]=" ";
        }
        
      }else if(cycle<200){
        if(checkValue(value, cycle-160)){
            grid[4][cycle-160]="#";
        }else{
            grid[4][cycle-160]=" ";
        }
        
      }else if(cycle<240){
        if(checkValue(value, cycle-200)){
            grid[5][cycle-200]="#";
        }else{
            grid[5][cycle-200]=" ";
        }
      }
        return grid;
    }
    public static boolean checkValue(int value, int pos){
        if(value==pos||value+1==pos||value-1==pos){
            return true;
        }else{
            return false;
        }
    }
}
