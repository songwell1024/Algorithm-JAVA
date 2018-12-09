package BasicExample.BasicExamples04;

/**
 * 判断一棵树是否是平衡树，一个节点的左子树和右子树的高度差不能超过1
 * @author WilsonSong
 * @date 2018/12/8/008
 */
public class Code_06_IsBalancedTree {

    public static class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isBalanceTree(Node head){
        if (head == null){
            return true;
        }
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];


    }

    //通过左右子树的高度来判断是否是平衡树
    public static int getHeight(Node head, int level, boolean[] res){
        if (head == null){
            return level;
        }
        int leftHeight = getHeight(head.left, level +1, res);
        if (!res[0]){      //其实到这里返回的时候，函数已经结束了，因为要的是树的高度，直接返回该值，同时此时res的值也是对应的不平衡的变量，所以返回
            return level;
        }
        int rightHeight = getHeight(head.right, level + 1, res);
        if (!res[0]){
            return level;
        }
        if (Math.abs(leftHeight - rightHeight) > 1){
            res[0] = false;
        }
        return Math.max(leftHeight, rightHeight);


    }


}
