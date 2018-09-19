package Demo5;

/**
 * 汉诺塔问题打印n层汉诺塔从最左边移动到最右边的全部过程
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
