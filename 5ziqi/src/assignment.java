
import java.util.Scanner;//键盘输入
public class assignment {
    static int[][]map =new int[19][19];//定义全局变量--棋盘
    static int flag =0;
    static Scanner sc = new Scanner(System.in);//声明

    public  static void main(String[] args) {
        menuView();
        gameView();
        return ;
    }

    private static void init(){
        /*
    负责人:
    功能: 初始化游戏数据
        将棋盘的值初始化为0
        当前回合设为黑棋(flag设为0)
    参数: void
    返回值: void
*/
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                map[i][j] = 0;
            }
        }
        flag = 0;
    }

    private static int isWin(int x, int y){//返回值0，1，2，分别没赢，黑色赢，白色赢直接调用winView();
        //判断是否赢--判断是否有5颗相同的棋子相连--由于我们需要每落下一枚棋子都需要判断是否连成5颗,同时每次只有黑色或者白色落下
        // --所以当flag>=9时，我们可以先判断是否胜利--5个相同的flag相连--如果满足再分黑或白胜利否则没有获胜
        if (flag >= 7&&flag<=19*19) {//至少九次才能胜利，从0开始 //对于胜利可从行，列，左对角，后对角判断,并且只取前后4个--min,max
            int min=0;//初始为0个
            int max = 0;
            //boolean b =i>=0&&i<19&&j>=0&&j<19;当比较时可能出现超出索引的情况，这时候可以直接break
            //行--只需要前面min个与后面max个：max+min>+1=5胜利min：i：从y到y-4--只要值相等flag break--min+=1,继续;相反break;


                min = 0;//左初始话
                max = 0;//右初始话
                for (int i = y - 1; i >= 0; i--) { // 最多4次
                    //boolean b = i >= 0 && i < 19;//不能越界
                    if (map[x][i] == flag%2 )//相等--相连
                        min += 1;
                    else
                        break;
                }
                // 检查横向右边四个棋子
                for (int i = y + 1; i <= 18; i++) { // 最多4次
                    //boolean b = i >= 0 && i < 19;//不能越界
                    if ( map[x][i] == flag%2 ) {//相等--相连
                        max += 1;
                    }else
                        break;
                }
                System.out.println(max);
                if (max + min+1 >= 5) { //如果赢了，就不用继续判断了；
                    if (flag % 2 == 0) {//判断谁赢了flag%2偶数，黑色赢
                        winView();
                        System.out.println("黑色赢");
                        return 1;
                    } else {//判断谁赢了flag%2奇数，白色赢
                        winView();
                        System.out.println("白色赢");
                        return 2;
                    }
                }

            //列--同上

                min = 0;//左初始话
                max = 0;//右初始话
                for (int i = x - 1; i >= 0; i--) {//4次
                    //boolean b =i>=0&&i<19;//不能越界
                    if (map[i][y] == flag%2) //相等--相连
                        min += 1;
                    else
                        break;
                }
                for (int i = x + 1; i <= 18; i++) {//4次
                    //boolean b =i>=0&&i<19;//不能越界
                    if (map[i][y] == flag%2) //相等--相连
                        max += 1;
                    else
                        break;
                }
                if (max + min+1 >= 5) {//如果赢了，就不用继续判断了；
                    if (flag % 2 == 0) {//判断谁赢了flag%2偶数，黑色赢
                        winView();
                        System.out.println("白黑赢");
                        return 1;
                    }
                    else {
                        winView();
                        System.out.println("白色赢");
                        return 2;//奇数，白色赢
                    }
                }

            //右对角x与y同时-，+

                min = 0;//左上初始话--有几颗相连
                max = 0;//右下初始话--有几颗相连
                for (int i = x - 1,j=y-1; i >= 0&&j>=0; i--,j--) {//4次
                    //boolean b =i>=0&&i<19&&j>=0&&j<19;//不能越界
                    if (map[i][j] == flag%2) //相等--相连
                        min +=1 ;//这里可以用加法，记录左上有几颗相连
                    else
                        break;
                }
                for (int i = x + 1,j=y+1; i <19&&j<19; i++,j++) {//4次
                    //boolean b =i>=0&&i<19&&j>=0&&j<19;//不能越界
                    if ( map[i][j] == flag%2) //相等--相连
                        max +=1 ;//这里可以用加法，记录右下有几颗相连
                    else
                        break;
                }
                if (max + min+1 >= 5) {//如果赢了，就不用继续判断了；
                    if (flag % 2 == 0) {//判断谁赢了flag%2偶数，黑色赢
                        winView();
                        System.out.println("白黑赢");
                        return 1;
                    }
                    else {
                        winView();
                        System.out.println("白色赢");
                        return 2;//奇数，白色赢
                    }
                }

            //左对角x与y相反-,+

                min = 0;//左下初始话--有几颗相连
                max = 0;//右上初始话--有几颗相连
                for (int i = x - 1,j=y+1; i >= 0&&j<19; i--,j++) {//4次
                    //boolean b =i>=0&&i<19&&j>=0&&j<19;//不能越界
                    if ( map[i][j] == flag%2) //相等--相连
                        min +=1 ;//这里可以用加法，记录左下有几颗相连
                    else
                        break;
                }
                for (int i = x + 1,j=y-1; i <19&&j>=0; i++,j--) {//4次
                    //boolean b =i>=0&&i<19&&j>=0&&j<19;//不能越界
                    if ( map[i][j] == flag%2) //相等--相连
                        max +=1 ;//这里可以用加法，记录右上有几颗相连
                    else
                        break;
                }
                if (max + min+1 >= 5) {//如果赢了，就不用继续判断了；
                    if (flag % 2 == 0) {//判断谁赢了flag%2偶数，黑色赢
                        winView();
                        System.out.println("白黑赢");
                        return 1;
                    }
                    else {
                        winView();
                        System.out.println("白色赢");
                        return 2;//奇数，白色赢
                    }
                }
            }

        return 0;//没赢
    }

    private static int playerMove(int x, int y) {
        //先判断到谁落子了，黑色还是白色
        if (flag % 2 == 0) {//到黑色落子:1
            //判断落子位置是否有效--对应位置的值为0吗？
            if (map[x][y] == 0) { //为0，说明为空，可以落子
                map[x][y] = 1;//落子成功
                //flag += 1;//回合加一，到白色了,最后加了
                return 1;//落子成功
            } else//这里注意，因为赋值时，只有0，1，2所以直接用else，没用if()
                //System.out.println("落子失败");
                return 0;//落子失败
        }
        if (flag % 2== 1) {//到白色落子:2
            //判断落子位置是否有效--对应位置的值为0吗？
            if (map[x][y] == 0) { //为0，说明为空，可以落子
                map[x][y] = 2;//落子成功
                //flag += 1;//回合加一，到黑色了,最后加了
                return 1;//落子成功
            } else//这里注意，因为赋值时，只有0，1，2所以直接用else，没用if()
                //System.out.println("落子失败");
                return 0;//落子失败
        }
        return 0;
    }

    private static void menuView(){
        //打印菜单选项
        System.out.println("欢迎来到五子棋菜单界面");
        System.out.println("进入游戏(请输入0)");
        System.out.println("进入设置(输入1)");
        System.out.println("退出游戏(请输入2)");
        System.out.println("请输入你的选项0，1，2");
        int option = sc.nextInt();
        switch (option){
            case 0:
                gameView();
                break;
            case 1:
                System.out.println("敬请期待...\n按任意键返回菜单");
                //按任意键返回
                String c = sc.next();
                if (!c.equals("")) //有输入，不为空，表示任意键
                    menuView();
                break;
            case 2:
                System.exit(0);//退出游戏
                break;
            default://输入了无效的选项，回到菜单
                menuView();
                break;
        }
    }

    private static void gameView_ShowMap(){//直接打印当前棋盘
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j <19 ; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();//换行
        }
    }

    private static void winView(){
        //从isWin();判断，胜利直接调用该函数
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j <19 ; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();//换行
        }
    }

    private static void gameView(){
 /*
    *难点2
    负责人:
    功能: 游戏界面整合
        初始化游戏数据(调用函数init())//
        while(1){
            打印游戏界面(调用函数gameView_ShowMap())
            接收玩家坐标输入

            落子(调用落子函数playerMove())
                (如果落子失败 重新开始循环)

            判断游戏是否胜利(调用胜利判断函数isWin())
                (如果游戏胜利 调用胜利界面函数 然后结束当前界面)
            切换玩家(修改flag值)
        }
    参数: void
    返回值: void
*/
        init();//初始化游戏数据
        while (true){
            gameView_ShowMap();//打印当前游戏界面
            if (flag%2==0)
                System.out.println("请黑色玩家输入坐标");
            else
                System.out.println("请白色玩家输入坐标");

            int x=sc.nextInt(),y=sc.nextInt();//接收玩家坐标输入
            while (true) {
                if (x >= 0 && x < 19 && y >= 0 && y < 19) {//超过棋盘重新输入
                    int c = playerMove(x, y);//第一次落子,并返回值，0失败，1成功
                    while ( !(x >= 0 && x < 19 && y >= 0 && y < 19)||c == 0) {//重复或者，说明落子失败，需要重新落子
                        System.out.println("请玩家重新输入有效坐标");
                        x = sc.nextInt();
                        y = sc.nextInt();//重新接收玩家坐标输入
                        c = playerMove(x, y);//再看返回值
                    }
                } else{
                    System.out.println("请玩家重新输入有效坐标");
                    x = sc.nextInt();
                    y = sc.nextInt();//接收玩家坐标输入
                }
                int a =isWin(x,y);//该函数包含了调用胜利界面函数，,并记录返回值
                if (a!=0){//判断是否赢了，不赢没事发生，赢了结束当前界面--我理解为先初始化棋盘，再返回到菜单界面
                    init();
                    menuView();//显示菜单
                    break;
                }
                break;
            }
            flag+=1;//切换玩家
            //flag%=2;
        }
        }
    }



