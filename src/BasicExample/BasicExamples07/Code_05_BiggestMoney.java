package BasicExample.BasicExamples07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，
 正数k 参数4，正数m
 costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花
 费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多
 做k个项目 m表示你初始的资金
 说明：你每做完一个项目，马上获得的收益，可以支持你去做下
 一个 项目。
 输出： 你最后获得的最大钱数。
 两个堆，一个最大堆，一个最小堆，最小堆中放的是花费，最大堆中存放的是可以做的任务中的收益
 * @author WilsonSong
 * @date 2018/12/14/014
 */
public class Code_05_BiggestMoney {

    public class Node{
        public int c;
        public int p;

        public Node(int p, int c){
            this.p = p;
            this.c = c;
        }

    }

    public class costCpmparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }

    }

    public class prefixComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o2.p;
        }
    }


    public int getMuchMoreMoeny(int k ,int M, int[] cost, int[] prefix){

        if (cost == null || prefix == null || k <=0 || M <=0){
            return 0;
        }

        PriorityQueue<Node> costQueue = new PriorityQueue<>(new costCpmparator());
        PriorityQueue<Node> prefixQueue  = new PriorityQueue<>(new prefixComparator());

        Node[] nodes = new Node[cost.length];
        for (int i  = 0; i < cost.length; i++){
            nodes[i] = new Node(cost[i], prefix[i]);
        }
        for (Node node : nodes){
            costQueue.add(node);
        }
        for (int i = 0; i < k; i++){
            while (!costQueue.isEmpty() && costQueue.peek().c <= M){
               prefixQueue.add(costQueue.poll());
            }

            while (prefixQueue.isEmpty()){
                return M;
            }
            M += prefixQueue.poll().p;
        }
        return M;
    }
}
