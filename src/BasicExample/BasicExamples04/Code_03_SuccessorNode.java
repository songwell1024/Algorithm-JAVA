package BasicExample.BasicExamples04;

/**
 * 在二叉树中找到一个节点的后继节点
 * @author WilsonSong
 * @date 2018/12/5/005
 */
public class Code_03_SuccessorNode {

    public static class Node{
        public Node right;
        public Node left;
        public Node parent;
        public int value;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    //后继节点的node,递归方式求解
    public static Node getSuccessorNode(Node node){
        if (node == null){
            return null;
        }

        if (node.right != null){   //一个节点的右孩子不为空的时候他的后继节点一定是右孩子的最左节点，想想中序遍历的方式就能明白
            return getLeftNode(node);
        }else {      //当前节点没有右子树的时候就找当前节点是作为哪一个节点的左子树的最后一个节点  具体就是找当前节点的父节点是父节点
                     // 的父节点的左孩子时停止或者是当前节点是某一个节点的左点时停止
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }


    //某节点的最左节点
    public static Node getLeftNode(Node node){
        node = node.right;
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }

}
