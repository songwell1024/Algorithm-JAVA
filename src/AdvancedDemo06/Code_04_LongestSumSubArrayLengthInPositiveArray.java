package AdvancedDemo06;

/**
 * 给定一个数组arr，全是正数；一个整数aim，求累加和等
 于aim的，最长子数组，要求额外空间复杂度O(1)，时间
 复杂度O(N)
 * @author WilsonSong
 * @date 2018/11/16/016
 */
public class Code_04_LongestSumSubArrayLengthInPositiveArray {

    public static int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        int L = 0;
        int R = 0;
        int sum = arr[0];
        int len = 0;
        while (R < arr.length) {
            if (sum == k) {
                len = Math.max(len, R - L + 1);
                sum -= arr[L++];
            } else if (sum < k) {
                R++;
                if (R == arr.length) {
                    break;
                }
                sum += arr[R];
            } else {
                sum -= arr[L++];
            }
        }
        return len;
    }

    public static void main(String[] args){
        int[] arr = {3,5,2,3};
        System.out.println(getMaxLength(arr,5));
    }
}
