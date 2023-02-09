package com.mabo.contorller;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 控制台数字版九宫格游戏
 */
public class NineNumGame {
    public static void main(String[] args) {
        int[] a = new int[8];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println(Arrays.toString(a));
        //随机交换位置
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(8);
            int number1 = random.nextInt(8);
            if (number != number1) {
                int temp = a[number];
                a[number] = a[number1];
                a[number1] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
        int[][] gameData = new int[3][3];
        //初始化游戏界面
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i * 3 + j == 8) {
                    gameData[i][j] = 8;
                } else {
                    gameData[i][j] = a[i * 3 + j];
                }

            }
        }
        show(gameData);


        while (true) {
            Scanner scanner = new Scanner(System.in);
            String in = scanner.next();
            if (in.equals("w")) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if ( gameData[i][j]==8){
                            //当前字符上移
                            if (i>0){
                              int temp=  gameData[i][j];
                              gameData[i][j]= gameData[i-1][j];
                              gameData[i-1][j]= temp;
                            }
                        }
                    }
                }
            } else if (in.equals("a")) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if ( gameData[i][j]==8){
                            //当前字符左移
                            if (j>0){
                                int temp=  gameData[i][j];
                                gameData[i][j]= gameData[i][j-1];
                                gameData[i][j-1]= temp;
                            }
                        }
                    }
                }

            } else if (in.equals("s")) {
                boolean move=false;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if ( gameData[i][j]==8){
                            //当前字符下移
                            if (i<2){
                                int temp=  gameData[i][j];
                                gameData[i][j]= gameData[i+1][j];
                                gameData[i+1][j]= temp;
                            }
                            move=true;
                        }
                    }
                    if (move){
                        break;
                    }
                }
            } else if (in.equals("d")) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if ( gameData[i][j]==8){
                            //当前字符左移
                            if (j<2){
                                int temp=  gameData[i][j];
                                gameData[i][j]= gameData[i][j+1];
                                gameData[i][j+1]= temp;
                            }
                            break;
                        }
                    }
                }

            } else {
                System.out.println("输入按键错误,使用w  a  d   s操作");
            }
            show(gameData);
            success(gameData);
        }
    }
    public static void show(int [][]data){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ( data[i][j]==8){
                    System.out.print("*");
                }else {
                    System.out.print( data[i][j]+1);
                }
            }
            System.out.println();
        }
    }

    public static void success(int [][]data){
        boolean success=true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] != i *3 +j) {
                    success = false;
                }
            }
        }
        if (success){
            System.out.println("成功");
            System.exit(1);
        }
    }
}
