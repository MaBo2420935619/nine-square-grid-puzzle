package com.mabo.contorller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * 蒙娜丽莎九宫格拼图小游戏
*/

public class MnlsGame {
    private JFrame jf = new JFrame("");
    private static int width=100;
    private static int height=100;
    JLabel[][] jl2 =new JLabel[3][3];


    public static void main(String[] args) {
        new MnlsGame().initial();
    }
    public void initial(){
        int[] a = new int[9];
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


        jf.setLayout(new GridLayout(3,3));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int num = i * 3 + j;
                ImageIcon image = new ImageIcon("pic\\"+a[num]+".jpg");
                image.setImage(image.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT ));
                jl2 [i][j] = new JLabel(image);
                int finalI = i;
                int finalJ = j;
                jf.add(jl2[i][j],i+ "");
                jl2[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("当前lablie为 "+ finalI +"-"+ finalJ);
                        //检测当前数组四周是否有空白照片，如果有，进行换位
                        if (finalI-1>-1&&gameData[finalI-1][finalJ]==8){
                            try {
                                //当前图片上移
                                int temp=  gameData[finalI][finalJ];
                                gameData[finalI][finalJ]= gameData[finalI-1][finalJ];
                                //修改点击的图片
                                ImageIcon image = null;
                                image = new ImageIcon(ImageIO.read(new File("pic\\"+gameData[finalI][finalJ]+".jpg")));
                                image.getImage().flush();//防止图片改变了，但是页面不变
                                image.setImage(image.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT ));
                                jl2 [finalI][finalJ].setIcon(image);

                                //修改上面的图片
                                gameData[finalI-1][finalJ]= temp;

                                image = new ImageIcon(ImageIO.read(new File("pic\\"+gameData[finalI-1][finalJ]+".jpg")));
                                image.getImage().flush();
                                image.setImage(image.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT ));
                                jl2 [finalI-1][finalJ].setIcon(image);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }


                        }
                        else if (finalI+1<3&&gameData[finalI+1][finalJ]==8){
                            //和下边的图片换位置，改变i
                            try {
                                //当前图片移东
                                int temp=  gameData[finalI][finalJ];
                                gameData[finalI][finalJ]= gameData[finalI+1][finalJ];
                                //修改点击的图片
                                ImageIcon image = null;
                                image = new ImageIcon(ImageIO.read(new File("pic\\"+gameData[finalI][finalJ]+".jpg")));
                                image.getImage().flush();
                                image.setImage(image.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT ));
                                jl2 [finalI][finalJ].setIcon(image);

                                //修改上面的图片
                                gameData[finalI+1][finalJ]= temp;

                                image = new ImageIcon(ImageIO.read(new File("pic\\"+gameData[finalI+1][finalJ]+".jpg")));
                                image.getImage().flush();
                                image.setImage(image.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT ));
                                jl2 [finalI+1][finalJ].setIcon(image);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                        else if (finalJ-1>-1&&gameData[finalI][finalJ-1]==8){
                            //和左边的图片换位置，改j
                            try {
                                //当前图片移动
                                int temp=  gameData[finalI][finalJ];
                                gameData[finalI][finalJ]= gameData[finalI][finalJ-1];
                                //修改点击的图片
                                ImageIcon image = null;
                                image = new ImageIcon(ImageIO.read(new File("pic\\"+gameData[finalI][finalJ]+".jpg")));
                                image.getImage().flush();
                                image.setImage(image.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT ));
                                jl2 [finalI][finalJ].setIcon(image);

                                //修改上面的图片
                                gameData[finalI][finalJ-1]= temp;

                                image = new ImageIcon(ImageIO.read(new File("pic\\"+gameData[finalI][finalJ-1]+".jpg")));
                                image.getImage().flush();
                                image.setImage(image.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT ));
                                jl2 [finalI][finalJ-1].setIcon(image);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                        else if (finalJ+1<3&&gameData[finalI][finalJ+1]==8){
                            //和右边的图片换位置
                            try {
                                //当前图片移动
                                int temp=  gameData[finalI][finalJ];
                                gameData[finalI][finalJ]= gameData[finalI][finalJ+1];
                                //修改点击的图片
                                ImageIcon image = null;
                                image = new ImageIcon(ImageIO.read(new File("pic\\"+gameData[finalI][finalJ]+".jpg")));
                                image.getImage().flush();
                                image.setImage(image.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT ));
                                jl2 [finalI][finalJ].setIcon(image);

                                //修改上面的图片
                                gameData[finalI][finalJ+1]= temp;

                                image = new ImageIcon(ImageIO.read(new File("pic\\"+gameData[finalI][finalJ+1]+".jpg")));
                                image.getImage().flush();
                                image.setImage(image.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT ));
                                jl2 [finalI][finalJ+1].setIcon(image);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                        //判断是否成功，并且结束游戏
                        if (success(gameData)){
                            JOptionPane.showMessageDialog(null, "成功","提示",JOptionPane.INFORMATION_MESSAGE);
                            System.exit(1);
                        }
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {

                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
            }
        }
        jf.setSize(320, 320);
        jf.setVisible(true);
    }


    public static boolean  success(int [][]data){
        boolean success=true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] != i *3 +j) {
                    success = false;
                }
            }
        }
        return success;
    }

}