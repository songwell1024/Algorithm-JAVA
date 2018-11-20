package AdvanceDemo.AdvancedDemo02;

/**
 * 二叉树的Morris遍历，时间复杂度O(n),额外空间复杂度O(1)
 * 为什么是O(n)的复杂度呢，因其实使用morris遍历其实就是多遍历了某几个节点有限遍（2遍），撑破天就是O(2n)的其实也就是O(n)的
 * @author WilsonSong
 * @date 2018/10/25/025
 */
public class MorrisTraversal {
    private class Node{
        public Node right;
        public Node left;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    //使用morris遍历实现中序遍历
    public void morrisIn(Node head){
        if (head == null){
            return;
        }

        Node Cur = head;
        Node MostRight = null;

        while (Cur != null){
            MostRight = Cur.left;
            if (MostRight != null){
                while (MostRight.right!= null && MostRight.right != Cur){
                    MostRight = MostRight.right;
                }
                if (MostRight.right == null){
                    MostRight.right = Cur;
                    Cur = Cur.left;
                    continue;
                }else {
                    MostRight.right = null;
                }
            }
            System.out.println(Cur.value);
            Cur = Cur.right;
        }
    }


    //前序遍历
    public void morrisPre(Node head){
        if (head == null){
            return;
        }

        Node Cur = head;
        Node MostRight = null;

        while (Cur != null){
            MostRight = Cur.left;
            if (MostRight != null){
                while (MostRight.right != null && MostRight.right != Cur){
                    MostRight = MostRight.right;
                }
                if (MostRight.right == null){
                    MostRight.right = Cur;
                    System.out.println(Cur.value);
                    Cur = Cur.left;
                    continue;
                }else {
                    MostRight.right = null;
                }
            }else {
                System.out.println(Cur.value);
            }
            Cur = Cur.right;
        }
    }

    //后序遍历，比较复杂一点，后序遍历的话只考虑遍历过程中出现两次的节点，每当第二次来到这个节点的时候就逆序打印他左子树的右边界
    public void morrisPos(Node head){
        if (head == null){
            return;
        }

        Node Cur = head;
        Node MostRight = null;

        while (Cur != null){
            MostRight = Cur.left;
            if (MostRight!= null){
                if (MostRight.right != null && MostRight.right != Cur){
                    MostRight = MostRight.right;
                }
                if (MostRight.right == null){
                    MostRight.right = Cur;
                    Cur = Cur.left;
                    continue;
                }else {
                    MostRight.right = null;
                    printEdge(Cur.left);
                }
            }
            Cur = Cur.right;
        }
        printEdge(head);
    }

    //逆序打印左子树的右边界
    private void printEdge(Node node){
        Node tail = reverse(node);
        Node Cur = tail;
        while (Cur != null){
            System.out.println(Cur.value);
            Cur = Cur.right;
        }
        node = reverse(tail);
    }

    //逆序右边界，就和链表的反转是一样的
    private Node reverse(Node node){
        Node pre = null;
        Node next = null;
        while (node != null){
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
