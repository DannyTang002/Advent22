package day8;

import java.util.List;

import inputread.InputListReader;

public class Advent8 {

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
        boolean left = true;
        boolean up = true;
        boolean right = true;
        boolean down = true;
        for(int i=0; i<grid.length; i++){
            //down
            for(int j=0; j<grid.length;j++){
                if(i==grid.length-1){
                    down=true;
                }else{
                    down = true;
                    d:for(int d = i+1; d<grid.length;d++){
                        if(!(grid[i][j]>grid[d][j])){
                            down = false;
                            break d;
                        }
                    }
                }
                 //up
                if(i==0){
                    up=true;
                }else{
                    up = true;
                    u:for(int u = i-1; u>=0;u--){
                        if(!(grid[i][j]>grid[u][j])){
                            up = false;
                            //System.out.println(grid[d][j] + " pos: " + d + " " + j);
                            break u;
                        }
                    }
                }
                //right
                if(j==grid.length-1){
                    right=true;
                }else{
                    right = true;
                    r:for(int r = j+1; r<grid.length;r++){
                        if(!(grid[i][j]>grid[i][r])){
                            right = false;
                            break r;
                        }
                    }
                    System.out.println();
                }
                //left
                if(j==0){
                    left=true;
                }else{
                    left = true;
                    l:for(int l = j-1; l>=0;l--){
                        if(!(grid[i][j]>grid[i][l])){
                            left = false;
                            break l;
                        }
                    }
                }
                if(left||up||down||right){
                    //System.out.println("Tree " + grid[i][j] + " is empty position col: " + i + " row: " + j + " down:" +down + " up:"+ up + " right:" +right + " left:" +left);
                    sum++;
                }
            }
        }
        System.out.println("total " + sum);
    }
}
