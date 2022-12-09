package day8;

import java.util.ArrayList;
import java.util.List;

import inputread.InputListReader;

public class Advent8Part2{

    public static void main(String[] args) {
        InputListReader reader = new InputListReader("day8/input8.txt");
        List<String> list = reader.file();
        int sum = 0;
        int[][]grid = new int[list.size()][list.size()];
        for(int i=0; i<list.size(); i++){
            char[]chars = list.get(i).toCharArray();
            for(int j=0; j<list.size();j++){
                grid[i][j]=(int)chars[j]-48;
            }
        }
        List<Integer> viewpoints = new ArrayList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length;j++){
                int valueDown = 0;
                int valueUp = 0;
                int valueRight = 0;
                int valueLeft= 0;

                //down
                if(i==grid.length-1){
                    valueDown = 0;
                }else{
                    d:for(int d = i+1; d<grid.length;d++){
                        valueDown++;
                        if(!(grid[i][j]>grid[d][j])){
                            break d;
                        }
                    }
                }
                 //up
                if(i==0){
                    valueUp = 0;
                }else{
                    u:for(int u = i-1; u>=0;u--){
                        valueUp++;
                        if(!(grid[i][j]>grid[u][j])){
                            //System.out.println(grid[d][j] + " pos: " + d + " " + j);
                            break u;
                        }
                        
                    }
                }
                //right
                if(j==grid.length-1){
                    valueRight = 0;
                }else{
                    r:for(int r = j+1; r<grid.length;r++){
                        valueRight++;
                        if(!(grid[i][j]>grid[i][r])){
                            break r;
                        }
                        
                    }

                }
                //left
                if(j==0){
                    valueLeft = 0;
                }else{
                    l:for(int l = j-1; l>=0;l--){
                        valueLeft++;
                        if(!(grid[i][j]>grid[i][l])){
                            break l;
                        }
                       
                    }
                }

                viewpoints.add(score(valueDown, valueUp, valueRight, valueLeft));
            }
        }
        System.out.println("total " + viewpoints.stream().mapToInt(x->x).max().orElse(0));
    }
    public static int score(int down, int up, int right, int left){
        return down*up*right*left;
    }
}
