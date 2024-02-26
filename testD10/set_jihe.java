package testD10;

import java.util.ArrayList;

public class set_jihe {
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

        int condition = contains(list,"001");
        String out =list.get(condition).getId()+" "+list.get(condition).getUsername()+" "+list.get(condition).getPassword();
        System.out.println(out );
    }

    //方法,判断，用户是否存在与集合
    public static int contains(ArrayList<user> list,String id){
        for (int i = 0; i < list.size(); i++) {
            user u = list.get(i);//取出存放在集合的类；
            String uid =u.getId();
            if (uid.equals(id)) {
                return i;//返回索引
            }
        }

        return -1;
    }
}
