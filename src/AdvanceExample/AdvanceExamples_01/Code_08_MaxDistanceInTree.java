package AdvanceExample.AdvanceExamples_01;

/**
 * 二叉树节点间距离的概念：二叉树一个节点到另一个节点间最短线路上的节点
 数量，叫做两个节点间的距离。
 给定一棵二叉树的头节点head，请返回这棵二叉树上的最大距离。

 其实一棵树的最大距离是左子树的最大深度 + 右子树的最大深度 +1，或者是左子树的最大距离，或者是右5子树的最大距离
 依次递归
 * @author WilsonSong
 * @date 2019/1/1/001
 */
public class Code_08_MaxDistanceInTree {
    public class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    public static int getLongestDis(Node head){

        int[] record = new int[1];         //数组是一个全局的变量,存放的是左右子树的最大深度
        return process(head, record);
    }

    public static int process(Node head, int[] record){
        if (head == null){
            record[0] = 0;
            return 0;
        }

        int lmax = process(head.left, record);
        int leftDepth = record[0];
        int rmax = process(head.right, record);
        int rifhtDepth = record[0];

        int CurMaxLength = leftDepth + rifhtDepth + 1;
        record[0] = Math.max(leftDepth, rifhtDepth) + 1;

        return Math.max(Math.max(lmax,rmax), CurMaxLength);
    }




}
