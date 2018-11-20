package BasicDemo.Demo03;

/**
 * 判断二叉树是否是平衡树
 * @author WilsonSong
 * @date 2018/9/10/010
 */
public class IsBalanceTree {

    private static class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    public static boolean BalanceTree(Node head){
        boolean[] res = new boolean[1];     //数组的局部变量是可以改变的，然后通过传参传回来
        res[0] = true;
        if (head == null){
            return true;
        }
        getHeight(head, 1, res);
        return  res[0];
    }

    public static int getHeight(Node node, int level, boolean[] isBT){
        if (node == null){
            return level;
        }
        int lH = getHeight(node.left, level +1, isBT);
        if (!isBT[0]){
            return level;
        }
        int rH = getHeight(node.right, level+1, isBT);
        if (!isBT[0]){
            return level;
        }
        if (Math.abs(lH - rH) > 1){
            isBT[0] = false;
        }
        return Math.max(lH, rH);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(BalanceTree(head));

    }
}
