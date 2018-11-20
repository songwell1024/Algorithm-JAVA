package BasicDemo.Demo03;

import java.util.Stack;

/**
 * 判断是二分搜索树
 * 中序遍历是按顺序排列的，按照这个性质可以用来判断二分搜索树
 * @author WilsonSong
 * @date 2018/9/10/010
 */
public class IsBinarySearchTree {
    private static class Node {
        public Node left;
        public Node right;
        public int  value;

        public Node(int value){
            this.value = value;
        }
    }

    public static boolean isBST(Node head){
        if (head == null){
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> HelpStack = new Stack<>();
        stack.add(head);
        while (head != null || !stack.isEmpty()){
            if (head.left != null){
                stack.push(head.left);
                head = head.left;
            }else {
                HelpStack.push(stack.pop());
                head = head.right;
            }
        }

        while (!HelpStack.isEmpty()){
            if (HelpStack.pop().value <= HelpStack.peek().value){
                return false;
            }
        }
        return true;
    }


}
