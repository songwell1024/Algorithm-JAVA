package Demo5;

/**
 * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的
 数字，能不能累加得到aim，返回true或者false
 * @author WilsonSong
 * @date 2018/9/20/020
 */
public class GetAim {

    public static boolean ComeAim(int[] data, int aim){
        if (data == null){
            return false;
        }
        if (data.length == 1 && aim != data[1]){
            return false;
        }
        return  process(data,aim,0, 0);
    }

    public static boolean process(int[] data, int aim, int i, int sum){
        if (sum == aim){
            return true;
        }
        if (i == data.length){
            return false;
        }
        return process(data,aim, i+1, sum) || process(data, aim,i+1, sum+data[i]);
    }

    //解法2  通过上面的递归过程将动态规划的方程推出来的
	//其实递归过程中的所有的值都会出现在一个二维动态规划表中，对于这道题来说二维动态规划表的变量就是i和sum
	//然后动态规划表的大小就是数组的长度和数组和的大小，因为就是这个数组中有多少和值的问题
	//然后在aim那一列的值就是true的，其余的都是false
	//从sum == aim的位置往前推，直到走到表的第一个位置，返回该值，这也就是动态规划的过程
    public static boolean money2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }

}
