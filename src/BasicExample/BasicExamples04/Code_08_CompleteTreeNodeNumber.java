package BasicExample.BasicExamples04;

/**
 * 已知一棵完全二叉树，求其节点的个数
 要求：时间复杂度低于O(N)，N为这棵树的节点个数
 一棵L层满二叉树,2^L-1个节点
 那么一开始先遍历树的左边界的深度，然后遍历右子树的的左边界看到没到最后一层，到了左子树就是满二叉树，没到右子树就是满二叉树
 然后左子树就又是一棵完全二叉树，递归求解
 * @author WilsonSong
 * @date 2018/12/9/009
 */
public class Code_08_CompleteTreeNodeNumber {
    private static class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    public static int getNodeNum(Node root){
        if (root == null){
            return 0;
        }
        return nodeNumProcess(root);

    }
    public static int nodeNumProcess(Node root){
        if (root == null){
            return 0;
        }
        int RLHeight = 0;
        Node cur = root.right;
        while (cur != null){
            RLHeight++;
            cur = cur.left;
        }
        int LLHeight = 0;
        cur = root;
        while (cur.left != null){
            LLHeight++;
            cur = cur.left;
        }

        if (LLHeight == RLHeight){
            return ((1 << (LLHeight)) + nodeNumProcess(root.right));
        }else {
            return ((1<<(RLHeight)) +  nodeNumProcess(root.left));
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(getNodeNum(head));

    }



}
