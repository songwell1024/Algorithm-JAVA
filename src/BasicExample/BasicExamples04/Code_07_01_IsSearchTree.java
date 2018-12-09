package BasicExample.BasicExamples04;

import sun.plugin2.message.ShowStatusMessage;

import java.util.Stack;

/**
 * 判断一棵树是否是搜索二叉树
 * 一个节点的左节点小于当前节点，一个节点的右节点大于当前节点
 * 只要当前节点不为空就压栈往左走，否则弹出然后往右走
 * @author WilsonSong
 * @date 2018/12/9/009
 */
public class Code_07_01_IsSearchTree {

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

    public static boolean isSearchTree(Node head){
        if (head == null){
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> helpStack = new Stack<>();
        while (!stack.isEmpty() || head != null){
          if (head!= null){
              stack.push(head);
              head = head.left;
          }else {
              head = stack.pop();
              helpStack.push(head);
              head = head.right;
          }
        }

        while (!helpStack.isEmpty()){
            if (helpStack.pop().value < helpStack.peek().value){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){

        Node head = new Node(10);
        head.left = new Node(5);
        head.right = new Node(15);
        head.left.left = new Node(4);
        head.left.right = new Node(7);

        System.out.println(isSearchTree(head));

    }

}
