package BasicDemo.sort;

import java.util.Arrays;

/**
 * 实现思路：使用桶排序的思想
 * 相邻两数的最大差值
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序。
 * @author WilsonSong
 * @date 2018/9/5/005
 */
public class MaxGap {

    public static int  maxGap(int[] arr){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <arr.length; i++){
            max =Math.max(arr[i] ,max);
            min = Math.min(arr[i] , min);
        }

        if (max == min){
            return 0;
        }

        int[] maxs = new int[arr.length + 1];
        int[] mins = new int[arr.length + 1];
        boolean[] hasNumber = new boolean[arr.length +1];
        int bid  = 0;
        for (int i = 0; i < arr.length; i++){
            bid = burket(arr[i], arr.length, min, max);

            mins[bid] = hasNumber[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNumber[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNumber[bid] = true;
        }

        int ret  = 0;
        int lastMax = maxs[0];
        for (int i = 1; i < hasNumber.length ; i++){
            if (hasNumber[i]){
              ret = Math.max(mins[i] - lastMax, ret);
              lastMax = maxs[i];
             }
        }
        return ret;
    }

    private static int burket(long num, long len, long min, long max){
        return (int) ((num - min)* len / (max -min));
    }


    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
