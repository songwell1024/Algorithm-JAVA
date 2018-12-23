package BasicExample.BasicExamples08;

/**
 * 给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的
 重量，v[i]表示第i件商品的价值。 再给定一个整数bag，要求
 你挑选商品的重量加起来一定不能超 过bag，返回满足这个条件
 下，你能获得的最大价值。
 * @author WilsonSong
 * @date 2018/12/23/023
 */
public class Code_08_MaxWorth {

    public static int getMAxWorth(int[] w, int[] v, int bag){
        if (w == null ||  v == null || bag == 0){
            return 0;
        }

        return process(w,v,0,0,bag);
    }

    public static int process(int[] w, int[] v, int i, int weight, int bag ){
        if (i == w.length){
            return 0;
        }
        if (weight > bag){
            return 0;
        }
        return Math.max(process(w,v,i+1,weight + w[i],bag) + v[i],process(w,v,i+1,weight,bag));
    }

    public static int getMAxWorth2(int[] w, int[] v, int bag){
        if (w == null ||  v == null || bag == 0){
            return 0;
        }

        int[][] dp = new int[w.length +1][bag +1];
        for (int i = w.length; i > 0; i--){
            for (int j = bag; j> 0; j ++){
                dp[i][j] = dp[i+1][j];
                if (j + w[i] < bag){
                    dp[i][j] = Math.max(dp[i][j],dp[i+1][j+w[i]]);
                }

            }
        }
        return dp[0][0];
    }


}
