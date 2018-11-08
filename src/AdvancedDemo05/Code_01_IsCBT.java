package AdvancedDemo05;

import java.util.LinkedList;

/**
 * 判断一棵二叉树是完全二叉树
 * 条件就是一个节点有右孩子没有左孩子的时候直接返回false
 * 然后判断当一个节点左右孩子不全时接下来遍历到的节点必须都是叶子节点
 * @author WilsonSong
 * @date 2018/11/8/008
 */
public class Code_01_IsCBT {

    private class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    public boolean isCBT(Node head){
        if (head == null){
            return true;
        }
        boolean leaf = false;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            Node l = queue.poll().left;
            Node r = queue.poll().right;
            if (leaf &&(l != null || r != null)  || (l == null&& r != null)) {
                return false;
            }
            if (l != null){
                queue.offer(l);
            }
            if (r != null){
                queue.offer(r);
            }
            if (l == null ||  r == null){
                leaf = true;
            }
        }
        return true;
    }
}
