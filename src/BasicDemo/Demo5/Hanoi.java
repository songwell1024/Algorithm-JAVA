package BasicDemo.Demo5;

/**
 * 汉诺塔问题打印n层汉诺塔从最左边移动到最右边的全部过程
 * 汉诺塔其实就是把左侧从小到大的排列的数挪到右边的杆上，中间有一个辅助使用的杆，挪的过程不允许小数压在大数上面
 * 其实就是左侧1-n-1挪到help上，然后n挪到右侧，剩下的1-n-1从help挪到右侧，其实这又是一个递归的过程
 * @author WilsonSong
 * @date 2018/9/14/014
 */
public class Hanoi{
    public static void hanoi(int n){
        if (n > 0){
            func(n,n,"left","mid","right");
        }
    }

    public static void func(int rest, int down, String from, String help, String to){
        if (rest == 1){
            System.out.println("move " + down + " from " + from + " to "+ to);
        }else {
            func(rest-1, down -1, from, to, help);
            func(1,down, from, help,to);
            func(rest-1, down-1, help, from, to);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }
}
