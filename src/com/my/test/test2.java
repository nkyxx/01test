package com.my.test;
import java.util.Scanner;//引入Sanner包,可以读取键盘输入
public class test2 {
    public static final double PI = 3.14; // 定义一个double常量:PI
    public static void main(String[] args) {
        System.out.println("请输入正方形边长l：");
        Scanner sc = new Scanner(System.in);//固定的格式，声明下面会用到键盘输入，sc可以换其他变量（不建个人议）
        while (true) {
            double l = sc.nextInt();//输入的边长l
            if (l > 0 && l < 1000) {
            double Square_area = l * l;//这里不用int是因为(l/2)int类型转换有问题,精度丢失
            System.out.println(Square_area);
            double Circular_area = (l/2) * (l/2)*PI;
            System.out.println(Circular_area);
            double Area_difference = Square_area - Circular_area;
        System.out.println(Area_difference );
            String outcome = String.format("%.2f", Area_difference);//保留两位小数
            System.out.println(outcome); // 输出:
                break;
            }
            else{
                System.out.println("请输入正确的正方形边长l：");
            }
        }
    }
}
