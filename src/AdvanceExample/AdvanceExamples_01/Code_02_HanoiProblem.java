package AdvanceExample.AdvanceExamples_01;

/**
 * 给定一个数n，表示n层汉诺塔问题，请打印最优步数的所有过程
 *
 *
 *给定一个整形数组arr，其中只含有1、2和3，代表所有圆盘目前的状态。1代表左柱，2代表中柱，3代表右柱，
 * arr[i]代表第i+1个圆盘的位置。比如，arr=[3,3,2,1]，代表第一个盘子在右柱上，第二个盘子在右柱上，第三个圆盘在中柱上，
 * 第四个圆盘在左柱上。如果arr代表的状态是最优移动轨迹过程中出现的状态，
 * 返回arr这种状态是最优移动轨迹中的第几个状态。如果arr代表的状态不是最优移动轨迹过程中出现的状态，则返回-1.
 *
 *
 * 首先设from柱子上的圆盘为1~i-1，如果移动到to上的最少步骤数，假设为S(i)。根据此前汉诺塔的解题步骤可得，S(i)=步骤1的步骤总数+1+步骤3的步骤
 * 总数= S(i-1)+1+S(i-1),由于S(1)=1.所以S(i)+1 = 2(S(i-1)+1)，根据等比数列的求和公式可得S(i)+1 = 2^i，所以S(i)=2^i-1.
 *
 第N-1个圆盘在from柱子上，则需要考虑1~N-2个柱子的情况。
 如果第N-1个圆盘在mid柱子上，则返回-1.因为按照汉诺塔的最佳移动方式，最后一个圆盘是不可能出现在中间的。
 如果第N-1个圆盘出现在to柱子上，则有两种可能，1~N-2个圆盘都在mid柱子上，或者在mid到to的过程中。此时的柱子最少已经走完了2^i-1步。由于from上的最后一个
 圆盘转移到了to柱子上因此还需要+1，则最少走完的步数为2^i-1.之后需要考虑1~N-2个圆盘的情况。
 * @author WilsonSong
 * @date 2018/12/26/026
 */
public class Code_02_HanoiProblem {

    public static void printStep(int n){
        process(n,n,"left","mid","right");
    }

    public static void process(int res, int n, String from, String help, String to){
        if (res == 1){
            System.out.println("move " + n + " from " + from + " to " + to);
        }

        process(res -1, n -1, from,to,help);
        process(1,n,from,help,to);
        process(res-1,n-1,help,to,from);
    }


    //进阶
    public static int step1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return process2(arr, arr.length - 1, 1, 2, 3);
    }

    public static int process2(int[] arr, int i, int from, int mid, int to) {
        if (i == -1) {
            return 0;
        }
        if (arr[i] != from && arr[i] != to) {
            return -1;
        }
        if (arr[i] == from) {
            return process(arr, i - 1, from, to, mid);
        } else {
            int rest = process(arr, i - 1, mid, from, to);
            if (rest == -1) {
                return -1;
            }
            return (1 << i) + rest;
        }
    }

}
