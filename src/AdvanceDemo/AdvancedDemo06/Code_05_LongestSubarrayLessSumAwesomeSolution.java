package AdvanceDemo.AdvancedDemo06;

import java.util.HashMap;

/**
 * 给定一个数组arr，值可正，可负，可0；一个整数aim，求累加
 和小于等于aim的，最长子数组，要求时间复杂度O(N)
 * @author WilsonSong
 * @date 2018/11/17/017
 */
public class Code_05_LongestSubarrayLessSumAwesomeSolution {

    public static int getMalLength(int[] arr, int aim){
        if (arr == null || arr.length == 0){
            return 0;
        }

        int[] min_sum = new int[arr.length];
        int[] min_index = new int[arr.length];

        min_index[arr.length-1] = arr.length-1;
        min_sum[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length - 2; i >=0; i--){
            min_sum[i] = min_sum[i+1] < 0 ? min_sum[i+1] + arr[i] : arr[i];
            min_index[i] = min_sum[i+1] < 0 ? min_index[i+1] : i;
        }
        int end = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++){
            while (end < arr.length && sum + min_sum[end] <= aim) {
                sum += min_sum[end];
                end = min_index[end] + 1;
            }
            sum -= end > i ? arr[i] : 0;
            res = Math.max(res, end - i);
            end = Math.max(end, i + 1);
        }
        return res;
    }

    public static int maxLengthAwesome(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] sums = new int[arr.length];
        HashMap<Integer, Integer> ends = new HashMap<Integer, Integer>();
        sums[arr.length-1] = arr[arr.length - 1];
        ends.put(arr.length - 1, arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (sums[i + 1] < 0) {
                sums[i] = arr[i] + sums[i + 1];
                ends.put(i, ends.get(i + 1));
            } else {
                sums[i] = arr[i];
                ends.put(i, i);
            }
        }
        int end = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (end < arr.length && sum + sums[end] <= k) {
                sum += sums[end];
                end = ends.get(end) + 1;
            }
            sum -= end > i ? arr[i] : 0;
            res = Math.max(res, end - i);
            end = Math.max(end, i + 1);
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {1,4,-5,9, 1,-8};
        System.out.println(getMalLength(arr,5));
        System.out.println(maxLengthAwesome(arr, 5));
    }


}
