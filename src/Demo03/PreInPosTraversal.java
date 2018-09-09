package Demo03;

import java.util.Stack;

/**
 * 二叉树的前序中序和后序遍历，递归和非递归
 * @author WilsonSong
 * @date 2018/9/9/009
 */
public class PreInPosTraversal {

    private static class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    //前序递归
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //中序递归
    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value);
        inOrderRecur(head.right);
    }

    //后序递归
    public static void posOrderRecur(Node head){
        if (head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value);
    }

    //前序的非递归
    public static void preOrderUnrecur(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Node  node = stack.pop();
            System.out.println(node.value);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
    }

    //中序非递归 左根右，只要左不为空就压栈，否则弹出（根）然后往右走
    public static void inOrderUnrecur(Node root){
        if (root == null){
            return;
        }

        Stack<Node>  stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                System.out.println(root.value);
                root = root.right;
            }
        }
    }

    //后序遍历 左右根    其实就是多准备一个栈根又左压栈，然后弹出不就是左右根了嘛
    public static void posOrderUnrecur(Node root){
        if (root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Stack<Node> helpStack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            helpStack.push(node);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        while (!helpStack.isEmpty()){
            System.out.println(helpStack.pop().value);
        }
    }

}
