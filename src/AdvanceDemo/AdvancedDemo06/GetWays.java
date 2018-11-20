package AdvanceDemo.AdvancedDemo06;

/**
 * 给定一个整数N,表示从1-n个位置，现在有一个人在M位置，可以向前可以向后走，问P步之后所在位置是K位置的走法有多少种
 * 当M==1时只能往前，当M==N是只能往后
 * @author WilsonSong
 * @date 2018/11/14/014
 */
public class GetWays {


    //暴力递归
    public static int getWays(int n, int m, int p, int k){
        if (n < 2 || m < 1 || m > n || k < 1 || k > n){
            return 0;
        }
        if (p == 0){
            return m == k ? 1 : 0;
        }

        int res = 0;
        if (m == 1){
            res += getWays(n, m + 1, p - 1, k );
        }else if (m == n){
            res += getWays(n, m - 1, p - 1, k);
        }else{
            res += (getWays(n, m - 1, p - 1, k) +  getWays(n, m + 1, p - 1, k));
        }
        return res;
    }

    public static int getWays2(int n, int m, int p, int k){
        if (n < 2 || m < 1 || m > n || k < 1 || k > n){
            return 0;
        }
        int[][] res = new int[n][p+1];
        res[k-1][0] = 1;
        for (int j = 1; j <= p; j++){
            for (int i = 0; i < n; i++){
                if (i == 0){
                    res[i][j] = res[i+1][j-1];
                }else if (i == n-1){
                    res[i][j] = res[i-1][j-1];
                }else {
                    res[i][j] = res[i-1][j-1] + res[i+1][j-1];
                }
            }
        }
        return res[m-1][p];
    }

    public static void main(String[] args){
        System.out.println(getWays(4,2,2,2));
        System.out.println(getWays2(4,2,2,2));
    }
}
