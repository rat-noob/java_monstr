package org.example;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int payment(int[] xpos, int[]ypos){
        int minx = xpos[0], maxx = xpos[0];
        int miny = ypos[0], maxy = ypos[0];

        for (int i = 1; i < xpos.length; i++) {
            minx = Math.min(minx, xpos[i]);
            maxx = Math.max(maxx, xpos[i]);
            miny = Math.min(miny, ypos[i]);
            maxy = Math.max(maxy, ypos[i]);
        }
        int width = maxx - minx + 1;
        int height = maxy - miny + 1;

        return width * height;
    }
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Введите число монстров:");
        int number = scanner.nextInt();
        System.out.println("Введите размер поля:");
        int n = scanner.nextInt();
        ArrayList<Integer> sq = new ArrayList<Integer>();

        int[] xpos = new int[number];
        int[] ypos = new int[number];

        int pay=1000000000 ;
        int paydef;
        for(int i = 0;i<number;i++){
             System.out.println("Введите позицию монстра:");
             int pos1 = scanner.nextInt()-1;
             int pos2 = scanner.nextInt()-1;

             xpos[i]= pos1;
             ypos[i]= pos2;
        }
        paydef = payment(xpos,ypos);
        for (int i =0;i<number;i++){
            int defx=xpos[i];
            int defy=ypos[i];


            //подвигалои по у

            ypos[i]+=1;
//            if(paydef<Math.min(pay,payment(xpos,ypos))) {
//                pay = Math.min(pay, payment(xpos, ypos));
//            }

            sq.add(payment(xpos, ypos));

            ypos[i]=defy;
            ypos[i]-=1;

//            if(paydef<Math.min(pay,payment(xpos,ypos))) {
//                pay = Math.min(pay, payment(xpos, ypos));
//            }

            sq.add(payment(xpos, ypos));

            ypos[i]=defy;
            //подвигали по х
            xpos[i]+=1;
//            if(paydef<Math.min(pay,payment(xpos,ypos))){pay=Math.min(pay,payment(xpos,ypos));}

            sq.add(payment(xpos, ypos));

            xpos[i]=defx;
            xpos[i]-=1;
//            if(paydef<Math.min(pay,payment(xpos,ypos))) {
//                pay = Math.min(pay, payment(xpos, ypos));
//            }

            sq.add(payment(xpos, ypos));

            xpos[i]=defx;



        }

    System.out.println("Необходимо монет:");
//    System.out.println(pay);
        System.out.println(Collections.max(sq));


    }
}