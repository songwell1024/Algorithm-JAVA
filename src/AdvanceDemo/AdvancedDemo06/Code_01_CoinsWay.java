package AdvanceDemo.AdvancedDemo06;

import java.util.HashMap;

/**
 * 换钱的方法数
 【题目】
 给定数组arr，arr中所有的值都为正数且不重复。每个值代表
 一种面值的货币，每种面值的货币可以使用任意张，再给定一
 个整数aim代表要找的钱数，求换钱有多少种方法。
 【举例】
 arr=[5,10,25,1]，aim=0。
 组成0元的方法有1种，就是所有面值的货币都不用。所以返回1。
 arr=[5,10,25,1]，aim=15。
 组成15元的方法有6种，分别为3张5元、1张10元+1张5元、1张
 10元+5张1元、10张1元+1张5元、2张5元+5张1元和15张1元。所
 以返回6。
 arr=[3,5]，aim=2。
 任何方法都无法组成2元。所以返回0。
 * @author WilsonSong
 * @date 2018/11/11/011
 */
public class Code_01_CoinsWay {

    public int getCoinsWay(int[] arr, int aim){
        if (arr == null || arr.length == 0){
            return 0;
        }
        return process(arr,0,aim);
    }

    //暴力递归
    public int process(int[] arr, int index, int aim){
        int res = 0;
        if (index == arr.length){
            res = aim == 0 ? 1 : 0;
        }else {
            for (int i = 0; (i * arr[index]) <= aim; i++){
                res += process(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public HashMap<String, Integer> map = new HashMap<>();
    //key: "index_aim"
    //value: 返回值
    public int process_map(int[] arr, int index, int aim){
        int res = 0;
        if (index == arr.length){
            res = aim == 0 ? 1 : 0;
        }else {
            for (int i = 0; i * arr[index] <= aim; i++){
                int nextAim = aim - i * arr[index];
                String key = String.valueOf(index) + "_" + String.valueOf(nextAim);
                if (map.containsKey(key)){
                    res += map.get(key);
                }else {
                    res += process(arr, index +1, nextAim);
                }
            }
            map.put(String.valueOf(index) + "_" + String.valueOf(aim), res);
        }
        return res;
    }


    //动态规划的方式求解
    public int getCoinsWay2(int[] arr, int aim){
        if (arr.length == 0 || arr == null){
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++){
            dp[i][0] = 1;                //可以从递归过程中看出来
        }
        for (int i = 0; i * arr[0] <= aim; i++){
            dp[0][i * arr[0]] = 1;
        }

        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j <= aim; j++){
                int num = 0;
                for (int k = 0; k * arr[i] <= j; k++){
                    num += dp[i -1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length-1][aim];
    }


}
