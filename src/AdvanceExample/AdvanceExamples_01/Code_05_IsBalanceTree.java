package AdvanceExample.AdvanceExamples_01;

/**
 * 给定一棵二叉树的头节点head，判断这棵树是不是平衡二叉树
 * @author WilsonSong
 * @date 2018/12/31/031
 */
public class Code_05_IsBalanceTree {

    public class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    public static boolean isBalanceTree(Node head){
        if (head == null){
            return true;
        }

        boolean[] res = new boolean[1];
        res[0] = true;         //是否是非叶子节点
        process(head, res, 0);
        return res[0];

    }

    public static int process(Node head, boolean[] res, int level){
        if (head == null){
            return level;
        }

        int leftHeight = process(head.left, res,level + 1);
        if (!res[0]){
            return leftHeight;
        }

        int rightHeight = process(head.right, res, level + 1);
        if (!res[0]){
            return rightHeight;
        }

        if (Math.abs(rightHeight - leftHeight) > 1){
            res[0] = false;
        }
        return Math.max(leftHeight, rightHeight);
    }
}
