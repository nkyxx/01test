package com.my.test.tsestD9;
import java.util.Scanner;

public class testD9_7 {
    static Scanner sc =new Scanner(System.in);
    public static void main(String []args){
        bigtosmall();
        repeace();
        //System.out.print((char)('a'-32));
        //System.out.print(ifSpecial('*'));
        System.out.println(safepassword());
        //System.out.println(move('Z'));
        encryption();
    }
    //7.1字符串大小写转换
    public static void bigtosmall(){
        StringBuilder in = new StringBuilder();
        System.out.println("请输入字符串");
        String c = sc.next();//键盘获取字符
        //System.out.println('a'-'A');
        //System.out.println(c);
        for (int i = 0; i < c.length(); i++) {
            char temp =c.charAt(i);
            if (temp>= 'a'&& temp<='z'){//表明是小写，要转成大写
                //System.out.println(c.charAt(i));
                in.append((char)(c.charAt(i)-32));
                //System.out.println((char)(c.charAt(i)-32));
            }
            else if (temp>='A'&& temp<='Z') {//说明是大写，要转换为小写
                in.append((char) (c.charAt(i)+32));
            }else
                in.append((char) c.charAt(i));//说明是其他字符，不用转换
        }
        String out = in.toString();//变为字符串
        System.out.println(out);
    }

    //7.2查找与替换
    //需要你设计一个替换功能, 输入原文S 以及A,B两个子串, 用B替换掉S中的A
    public static void repeace(){

        StringBuilder out =new StringBuilder();
        System.out.println("请输入原文：");
        String the_original =sc.next();//输入原文S
        //System.out.print(the_original);
        System.out.println("请输入A：");
        String A =sc.next();//输入A
        //System.out.print(A);
        System.out.println("请输入B：");
        String B =sc.next();//输入B
        //System.out.print(B);
        for (int i = 0; i < the_original.length(); i++) {
            if ((the_original.length()>A.length()+i)&&(the_original.substring(i,A.length()+i)).equals(A)) {
            //这里判断条件--长度与A相同的字符串与A比较值是否相同，同时当比较的字符串长度<A的长度时不相同；否则比较时报错--超过字符串索引最大值
                out.append(B);
                //System.out.print(B);
                i = i + A.length() - 1;//跳过A
            }
            else{
                out.append(the_original.charAt(i));
            }
            }
        String out1 =out.toString();
        System.out.println(out1);
    }

    //设计一个程序 输入密码字符串
    //如果密码安全, 打印true, 否则打印false安全密码的判定:
    //1. 长度在8~16之间
    //2. 开头必须是大写
    //3* 密码最少包含一个小写字母, 一个数字, 一个特殊符号
    //特殊符号包括~!@#$%*  7个
    public  static boolean ifSpecial(char c){
        char []chararr ={'~','!','@','#','$','%','*'};
        int count=0;
        for (int i = 0; i < chararr.length; i++) {
            if (chararr[i]==c) {
                count++;
            }
        }
        if (count >0 ) {
            return true;
        }
        return false;
    }
    //(字符串长度<100)
    public static boolean safepassword(){
        //输入密码字符串
        System.out.println("请输入密码");
        String password = sc.next();//键盘获取密码
        //判断密码安全1. 长度在8~16之间
        if (password.length() >= 8&&password.length() <= 16) {
            //2. 开头必须是大写
            if (password.charAt(0)>='A'&& password.charAt(0)<='Z') {
                //3* 密码最少包含一个小写字母, 一个数字, 一个特殊符号特殊符号包括~!@#$%*
                //可以遍历判断
                int small=0;
                int number =0;
                int special=0;
                for (int i = 1; i < password.length(); i++) {
                    if (password.charAt(i)>='a'&&password.charAt(i)<='z') {//最少包含一个小写字母
                        small++;
                    }else if (password.charAt(i)>=(char)48&&password.charAt(i)<=(char)57) {
                        number++;
                    }else if (ifSpecial(password.charAt(i))) {
                        special++;
                    }
                }
                if(small>0&&number>0&&special>0)
                    return true;
            }
        }
        
        return false;
    }

    //7.4加密
    //对于每个字母和数字, 按字母表/数字顺序往后挪5位
    public static char move(char c){
        char[] number ={'0','1','2','3','4','5','6','7','8','9'};
        //对于每个字母和数字, 按字母表/数字顺序往后挪5位
        //先判断是字母还是数字还是其他
        if (c >='0'&&c<'9') {//数字
            for (int i = 0; i < 10; i++) {
                if (number[i] == c) {
                    return number[(i+5)%10];
                }
            }
        }
        else if(c>='A'&&c<='Z'){//大写字母
            if (c <=(char)('Z'-5 )) {
                return (char)(c+5);
            }
            else
                return (char)(c+5-26);
        }
        else if(c>='a'&&c<='z'){//小写字母
            if (c <=(char)('z'-5 )) {
                return (char)(c+5);
            }
            else
                return (char)(c+5-26);
        }
        return c;
    }

    //(如果超过了 则从头开始, 比如'z'转换后变成'e', '9'转换后变成'4')
    //符号不变
    //设计一个程序, 输入加密前的密码 打印加密后的密码(密码长度 <= 16)
    public static void encryption(){

        //输入加密前的密码
        System.out.println("请输入需要加密的密码");
        String oldpassword =sc.next();
        StringBuilder newpassword =new StringBuilder();
        if (oldpassword.length() <= 16) {
            for (int i = 0; i < oldpassword.length(); i++) {
                newpassword.append(move(oldpassword.charAt(i)));
            }
            String out = newpassword.toString();
            System.out.println(out);
        }
        else
            System.out.println("请输入有效的密码");

    }
}



