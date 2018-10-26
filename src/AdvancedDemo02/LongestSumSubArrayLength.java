package AdvancedDemo02;

import java.util.TreeMap;

/**
 * 给定一个数组arr，和一个整数num，求在arr中，累加和等于num的最长
 子数组的长度
 例子：
 arr = {7,3,2,1,1,7,7,7} num = 7
 其中有很多的子数组累加和等于7，但是最长的子数组是{3,2,1,1}，所
 以返回其长度4
 * @author WilsonSong
 * @date 2018/10/26/026
 */
public class LongestSumSubArrayLength {

    public static int getSubArrayLength(int[] arr, int num){
        int sum = 0;
        int LongestLength = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (map.containsKey(sum - num)){
                LongestLength = Math.max(LongestLength,i - map.get(sum - num));
            }else {
                map.put(sum, i);
            }
        }
        return LongestLength;
    }
}
