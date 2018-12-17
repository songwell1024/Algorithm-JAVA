package BasicExample.BasicExamples08;

/**
 * 汉诺塔问题打印n层汉诺塔从最左边移动到最右边的全部过程
 * 汉诺塔其实就是把左侧从小到大的排列的数挪到右边的杆上，中间有一个辅助使用的杆，挪的过程不允许小数压在大数上面
 * 其实就是左侧1-n-1挪到help上，然后n挪到右侧，剩下的1-n-1从help挪到右侧，其实这又是一个递归的过程
 * @author WilsonSong
 * @date 2018/12/17/017
 */
public class Code_02_Hanoi {

    public static void printHanoi(int n){
        processHanoi(n,n,"left","right","mid");
    }
    public static void processHanoi(int ret, int n, String from, String to, String help){
        if (ret == 1){
            System.out.println("move " + n + "from "+ from + "to " + to);
        }

        processHanoi(ret-1, n-1,from, help,to);
        processHanoi(1,n,from,to, help);
        processHanoi(ret-1, n-1,help, to, from);


    }

}
