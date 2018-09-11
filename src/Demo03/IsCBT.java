package Demo03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是否是完全二叉树
 * 思路就是遍历所有的节点，一棵树没有左节点但是有右节点显然不是完全二叉树
 * 然后就是当一棵树只有左节点或者是左右节点都没有的时候，以后遍历到的节点都必须是叶子节点
 * @author WilsonSong
 * @date 2018/9/11/011
 */
public class IsCBT {
    private static class Node{
        public Node left;
        public Node right;
        public int value;

        public Node (int value){
            this.value = value;
        }
    }


    public static boolean IsCBTree(Node head){
        if (head == null){
            return true;
        }

        boolean leaf  = false;
        Queue<Node> queue = new LinkedList<>();
        Node l = null;
        Node r = null;

        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;

            if (l != null && r != null && !leaf){
                queue.offer(l);
                queue.offer(r);
            }
            if (l == null && r != null){
                return false;
            }
            if (l != null && r == null){
                leaf = true;
            }
        }
        return true;

    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(IsCBTree(head));

    }



}
