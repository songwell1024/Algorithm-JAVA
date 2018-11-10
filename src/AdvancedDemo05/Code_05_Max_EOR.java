package AdvancedDemo05;

/**
 * 给定一个数组，求子数组的最大异或和。
 一个数组的异或和为，数组中所有的数异或起来的结果。
 * @author WilsonSong
 * @date 2018/11/10/010
 */
public class Code_05_Max_EOR {

    //暴力求解，时间复杂度O(N3)
    public static int getMaxEor1(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j <= i; j++){
                int res = 0;
                for (int k = 0; k <= j; k++){
                    res ^= arr[k];
                }
                max = Math.max(max, res);
            }
        }
        return max;
    }

    //dp求解

    public static int getMaxEor2(int[] arr){
        int[] dp = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            dp[i] ^= arr[i];
            for (int j = 0; j <= i; j ++){
                max = Math.max(max, dp[i]^ dp[j]);
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr ={1,17,5,7,3,2};
        System.out.println(getMaxEor1(arr));
        System.out.println(getMaxEor2(arr));
    }


}
