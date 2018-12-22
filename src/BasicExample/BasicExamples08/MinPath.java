package BasicExample.BasicExamples08;

/**
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 加起来。返回最小的路径和。
 * @author WilsonSong
 * @date 2018/12/22/022
 */
public class MinPath {

    public static int getMinPath(int[][] num){
        if (num.length == 0 || num[0].length == 0 || num == null){
            return 0;
        }
        return process( 0, 0, num);
    }

    public static int process(int i, int j, int[][] num){
        if (i == num.length && j == num[0].length){
            return num[i][j];
        }else if (i == num.length){
            return num[i][j] + process( i, j +1,num);
        }else if (j == num[0].length){
            return num[i][j] + process( i + 1, j,num);
        }
        return num[i][j] + Math.min(process(i,j+1,num), process(i+1,j,num));
    }
}
