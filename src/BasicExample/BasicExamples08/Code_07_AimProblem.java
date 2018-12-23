package BasicExample.BasicExamples08;

/**
 * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的
 数字，能不能累加得到aim，返回true或者false
 * @author WilsonSong
 * @date 2018/12/23/023
 */
public class Code_07_AimProblem {

    public static boolean getAim(int[] arr, int aim){
        if (arr == null || arr.length == 0){
            return false;
        }
        return process(arr,0, aim);

    }

    public static boolean process(int[] arr, int i, int aim){
        if (aim == 0){
            return true;
        }
        if (i == arr.length){
            return false;
        }

        return process(arr,i+1,aim- arr[i]) || process(arr,i+1, aim);
    }

    //动态规划
    public static boolean getAim2(int[] arr, int aim){
        if (arr == null || arr.length == 0){
            return false;
        }

        boolean[][] dp = new boolean[arr.length+1][aim+1];

        for (int i = 0; i <= aim; i++){
            dp[i][aim] = true;
        }

        for (int i = arr.length-1; i > 0; i--){
            for (int j = aim-1; j > 0; j -- ){
                dp[i][j] = dp[i +1][j];
                if (j + arr[i] <= aim){
                    dp[i][j] = dp[i][j] || dp[i+1][j + arr[i]];
                }
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args){
        int[] arr = { 1, 4, 8 };
        int aim = 12;
        System.out.println(getAim(arr,aim));
    }


}
