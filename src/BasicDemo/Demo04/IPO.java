package BasicDemo.Demo04;

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
 * @author WilsonSong
 * @date 2018/9/13/013
 */
public class IPO {
    private class Node{
        public int c;
        public int p;

        public Node(int c, int p){
            this.c = c;
            this.p = p;
        }
    }

    public  int MoreMoney(int[] costs, int[] profits, int k, int money){
        PriorityQueue<Node> cost = new PriorityQueue<>(new Comparator<Node>() {      //按花费从大到小
            @Override
            public int compare(Node o1, Node o2) {
                return o1.c - o2.c;
            }
        });

        PriorityQueue<Node> profit = new PriorityQueue<>(new Comparator<Node>() {       //按利润从大到小
            @Override
            public int compare(Node o1, Node o2) {
                return o2.p - o1.p;
            }
        });

        for (int i = 0; i < costs.length; i++){
            profit.add(new Node(costs[i], profits[i]));
        }
        int number = 0;
        while (!profit.isEmpty() && number <= k){
            Node node = profit.poll();
            if (money >= node.c){
                k++;
                money += node.p;
                while (!cost.isEmpty()){
                    profit.add(cost.poll());
                }
            }else {
                cost.add(node);
            }
        }
        return money;
    }


}
