package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Введите число монстров:");
        int number = scanner.nextInt();
        System.out.println("Введите размер поля:");
        int width = scanner.nextInt();
        int length = scanner.nextInt();
        int[][] field = new int[width][length];
        for (int i =0;i<width;i++){
            for (int j=0;j<length;j++){
                field[i][j] = 0;
            }
        }
        int wmax=-5,wmin=100000,lmax=-5,lmin=1000000;
        for(int i = 0;i<number;i++){
             System.out.println("Введите позицию монстра:");
             int pos1 = scanner.nextInt()-1;
             int pos2 = scanner.nextInt()-1;
             field[pos1][pos2]=1;
             if(pos1<wmin) wmin= pos1;
             if(pos1>wmax) wmax = pos1;

            if(pos2<lmin) lmin= pos2;
            if(pos2>lmax) lmax = pos2;
        }
    int wfield = (wmax-wmin)+1;
    int lfield= (lmax-lmin)+1;

    if(((field[wmin][lmin]==1)&&(field[wmax][lmin]==1))||(((field[wmin][lmin]==1))&&(field[wmin][lmax]==1))||
            ((field[wmin][lmin]==1)&&field[wmax][lmax]==1)||((field[wmax][lmin]==1)&&(field[wmin][lmax]==1))){
    if (wfield>=lfield){
        lfield++;
    }else wfield++;
    };
    if((wmin==wmax)&&(lmin==lmax)) wfield=lfield=1;
    int pay = wfield*lfield;
    System.out.println("Необходимо монет:");
    System.out.println(pay);


    }
}