package com.my.test;
import java.util.Random;
import java.util.Scanner;

public class testD5_5 {
    static Scanner sc = new Scanner(System.in);//键盘输入的声明
    static Random r = new Random();
    public static void main(String[] args){//5。一维数组

        moveint();
        ring();
        merge();
        live();
    }
    //数组去重
    public  static void moveint(){
        //1.定义一维数组
        int []arr = new int[9];//动态的，还需要赋值
        int []arr1 =new int[9];
        //赋值,通过便利赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10);//我想随机赋值,范围0-9都可取
            System.out.print(arr[i]);

        }
        System.out.println();
        //2.判断是否有重复的数字,当前元素与前面每个元数相比
        int count= 0;
        boolean q = true;
        for (int i = 0; i < arr.length; i++) {


            q = true;
            for (int j = i-1; j >=0; j--) {
                if(arr[i]==arr[j]){//相同--给个标记
                    q =false;
                    break;//当前元素不被记录
                }
                }
            if (q){
                arr1[count++] = arr[i];
                q = true;
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
    }

    //环
    public  static void ring(){
    //1.定义一维数组
    //System.out.print("请输入数组长度n:");
    //int n =sc.nextInt();
    int n =9;
    int []arr = new int[n];//动态的，还需要赋值
    int []arr1 =new int[n];
    //赋值,通过便利赋值
        for (int i = 0; i < n; i++) {
        arr[i] = r.nextInt(10);//我想随机赋值,范围0-9都可取
        System.out.print(arr[i]+" ");

    }
        int m =r.nextInt(n);//移动位数--我想随机赋值,范围0-(n-1)都可取
        System.out.println("  移动位数:"+m);
        //2.移动，交换i和i+mwe,如果超过n--就-n,这里n为9
        for(int i =0;i<n;i++){
            if(i+m>=n)//arr1[]后面不够了，用前面空的装
                arr1[i+m-n]= arr[i];
            else
               arr1[i+m] = arr[i];
        }
        //输出arr1,移动后的
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
    }

    //合并有序数组
    public  static void merge() {
        System.out.print("请输入数组长度n,m:");
        int n =sc.nextInt();
        int m =sc.nextInt();
        //int n = 5;
        //int m = 6;
        int[] arr2 = new int[n+m];//动态的
        int[] arr = new int[n];//动态的，还需要赋值
        //赋值,通过便利赋值
        System.out.print("请输入数组1元素:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] arr1 = new int[m];
            //赋值,通过便利赋值
        System.out.print("请输入数组2元素:");
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        //排序，
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {//不断比较 1组和2组中 还没赋值到3组 的最小值--直到两组中任意一组赋值完了
            if (arr[i] < arr1[j]) {
                arr2[k++] = arr[i++];
            } else {
                arr2[k++] = arr1[j++];
            }
        }

        while (i < n) {//当第2组复制完了，剩下1组没有，直接跟这赋值
            arr2[k++] = arr[i++];
        }

        while (j < m) {//同上--当第1组复制完了，剩下2组没有，直接跟这赋值
            arr2[k++] = arr1[j++];
        }
        for ( i = 0; i < m+n; i++) {
            System.out.print(arr2[i] +" ");
        }
        System.out.println();
    }

    //枪毙
    //循环连表
    public static int findSurvivor(int n, int m) {
        Node head = createCircularList(n); // 创建循环链表
        Node prev = null, curr = head;
        while (curr.next != curr) { // 只剩一个节点时退出循环
            for (int i = 1; i < m; i++) { // 找到要删除的节点
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next; // 删除该节点
            curr = prev.next; // 继续从下一个节点开始报数
        }
        return curr.data+1; // 返回最后剩下的节点的位置
    }

    // 创建包含n个节点的循环链表，并返回头节点
    public static Node createCircularList(int n) {
        Node head = new Node(0), curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new Node(i);
            curr = curr.next;
        }
        curr.next = head; // 将链表首尾相连
        return head;
    }

    // 单向循环链表的节点类
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    public  static void live(){
        System.out.print("请输入参与人数n:");
        int n =sc.nextInt();
        //int n =9;
        //int m =r.nextInt(n);//移动位数--我想随机赋值,范围0-(n-1)都可取
        System.out.print("请枪毙号码:");
        int m =sc.nextInt();
        int survivor = findSurvivor(n, m);//循环链表
        //int survivor = findSurvivor1(n, m);//递归
        System.out.println("胜利者: " + survivor);

        }


    public static int findSurvivor1(int n, int m) {//递归
        if (n == 1) { // 只有一个人时直接返回其位置
            return 1;
        }
        // 在n个人中，第m个人被杀后，剩下的n-1个人组成新的环，继续进行游戏
        // 幸存者在新环中的位置等于在旧环中位置加上m，但需要对环长度取模
        return (findSurvivor1(n - 1, m) + m - 1) % n + 1;
    }

    }
