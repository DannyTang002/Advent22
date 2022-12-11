package day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import inputread.InputListReader;

import java.awt.Point;

public class Advent9Part2 {

    public static void main(String[] args) {

        InputListReader reader = new InputListReader("day9/test9.txt");
        List<String> files = reader.file();
        Set<Point> tailPositions = new HashSet<>();
        List<Point> tails = new ArrayList<>();

        Point tail = new Point(0, 0);
        Point head = new Point(0, 0);
        tailPositions.add(new Point(0, 0));
        tails.add(tail);

        for(int i = 1; i<9;i++){
            tails.add(new Point(0,0));
        }


        for (String file : files) {
            String[] parts = file.split(" ");
            String command = parts[0];
            int move = Integer.parseInt(parts[1]);
            switch (command) {
                case "D":
                    moveY(head,tail, tails, move,tailPositions);
                    break;
                case "U":
                    moveY(head,tail, tails, -move,tailPositions);
                    break;
                case "R":
                    moveX(head,tail, tails, move,tailPositions);
                    break;
                case "L":
                    moveX(head,tail, tails, -move,tailPositions);
                    break;
                default:
                    break;
            }
            ////System.out.println("tail: " + tail);
            ////System.out.println("head: " + head);
            //boolean corner =  checkCorner(head,tail);
          
        }
        for (Point poss : tails) {
           //System.out.println(poss.getX() + " " + poss.getY());
            
        }
        
        System.out.println(tailPositions.size());

    }


    public static void moveX(Point head,Point tail, List<Point> list, int move, Set<Point>tails){
        int x = (int)head.getX();
        int xt = (int)tail.getX();
        int yt = (int)tail.getY();
        if(move<=0){
            for(int i = 0; i<(-move); i++){
                x--;
                boolean corner =  checkCorner(head,tail);
                head.move(x, (int)head.getY());
                System.out.println("head: " + head);
                if(twoAway(head,tail)){
                    if(corner){
                        xt=x+1;
                        yt = (int)head.getY();
                    }else{
                        xt--;
                    }
                    tail.move(xt, yt);

                    
                }
               // tails.add(new Point(xt,yt));
               tailMoveX(list, -1, tails,xt,yt,checkAllCorners(list));
                //System.out.println("tail: " + tail);
            }
        }else if(move>=0){
            for(int i = 0; i<(move); i++){
                x++;
                boolean corner =  checkCorner(head,tail);
                head.move(x, (int)head.getY());
                System.out.println("head: " + head);
                if(twoAway(head,tail)){
                    if(corner){
                        xt=x-1;
                        yt = (int)head.getY();
                    }else{
                        xt++;
                    }
                    
                    tailMoveX(list, 1, tails,xt,yt,checkAllCorners(list));
                    
                }
                //tails.add(new Point(xt,yt));
                //System.out.println("tail: " + tail);
            }
        }
    }
    public static void moveY(Point head,Point tail, List<Point> list, int move,Set<Point>tails){
        int y = (int)head.getY();
        int yt= (int)tail.getY();
        int xt = (int)tail.getX();
        boolean check= false;
        //System.out.println(twoAway(head, tail));
        if(move<=0){
            for(int i = 0; i<(-move); i++){
                y--;
                boolean corner =  checkCorner(head,tail);
                head.move((int)head.getX(),y);
                System.out.println("head: " + head);
                if(twoAway(head,tail)){
                    if(corner){
                        yt = y+1;
                        xt =(int)head.getX();
                    }else{
                        yt--;
                    }
                    
                    tailMoveY(list, -1, tails,xt,yt,checkAllCorners(list));
                    tail.move(xt,yt);
                }
                //tails.add(new Point(xt,yt));
                //System.out.println("tail: " + tail);
            }
        }else if(move>=0){
            for(int i = 0; i<(move); i++){
                y++;
                boolean corner =  checkCorner(head,tail);
                head.move((int)head.getX(),y );
                System.out.println("head: " + head);
                if(twoAway(head,tail)){
                    if(corner){
                        yt = y-1;
                        xt =(int)head.getX();
                    }else{
                        yt++;
                    }
                    
                    
                    tailMoveY(list, 1, tails,xt,yt,checkAllCorners(list));
                    tail.move(xt,yt);
                }
                //tails.add(new Point(xt,yt));
                //System.out.println("tail: " + tail);
            }
        }
    }


    public static boolean twoAway(Point head, Point tail){
        double tailx = tail.getX();
        double taily = tail.getY();
        boolean check = true;
        //upp ett steg = y axel -1, 
        for(double i = (taily-1); i<=taily+1;i++){
            for(double j = (tailx-1); j<=tailx+1; j++){
                //System.out.println("ix and jy " + i  +" " + j);
                //System.out.println("x and y " + head.getX()  +" " +  head.getY());
                if(j==head.getX() && i==head.getY()){
                    check = false;
                }
            }
            //System.out.println();
        }
        return check;
    }

    public static boolean checkCorner(Point head, Point tail){
        double tailx = tail.getX();
        double taily = tail.getY();
        boolean check = false;

        for(double i = (taily-1); i<=taily+1;i+=2){
            for(double j = (tailx-1); j<=tailx+1; j+=2){
                
                if(j==head.getX() && i==head.getY()){
                    check = true;
                    System.out.println(tail + "t corner: " + head );
                }
            }
            //System.out.println();
        }
        return check;
    }

    public static void tailMoveX(List<Point> tails, int move,Set<Point>tailsP,int xt, int yt,boolean corner){
        int y = yt;
        tails.get(0).move(xt, yt);
        for(int i=1; i<tails.size(); i++){
            int x = (int)tails.get(i).getX();
            System.out.println("pos:" + (i-1) + " " + tails.get(i-1));
            System.out.println("pos:" + i + " " + tails.get(i));
            
            if(twoAway(tails.get(i-1),tails.get(i))){
                if(corner){
                    y = (int)tails.get(i-1).getY()+move;
                    x+=move;
                }else{
                    x+=move;
                    y= (int)tails.get(i).getY();
                }
                tails.get(i).move(x, y);
               
            }
            
        }
        tailsP.add(new Point((int)tails.get(tails.size()-1).getX(),(int)tails.get(tails.size()-1).getY()));
    }

    public static void tailMoveY(List<Point> tails, int move,Set<Point>tailsP, int xt, int yt,boolean corner){
        int x = xt;
        tails.get(0).move(xt, yt);
        for(int i=1; i<tails.size(); i++){
            int y = (int)tails.get(i).getY();
            System.out.println("pos:" + (i-1) + " " + tails.get(i-1));
            System.out.println("pos:" + i + " " + tails.get(i));
            
            if(twoAway(tails.get(i-1),tails.get(i))){
                if(corner){
                    x = (int)tails.get(i-1).getX()+move;
                    y+=move;
                }else{
                    y+=move;
                    x= (int)tails.get(i).getX();
                }
                
                tails.get(i).move(x, y);
            }
            corner=checkCorner(tails.get(i-1), tails.get(i));
        }
        tailsP.add(new Point((int)tails.get(tails.size()-1).getX(),(int)tails.get(tails.size()-1).getY()));
    }

    public static boolean checkAllCorners(List<Point> list){
        boolean check = true;
        for(int i = 1; i<list.size();i++){
            if(checkCorner(list.get(i-1), list.get(i))){
                check = true;
                break;
            }else{
                check = false;
            }
        }
        return check;
    }
}

