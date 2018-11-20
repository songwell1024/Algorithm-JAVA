package BasicDemo.Demo04;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如
 长度为20的 金条，不管切成长度多大的两半，都要花费20个铜
 板。一群人想整分整块金 条，怎么分最省铜板？
 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为
 10+20+30=60. 金条要分成10,20,30三个部分。 如果， 先把长
 度60的金条分成10和50，花费60 再把长度50的金条分成20和30，
 花费50 一共花费110铜板。
 但是如果， 先把长度60的金条分成30和30，花费60 再把长度30
 金条分成10和20，花费30 一共花费90铜板。
 输入一个数组，返回分割的最小代价。
 解题思路应该是哈夫曼树
 哈夫曼树就是给你一个数组，然后先找两个最小的构成两个节点，然后其根节点就是的代价就是两个子节点的和
 其实就是用优先队列，先把最小的放进来，然后拿出去两个构成一个根节点的代价，然后放回原数组，然后再取两个最小的
 * @author WilsonSong
 * @date 2018/9/13/013
 */
public class LessMoney {

    public static int LowestCost(int[] data){
        //PriorityQueue默认是最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {    //最小堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
         for (int arr : data){
             queue.add(arr);
         }
        int cost = 0;
         int cur = 0;
         while (queue.size() > 1){
             cur = queue.poll() + queue.poll();
             cost += cur;
             queue.add(cur);
         }
         return cost;
    }

    public static void main(String[] args) {
        // solution
        int[] arr = { 99, 7, 8, 9 };
        System.out.println(LowestCost(arr));
    }

}
