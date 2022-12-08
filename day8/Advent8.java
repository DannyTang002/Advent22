package day8;

import java.util.List;

import inputread.InputListReader;

public class Advent8 {

    public static void main(String[] args) {
        InputListReader reader = new InputListReader("test8.txt");
        List<String> list = reader.file();
        int sum = 0;
        int[][]grid = new int[5][5];

        for(int i=0; i<list.size(); i++){
            char[]chars = list.get(i).toCharArray();
            for(int j=0; j<chars.length;j++){
                grid[i][j]=(int)chars[j]-48;
            }
        }
        boolean rowR = true;
        boolean colR = true;
        boolean rowL = true;
        boolean colL = true;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length;j++){
                int value = grid[i][j];
                innerC:for(int r=i; r<grid.length; r++){
                    if (grid[r][j]>value){
                        rowR = false;
                        break innerC;
                    }else{
                        rowR = true;
                    }
                }
                innerC:for(int r=i; r>=0; r--){
                    if (grid[r][j]>value){
                        rowL = false;
                        break innerC;
                    }else{
                        rowL = true;
                    }
                }
                innerR: for(int c=j; c<grid.length; c++){
                    if(grid[i][c]>value){
                        colR = false;
                        break innerR;
                    }else{
                        colR = true;
                    }
                }
                innerR: for(int c=j; c>=0; c--){
                    if(grid[i][c]>value){
                        colL = false;
                        break innerR;
                    }else{
                        colL = true;
                    }
                }
                System.out.print(grid[i][j]);
                if(rowR||colR||colL||rowL){
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println("total " + sum);
    }
}
