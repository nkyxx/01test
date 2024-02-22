package com.my.test;
import java.util.Scanner;
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入a值：");
        float a = sc.nextInt();
        System.out.println("请输入b值：");
        float b = sc.nextInt();
        System.out.println("请输入c值：");
        float c = sc.nextInt();
        float max = (a > b && a > c) ? a : (b > c) ? b : c;
        System.out.println("最大值为：" + max);

        //打分
        System.out.println("请输入正确题数");
        while (true) {
            int n = sc.nextInt();//输入题数(0-40)
            if (n > -1 && n < 41) {
                if (n <= 10)
                    System.out.println("分数" + 6*n);
                else if (n <= 20)
                    System.out.println("分数" + (60+2*(n-10)));
                else if (n <= 40)
                    System.out.println("分数" + (80+(n-20)));
                break;
            } else {
                System.out.println("请输入0-40正确的题数：");
            }
        }
        //上班
        System.out.println("请输入距离:");
        while(true){
            double length =sc.nextInt();//距离
            if (length > 0) {
                if((60+length/3.0)==(length/1.0))
                    System.out.println("一样快");
                else
                    System.out.println((60+length/3.0)>(length/1.0)?"走路":"骑车");
                break;
            }
            else
                System.out.println("请输入有效的距离:");
        }
    }
}
