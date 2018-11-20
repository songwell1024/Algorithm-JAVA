package BasicDemo.Demo03;

/**
 * 已知一棵完全二叉树，求其节点的个数
 要求：时间复杂度低于O(N)，N为这棵树的节点个数
 思路：要是直接就是O(N)的话遍历就好，要求小于O(N)怎么做呢？
 一棵L层满二叉树,2^L-1个节点
 那么一开始先遍历树的左边界的深度，然后遍历右子树的的左边界看到没到最后一层，到了左子树就是满二叉树，没到右子树就是满二叉树
 然后左子树就又是一棵完全二叉树，递归求解
 * @author WilsonSong
 * @date 2018/9/11/011
 */
public class CompleteTreeNodeNumber {
    private static class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    public static int NodeNum(Node head){
        if (head == null){
            return 0;
        }
        return getNodeNumber(head);
    }

    public static int getNodeNumber(Node node){
        int height = 0;
        int rH = 0;
        if (node == null){
            return 0;
        }
        Node cur  = node;
        while (cur.left != null){
            height ++;
            cur = cur.left;
        }
        cur = node.right;
        while (cur != null){
            rH ++;
            cur = cur.left;
        }

        if (height == rH){
            return  (( 1 << height) + getNodeNumber(node.right));
        }else {
            return ((1 << rH) + getNodeNumber(node.left));
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(NodeNum(head));

    }
}
