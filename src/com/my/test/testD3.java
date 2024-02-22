package com.my.test;
import java.util.Random;
public class testD3 {
    public static void main(String []args){
        //3.简单循环
        Random r = new Random();
        int n = r.nextInt(100)+1;//随机生成n位学长，学姐
        System.out.println("有" + n + "位学长或学姐");//print+ln输出后换行
        //用数组记录年龄
        int []age =new int[n];//动态数组元素未知
        double sum =0.0;
        for (int i = 0; i < n; i++) {
            age[i] = r.nextInt(41)+15;
            sum += age[i];
            System.out.print(age[i]+" ");//print输出后不换行
            if (i == n-1) {//说明年龄输入完成，需要换行
                System.out.println(' ');//println输出后换行
            }

        }
        String avg = String.format("%.2f",sum/n);
        System.out.println("平均年龄为：" + avg);

        //2
        n = r.nextInt(9)+1;//给n赋值，因为n为全局变量
        System.out.print("最多" +n + "位 " );
        int a = r.nextInt(9)+1;
        System.out.println("a为：" +a);
        System.out.print(a + " ");
        int sumz = a;
        int temp = a;
        for (int i = 1; i < n; i++) {
            temp = temp*10 + a;
            System.out.print( temp + " ");
            sumz += temp;
            if (i == n-1)
                System.out.println();//换行
        }
        System.out.println("和为：" + sumz);

        //兔子
        //0，1，2月兔子不生，3月及以后生 sumtz,n,0,1,2,>=3
        n = r.nextInt(29)+1;//月份
        //每月判断0，1，2，》3 共4类兔子的状况,初始换
        int c0 = 2;
        int c1 = 0;
        int c2 = 0;
        int c34 = 0;
        int sumtz = 0;
        int temptz = 0;
        for (int i = 0; i < n; i++) {//共n个月
            temptz= c0;
            c0 = c34*2;//生的，×2
            c34 += c2;//累计
            c2 = c1;
            c1= temptz;
//            System.out.print("第" + (i+1));
//            System.out.print("个月--刚出生兔子：" + c0);
//            System.out.print(" 1个月兔子：" + c1);
//            System.out.print(" 2个月兔子：" + c2);
//            System.out.println(" 3个月及以上兔子：" + c34);
        }
        sumtz = c0+c1+c2+c34;
        System.out.print("经过" + n +"月");
        System.out.println(" 共有：" + sumtz +"即"+(sumtz/2)+"对");

        //4
        //要求输入弹球的初始高度M和回弹次数N, 输出弹球第N次回弹后的高度 和达到该高度后所经过的距离(保留两位小
        //数)(0<M<2000, 0<N<50) 弹回高度减半
        float M =r.nextFloat()* 2000.0F;
        System.out.print("开始下落高度：" + M);
        int N = r.nextInt(51);
        System.out.println(" 总共弹回次数：" + N);
        double hight = M;
        double sumdistence =0.0;
        for (int i = 0; i < N; i++) {
            sumdistence += hight;//下落路程
            hight /= 2.0;//弹回高度减半
           // System.out.print(hight+ " ");
            sumdistence += hight;//弹回路程
        }
        String h= String.format("%.2f",hight);
        System.out.print("第"+ N +"次弹回后高度：" + h);
        String d = String.format("%.2f",sumdistence);
        System.out.println(" 达到该高度后所经过的距离：" + d);
    }
}
