package BasicExample.BasicExamples04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是否是完全二叉树
 * * 思路就是层序遍历所有的节点，一棵树没有左节点但是有右节点显然不是完全二叉树
 * 然后就是当一棵树只有左节点或者是左右节点都没有的时候，以后遍历到的节点都必须是叶子节点
 * 用一个变量标识一下什么时候以后的节点应该是叶子节点
 * @author WilsonSong
 * @date 2018/12/9/009
 */
public class Code_07_02IsCompleteTree {
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

    public static boolean isCBT(Node root){
        if (root == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()){
            root = queue.poll();
            if ((root.left != null || root.right != null) && !leaf){
              return false;
            }
            if (root.left != null){
                queue.offer(root.left);
            }
            if (root.right != null){
                queue.offer(root.right);
            }
            if (root.left != null && root.right == null){
                leaf = true;
            }
            if (root.left == null && root.right != null){
                return false;
            }
        }
        return true;
    }
}
