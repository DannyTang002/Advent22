package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.awt.Point;
import inputread.InputListReader;

public class Advent12 {
    private static int[][] grid;
    private static char[][] gridchar;
    private static List<Integer> length = new ArrayList<>();
    private static Map<Character, Integer> mapOfChar = new HashMap<>();

    public static void main(String[] args) {

        InputListReader read = new InputListReader("day12/input12.txt");
        String alfabet = "abcdefghijklmnopqrstuvwxyz";
        char[] alfabetSeq = alfabet.toCharArray();
        int sum = 0;
        int x = 0;
        int y = 0;
        int xEnd = 0;
        int yEnd = 0;

        for (char c : alfabetSeq) {
            sum++;
            mapOfChar.put(c, sum);
        }
        mapOfChar.put('S', 0);
        mapOfChar.put('E', 1000);
        List<String> file = read.file();
        grid = new int[file.size()][file.get(0).length()];
        gridchar = new char[file.size()][file.get(0).length()];
        for (int i = 0; i < file.size(); i++) {
            char[] array = file.get(i).toCharArray();
            for (int j = 0; j < array.length; j++) {
                gridchar[i][j]=array[j];
                grid[i][j] = mapOfChar.get(array[j]);
                System.out.print(grid[i][j]);
                if (array[j] == 'S') {
                    y = i;
                    x = j;
                }else if(array[j]=='E'){
                    xEnd=j;
                    yEnd=i;
                }
            }
            System.out.println();
        }
       

        findPath(x, y, file.size(),file.get(0).length() );
        System.out.println(xEnd + " " + yEnd);
    }

    public static boolean[][]reach (int y, int x){
        boolean[][]check = new boolean[y][x];
        for(int i = 0; i<check.length;i++){
            for(int j = 0 ;j<check[i].length;j++){
                check[i][j]=false;
            }
        }
        return check;
    }

    public static int findPath(int x, int y,int c,int r){
        int dRow[] = { -1, 0, 1, 0 };
        int dCol[] = { 0, 1, 0, -1 };
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        boolean[][]reached = reach(c, r);
        reached[y][x]=true;
        boolean end = false;
        outer:while(!queue.isEmpty()){
            Point current = queue.peek();
            x = (int)current.getX();
            y = (int)current.getY();
            reached[y][x]=true;
            System.out.println(gridchar[y][x] + " position " + x + " ; " + y);
            queue.remove();
            if(grid[y][x]==1000){
                System.out.println(gridchar[y][x]);
                break;
            }
            for(int i = 0; i<4; i++){
                int xn = x + dRow[i];
                int yn = y+ dCol[i];
                if( isValid(grid[1].length, grid.length, reached, xn, yn) ){
                    if(grid[yn][xn]==grid[y][x]||grid[yn][xn]==(grid[y][x]+1)){
                        Point next = new Point(xn,yn);
                        queue.add(next);
                        reached[yn][xn]= true;
                    }
                    
                }
            }
           


        }
        for(int i = 0; i<reached.length;i++){
            for(int j =0;j< reached[i].length;j++){
                if(reached[i][j]){
                    System.out.print('x');
                }else{
                    System.out.print('.');
                }
            }
            System.out.println();
        }
        return 1;
    }

    public static boolean isValid(int xmax,int ymax, boolean[][] grid,int x, int y ){
        if(x>=xmax||y>=ymax||x<0||y<0){
            return false;
        }if(grid[y][x]){
            return false;
        }else{
            return true;
        }


    }

  

   

}
