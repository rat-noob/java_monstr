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
        int wmax=-5,wmin=1000,lmax=-5,lmin=100;
        for(int i = 0;i<number;i++){
             System.out.println("Введите позицию монстра:");
             int pos1 = scanner.nextInt();
             int pos2 = scanner.nextInt();
             field[pos1][pos2]=1;
             if(pos1<wmin) wmin= pos1;
             if(pos1>wmax) wmax = pos1;

            if(pos2<lmin) lmin= pos2;
            if(pos2>lmax) lmax = pos2;
        }
    System.out.println(lmax);
    System.out.println(lmin);
    System.out.println(wmax);
    System.out.println(wmin);
    int wfield = (wmax-wmin);
    int lfield= (lmax-lmin);
    //куча проверок
    for (int i =wmin;i<wmax+1;i++){//проверка верхней границы поля
        if(field[i][lmin]==1) wfield++; break;
    }
    for(int i = wmin;i<wmax+1;i++){//проверка нижней границы
        if(field[i][lmax]==1)wfield++; break;
    }
    for(int i = lmin;i<lmax+1;i++){//проверка левой границы
        if(field[wmin][i]==1) lfield++;break;
    }
    for(int i = lmin;i<lmax+1;i++){//проверка правой границы
        if(field[wmax][i]==1) lfield++;break;
    }

        if (field[wmin][lmin]==1){
        if (field[wmax][lmax]==1) wfield++;lfield++;

    }
    int pay =wfield*lfield;
    System.out.println("Необходимо монет:");
    System.out.println(pay);


    }
}