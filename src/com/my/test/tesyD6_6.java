package com.my.test;

import java.util.Scanner;
public class tesyD6_6 {
    static Scanner sc =new Scanner(System.in);
    public static  void main(String [] args)
    {
        //int arr[][] =creat(5);
        int arr[][] =turned();
        print( arr,arr.length);
        int arr1[][] = turn_right();
        print( arr1,arr1.length);
        yhsj();
        encirclement();
    }
    //矩阵创建
    public static int[][] creat(int n){
        int arr[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = sc.nextInt();
                arr[i][j] =temp;
            }
        }
        return arr;
    }

    //打印矩阵
    public static void print(int arr[][],int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
    }

    //6.1矩阵转置
    public static int[][] turned(){
        System.out.println("请输入创建矩阵的边长：");
        int n =sc.nextInt();//创建矩阵的边长
        int arr[][] =creat(n);//创建边长为n的矩阵
        for (int i = 0; i < n-1; i++) {//对角不用变换,n-1次就行
            for (int j = i+1; j < n; j++) {//只遍历上三角矩阵就行
                int temp= arr[i][j];
                arr[i][j]=arr[j][i];//转置
                arr[j][i]= temp;
            }
        }

        return arr;
    }

    //6.2矩阵转向
    public static int[][] turn_right(){
        System.out.println("请输入创建矩阵的边长：");
        int n =sc.nextInt();//创建矩阵的边长
        int arr[][] =creat(n);//创建边长为n的矩阵
        int arr1[][]  = new int[n][n];
        for (int i = 0; i < n; i++) {//一行一行的转向
            for (int j = 0; j < n; j++) {
                arr1[j][n-1-i] = arr[i][j];//第一行对应最后一列--i行对应n-1-i列--j列对应j行
            }
        }
        return arr1;
    }

    //6.3杨辉三角
    public static void yhsj(){
        System.out.println("请输入创建杨辉三角的行数：");
        int n =sc.nextInt();//创建矩阵的边长
        int arr[][] =new int[n][n];//创建边长为n的矩阵初始为0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {//遍历下三角矩阵
                if (j == 0||i==j) {//第一列和对角线全为一
                    arr[i][j] = 1;
                    System.out.print(arr[i][j]+" ");
                }
                else{//
                    arr[i][j] = arr[i-1][j] +arr[i-1][j-1];
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();//换行
        }
    }

    //6.4包围圈
    //共有4种类型--1.1.同一行向右+ --2同一列向下+ --3.同一行向左+ --4.同一列向上+
    public static void encirclement(){
        System.out.println("请输入创建包围圈的边长：");
        int n =sc.nextInt();//创建矩阵的边长
        int arr[][] =new int[n][n];//创建边长为n的矩阵初始为0
        int c=1;//记录侦察的个数
        //arr[0][0] = 1;
        int temp=0;//4种类型型--1.1.同一行向右+ --2同一列向下+ --3.同一行向左+ --4.同一列向上+
        int i=0;
        int j =0;
        while (c<= arr.length* arr.length){

                for (int k=0;k< n; j++,k++) {//n-1为一圈平均4等分--还要+1
                    arr[i][j] = c++;
                }
                //System.out.print(j);//debug显示j=n--需要-1 --下面同理
                j--;
                i++;//右转下--转角处--换行i++;
                for (int k=0;k< n-1; i++,k++) {//n-1为一圈平均4等分
                    arr[i][j] = c++;
                }
                i--;
                j--;
                for (int k=0;k< n-1; j--,k++) {//n-1为一圈平均4等分
                    arr[i][j] = c++;
                }
                j++;
                i--;
                for (int k=0;k< n-2; i--,k++) {//n-1为一圈平均4等分--还要-1
                    arr[i][j] = c++;
                }
                i++;
                j++;
                n-=2;
        }
        print(arr, arr.length);
}

}
