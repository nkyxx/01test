package com.my.test;
import java.util.Scanner;//引入Sanner包,可以读取键盘输入
public class test1 {
        public static void main(String[] args) {
            // TODO code application logic here

            System.out.println("请输入一个三位数：");
            Scanner sc = new Scanner(System.in);//固定的格式，声明下面会用到键盘输入，sc可以换其他变量（不建个人议）

            while(true) {
                int number = sc.nextInt();//输入的数字变量number;
                if (number > 99 && number < 999) {//判断是否是三位数，满足进行输出
                    int GeWei = number % 10;
                    number = number / 10;
                    int ShiWei = number % 10;
                    number = number / 10;
                    int BaiWei = number % 10;
                    System.out.println(BaiWei);
                    System.out.println(ShiWei);
                    System.out.println(GeWei);
                    break;
                } else {
                    System.out.println("请输入一个正确的三位数：");
                }
            }
        }
}


