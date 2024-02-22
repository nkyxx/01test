package com.my.test;
import java.util.Random;
import java.math.BigInteger;
import java.math.MathContext;
public class testD3_4 {
    public static void main(String []args){
        boolean off = false;
        boolean on = true;
//4.嵌套循环
        //99乘法表
        if (on) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j+"*"+i+"="+i*j+"  ");
            System.out.println();
        }
        }

        //素数
        Random r = new Random();//声明
        final int MAX_INT= 1000;//Integer.MAX_VALUE;
        if (on) {
            int N = r.nextInt(MAX_INT);
            System.out.println(N);
            int j = 1;
            //判断素数
            for (int i = 2; i <= N ;i++) {
                boolean isPrime = true; // 假设i是素数
                //System.out.println(i);
                for ( j = 2; j * j < i; j++) {

                        if (i % j == 0) {//不是素数，count++;
                            isPrime = false;
                            break;
                        }
                }
                if (isPrime) {//是素数
                    System.out.print(i + " ");
                }
            }
                    System.out.println();//换行
        }

        //猜数字
        if (on) {
           int n = r.nextInt(100);
           System.out.println("谜底为："+n);
           //int m= r.nextInt(100);//第一次猜
            int m = 50;//2分法
           int max =99;
           int min = 1;
            int i =1;//猜的次数
           while(on) {//一直猜直到猜对，break跳出

               if (m > n) {//猜大了
                   System.out.println("电脑猜 "+m+" 大了");
                   max = m ;//不需要取m，也取不到m,不用加1
                   //m = r.nextInt(max - min) + min;//随机猜
                   m= (min+max)/2;//2分法
                   i+=1;//猜了次数加一
               }
               if (m < n) {//猜小了
                   System.out.println("电脑猜 "+m+" 小了");
                   min = m+1;//不需要取m，但是能取到m,所以加1
                   //m = r.nextInt(max - min) + min;随机猜
                   m= (min+max)/2;//2分法
                   i+=1;//猜了次数加一
               }
               if (m == n) {//猜对了
                   System.out.println("电脑猜 "+m+" 猜对了 猜了"+i+"次");
                   break;
               }

           }
        }

        //打印菱形
        //行数，每行个数，n,2*n-1,2*i-1
        //可分上下两部分n行，n-1行
        if(on){
            int n =r.nextInt(99)+1;
            // 上半部分菱形
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            for (int i = n - 1; i >= 1; i--) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

        }

    }
}

