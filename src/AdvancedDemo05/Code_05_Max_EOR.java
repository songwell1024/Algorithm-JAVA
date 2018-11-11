package AdvancedDemo05;

import com.sun.xml.internal.bind.v2.model.core.MaybeElement;

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
                for (int k = j; k <= i; k++){
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
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
            dp[i] = dp[i-1] ^arr[i];
            max = Math.max(max, dp[i]);
            for (int j = 1; j <= i; j++){
                max = Math.max(max, dp[i]^ dp[j-1]);
            }
        }
        return max;
    }

    public static int getMaxEor3(int[] arr){
        int[] dp = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int eor = 0;
        for (int i = 0; i < arr.length; i++){
            eor ^= arr[i];
            max = Math.max(max, eor);
            for (int j = 1; j <= i; j++){
                int curEor = eor ^ dp[j-1];
                max = Math.max(max, curEor);
            }
            dp[i] = eor;
        }
        return max;
    }

    //前缀树求解
    public static class Node {
        public Node[] nexts = new Node[2];
    }

    public static class NumTrie {
        public Node head = new Node();

        public void add(int num) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                int path = ((num >> move) & 1);
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                int best = move == 31 ? path : (path ^ 1);              //符号位尽量选一样的，因为异或运算之后为0是正数，然后数值位的话尽量选1
                best = cur.nexts[best] != null ? best : (best ^ 1);     //如果有这条路径的话就走，没有只能退而求其次走另一条
                res |= (path ^ best) << move;       // num的当前位与最优选择位异或然后左移回到原来位置（因为现在这个值所在的是最低位）
                cur = cur.nexts[best];
            }
            return res;
        }

    }

    public static int maxXorSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            max = Math.max(max, numTrie.maxXor(eor));
            numTrie.add(eor);
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr ={1,17,5,7,3,2};
        System.out.println(getMaxEor3(arr));
        System.out.println(getMaxEor2(arr));
        System.out.println( maxXorSubarray(arr));
    }


}
