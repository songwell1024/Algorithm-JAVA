package AdvanceDemo.AdvancedDemo06;

/**
 * 排成一条线的纸牌博弈问题
 【题目】
 给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走
 每张纸牌，规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右
 的纸牌，玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。

 用F[l][r]表示先选的人能拿到的最高分
 用S[l][r]来表示后选的人能拿到的最高分
 如对于一组从0,1,2，...,n-1的数
 对于先选者，他有两种选法
 若先选者选A[0],则对于后面的1，...,n-1数组，他就变成了后选者，此时能拿到的分为A[0]+S[1][n-1]
 若先选者选A[n-1],则对于前面的数组0，...，n-2,同样变为后选者，此时能拿到得分为A[n-1]+S[0][n-2];
 所以 F[0][n-1]=max(A[0]+S[1][n-1],A[n-1]+S[0][n-2])
 对于后选者，他能能到的最高分是受先选者控制的，即他只能选到先选者留给他的最小值，将其转化为数学形式就是
 S[l][r]=min(F[l+1][r],F[l][r-1]);
 这里的最小值是先选者留给他的，他只能拿到最小值，打个比方，我是先选者，我若选A[0]，剩下的留给你选，这个时候主动权在你
 所以你能得到的最大分必为F[1][n-1],我若选A[n-1]，剩下的留给你选，这个时候主动权在你
 所以你能得到的分必为F[0][n-2],我肯定是要把能得到的分少的那个留给你，所以你只能得到Min(F[1][n-1],F[0][n-2]);
 * @author WilsonSong
 * @date 2018/11/13/013
 */
public class Code_02_CardsInLine {

    public int getMaxSocres(int[] arr){
        if (arr.length == 0 || arr == null){
            return 0;
        }
        return Math.max(f(arr, 0, arr.length-1), s(arr, 0, arr.length-1));
    }

    //先拿
    public int f(int[] arr, int i, int j){
        if (i == j){
            return 1;
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i , j - 1));
    }
    //后拿
    public int s(int[] arr, int i, int j){
        if (i == j){
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j-1));
    }

    public int getMaxScores(int[] arr){
        if (arr.length == 0 || arr == null){
            return 0;
        }
        int[][] f = new int[arr.length - 1][arr.length - 1];
        int[][] s = new int[arr.length - 1][arr.length - 1];
//        for (int i = 0; i < arr.length; i ++){
//            f[i][i] = arr[i];
//            s[i][i] = 0;
//        }

        for (int i = 0; i < arr.length; i++){
            f[i][i] = arr[i];
            for (int j = i - 1; j >= 0; j--){
                f[i][j] = Math.max(arr[i] + s[i+1][j], arr[j] + s[i][j-1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }


}
