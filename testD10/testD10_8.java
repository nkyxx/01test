package testD10;

import java.util.ArrayList;
import java.util.Scanner;

public class testD10_8 {
    public static void main(String[] args) {
        //1.创建集合
        ArrayList<user> list =new ArrayList<>();
        //实例化对象
        user u1 = new user("001","zs","123456");
        user u2 = new user("002","ls","12345678");
        user u3 = new user("003","ww","1234567890");

        //将对象添加到集合
        list.add(u1);
        list.add(u2);
        list.add(u3);

        //String uname =selectUserById(list,"001");
       // System.out.println(uname);

        //String upword =selectPassById(list,"002");
        //System.out.println(upword);
        showLoginPage(list,inid(),inpassword());
    }

    /*
功能: 根据id 查询用户是否存在, 如果存在返回用户名, 如果不存在返回空
参数:
uid: 用户id
返回值:
如果用户存在, 返回用户名.
如果用户不存在, 返回NULL
String selectUserById(int uid);
*/
    public static String selectUserById(ArrayList<user> list,String id){
        for (int i = 0; i < list.size(); i++) {
            user u = list.get(i);//取出存放在集合的类；
            String uid =u.getId();
            if (uid.equals(id)) {
                return list.get(i).getUsername();//返回用户名.
            }
        }

        return null;
    }

    /*
功能: 根据id 查询用户密码, 如果存在返回用户密码, 如果不存在返回空
参数:
uid: 用户id
返回值:
如果密码存在, 返回密码.
如果密码不存在, 返回NULL
String selectPassById(int uid);
*/
    public static String selectPassById(ArrayList<user> list,String id){
        for (int i = 0; i < list.size(); i++) {
            user u = list.get(i);//取出存放在集合的类；
            String uid =u.getId();
            if (uid.equals(id)) {
                return list.get(i).getPassword();//返回密码..
            }
        }

        return null;
    }

    /*
功能: 传入用户id和密码, 根据上面两个函数(selectUserById, selectPassById)来获取相应用
户数据, 并判断是否登录成功
传入用户id 查询用户名是否存在, 并获取用户密码
如果用户存在 则判断密码是否正确
参数:
uid: 用户账户
password: 用户密码
返回值:
如果账号不存在, 返回1
如果密码错误, 返回2
如果登录成功, 返回0
int login(int uid, String password);
*/
    public static int login(ArrayList<user> list,String id,String password){
        if (selectUserById(list,id) != null) {//传入用户id 查询用户名是否存在---存在
            String upword =selectPassById(list,id);//并获取用户密码
            //如果密码错误, 返回2
            if (upword != null && upword.equals(password)) {
                //System.out.println("0");
                return 0;//如果登录成功, 返回0
            }
        }
        return 1;//如果账号不存在, 返回1
    }

    /*
功能: 提示用户输入账号密码, 根据login函数判断是否登录成功,
如果登录成功提示正在进入首页
如果登录失败
密码错误: 提示密码错误, 并让用户重新登录
账号不存在: 提示账号不存在, 并提示正在进入注册界面
参数: 无
返回值: 无
void showLoginPage();
*/
    public static void showLoginPage(ArrayList<user> list,String id,String password){

        int out1 =login(list,id,password);
        switch (out1)
        {
            //如果账号不存在, 返回1
            //如果密码错误, 返回2
            //如果登录成功, 返回0
            case 1:System.out.println("该账号不存在,正在进入注册界面");
            break;
            case 2:System.out.println("密码错误,请重新输入");
                showLoginPage(list,inid(),inpassword());
            //inid();
            //inpassword();
            break;
            case 0:System.out.println("登录成功正在进入登录界面");break;
            default:break;

        }
    }
    public static String inid(){
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入id");
        //String id =;
        //String password =sc.next();
        return sc.next();
    }

    public static String inpassword(){
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入password");
        //String id =sc.next();
        //String password =sc.next();
        return sc.next();
    }

}
