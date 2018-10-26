package AdvancedDemo02;

import java.util.TreeMap;

/**
 * 定义数组的异或和的概念：
 数组中所有的数异或起来，得到的结果叫做数组的异或和，
 比如数组{3,2,1}的异或和是，3^2^1 = 0
 给定一个数组arr，你可以任意把arr分成很多不相容的子数组，你的目的是：
 分出来的子数组中，异或和为0的子数组最多。
 请返回：分出来的子数组中，异或和为0的子数组最多是多少？
 * @author WilsonSong
 * @date 2018/10/26/026
 */
public class MostEOR {

    public static int getSubEORArray(int[] arr){
        if (arr == null || arr.length ==0 ){
            return 0;
        }
        int[] dp = new int[arr.length];
        int res = 0;
        int sum = 0;
        TreeMap<Integer, Integer> map =  new TreeMap<>();
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++){
            sum ^= arr[i];
            if (map.containsKey(sum)){             //这里每次得到的是与i最近的那个k
                int pre = map.get(sum);
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
            }
            if (i > 0){
                dp[i] = Math.max(dp[i-1], dp[i]);
            }
            map.put(sum, i);    //这里要是key是相同的，那么value的值会被更新掉，所以每次获得的是最新的那个k的值
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
