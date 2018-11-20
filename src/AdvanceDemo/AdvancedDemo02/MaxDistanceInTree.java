package AdvanceDemo.AdvancedDemo02;

/**
 * 二叉树中，一个节点可以往上走和往下走，那么从节点A总能走到节点
 B。
 节点A走到节点B的距离为：A走到B最短路径上的节点个数。
 求一棵二叉树上的最远距离
 * @author WilsonSong
 * @date 2018/10/29/029
 */
public class MaxDistanceInTree {

    public class Node{
        public Node parent;
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    public class ReturnType{
        public int height;
        public int distance;

        public ReturnType(int height, int distance){
            this.height = height;
            this.distance = distance;
        }
    }

    public int getMaxDistance(Node head){
        return process(head).distance;
    }

    public ReturnType process(Node head){
        if (head == null){
            return new ReturnType(0,0);
        }
        Node right = head.right;
        ReturnType RInf = process(right);
        Node left = head.left;
        ReturnType LInf = process(left);

        int MaxDis = Math.max(Math.max(RInf.distance, LInf.distance),RInf.height + LInf.height + 1);

        return new ReturnType(MaxDis, Math.max(LInf.height, RInf.height) + 1 );
    }

}
