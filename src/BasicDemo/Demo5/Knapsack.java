package BasicDemo.Demo5;

/**
 * 给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的
 重量，v[i]表示第i件商品的价值。 再给定一个整数bag，要求
 你挑选商品的重量加起来一定不能超过bag，返回满足这个条件
 下，你能获得的最大价值。
 这道题目可以用贪心来做，也可以直接用动态规划来做
 * @author WilsonSong
 * @date 2018/9/20/020
 */
public class Knapsack {

    //动态规划的方法 不知道为啥不对
    public static int getMaxWorth(int[] w, int[] v, int bag){
        if (w == null || v == null){
            return 0;
        }
        return Process(w, v, bag, 0, 0);
    }

    public static int Process(int[] w, int[] v, int bag, int i, int sum){
        if (sum > bag){
            return 0;
        } //先判断
        if (i == w.length){
            return 0;
        }
        return Math.max(v[i] + Process(w, v, bag, i+1, sum + w[i]), Process(w, v, bag,i+1, sum));
    }

    //通过动态规划的方式
    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }



    //贪心算法，每次选单位价值最大的物品
    public static int getMaxWorth2(int[] w, int[] v, int bag){
        double[] Pv = new double[w.length];
        for (int i = 0; i< w.length; i++){
            Pv[i] = (double) v[i]/w[i];
        }

        QuickSort(Pv,w,v);
        int weight  = 0;
        int value = 0;
        for (int i = 0; i < Pv.length; i++){
            if (weight < bag){
                weight = weight + w[i];
                if (weight > bag){
                    return value;
                }else {
                    value = value + v[i];
                }
            }
        }
        return value;
    }

    //随机快排
    public static void QuickSort(double[] Pv, int[] w, int[] v){
        if (Pv == null || Pv.length ==1){
            return;
        }
        Process(Pv, 0, Pv.length-1,w, v);
    }

    private static void Process(double[] Pv, int l, int r, int[] w, int[] v){
        if (l < r){
            int[] p = particition(Pv, l, r,w,v);
            Process(Pv, l, p[1], w, v);
            Process(Pv, p[0], r, w, v);
        }
    }

    private static int[] particition(double[] Pv, int l, int r, int[] w, int[] v){
        int less = l -1;
        int more = r;
        int cur = l + (int)(Math.random()*(r-l+1));
        swapDouble(Pv, cur, r);
        swap(w, cur, r);
        swap(v, cur, r);

        while (l < more){
            if (Pv[l] < Pv[r]){
                swapDouble(Pv, l, r-1);
                swap(w, l ,r-1);
                swap(v, l ,r-1);
                more --;
            }else if(Pv[l] > Pv[r]){
                less++;
                l ++;
            }else {
                l++;
            }
        }
        swapDouble(Pv, more, r);
        swap(w, more, r);
        swap(v, more, r);
        return new int[] {  less +1,more -1};
    }

    public static void swap(int[] data, int i, int j){
        int cur = data[i];
        data[i] = data[j];
        data[j] = cur;
    }

    public static void swapDouble(double[] data, int i, int j){
        double cur = data[i];
        data[i] = data[j];
        data[j] = cur;
    }

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(getMaxWorth(c, p, bag));
        System.out.println(getMaxWorth2(c, p, bag));
        System.out.println(maxValue2(c, p, bag));


    }

}
