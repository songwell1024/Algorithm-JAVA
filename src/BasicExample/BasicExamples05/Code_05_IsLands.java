package BasicExample.BasicExamples05;

/**
 * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
 四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
 矩阵中有多少个岛？
 其实就是一个感染的过程，就是把所有1连在一起的数变成2，接下来遍历到的如果不是1的话就往下走，是1就继续进行感染
 * @author WilsonSong
 * @date 2018/12/11/011
 */
public class Code_05_IsLands {
    public static int landNum(int[][] num){
        if (num == null || num[0].length == 0){
            return 0;
        }
        int m = num.length;
        int n = num[0].length;
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j ++){
                if (num[i][j] == 1){
                    res ++;
                    infect(num,i,j,n,m);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] num, int i, int j, int n, int m){
        if (i< 0|| j< 0 || i >= n|| j >= m || num[i][j] != 1){
            return;
        }

        num[i][j] = 2;
        infect(num,i +1,j, n,m);
        infect(num,i-1,j,n,m);
        infect(num,i, j+1,n,m);
        infect(num,i,j-1,n,m);


    }
}
