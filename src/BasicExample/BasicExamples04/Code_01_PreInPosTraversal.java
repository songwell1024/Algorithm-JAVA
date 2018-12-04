package BasicExample.BasicExamples04;

import java.util.Stack;

/**
 * 实现二叉树的先序、中序、后序遍历，包括递归方式和非递归
 方式
 * @author WilsonSong
 * @date 2018/12/4/004
 */
public class Code_01_PreInPosTraversal {

    private static class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    //递归方式实现前序遍历
    public static void preProcessTree(Node root){
        if (root == null){
            return;
        }

        System.out.println(root.value);
        preProcessTree(root.left);
        preProcessTree(root.right);
    }
    //递归方式实现中序遍历
    public static void inProcessTree(Node root){
        if (root == null){
            return;
        }
        inProcessTree(root.left);
        System.out.println(root.value);
        inProcessTree(root.right);
    }

    //递归方式实现后序遍历
    public static void posProcessTree(Node root){
        if (root == null){
            return;
        }

        posProcessTree(root.left);
        posProcessTree(root.right);
        System.out.println(root.value);
    }

    //非递归方式实现前序遍历
    public static void preTree(Node root){
        if (root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (stack.size() != 0){
            Node node = stack.pop();
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
            System.out.println(node.value);
        }
    }

    //非递归方式实现中序遍历
    public static void inTree(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
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

    //非递归方式实现后序遍历 其实就是多准备一个栈根又左压栈，然后弹出不就是左右根了嘛
    public static void posTree(Node root){
        if (root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Stack<Node> Hsatck = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            Hsatck.push(node);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
            System.out.println(node.value);
        }

        while (!Hsatck.isEmpty()){
            System.out.println(Hsatck.pop().value);
        }
    }


    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right  = new Node(7);
//        preProcessTree(root);
//        preTree(root);
//        inProcessTree(root);
        inTree(root);
    }



}
