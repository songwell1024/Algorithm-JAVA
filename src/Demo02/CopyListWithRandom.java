package Demo02;

import java.util.HashMap;

/**
 * 复制含有随机指针节点的链表
 【题目】 一种特殊的链表节点类描述如下：
 public class Node { public int value; public Node next; public
 Node rand;
 public Node(int data) { this.value = data; }
 }
 Node类中的value是节点值，next指针和正常单链表中next指针的意义
 一 样，都指向下一个节点，rand指针是Node类中新增的指针，这个指
 针可 能指向链表中的任意一个节点，也可能指向null。 给定一个由
 Node节点类型组成的无环单链表的头节点head，请实现一个 函数完成
 这个链表中所有结构的复制，并返回复制的新链表的头节点。 进阶：
 不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N)
 内完成原问题要实现的函数。
 * @author WilsonSong
 * @date 2018/9/8/008
 */
public class CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    //使用额外的空间来实现链表的深度拷贝
    public static Node CopyByMap(Node head){
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }


    //使用O(1)的额为空间
    //1-->1'---2--2'---3---3',然后原节点的rand节点不动，然后把拷贝节点的下一个节点和rand节点设置完成后分离
    public static Node CopyList(Node head){
        Node cur = head;
        Node HelpNode1;
        Node HelpNode2;
        if (cur == null){
            return null;
        }
        while (cur != null){
           HelpNode1 = cur.next;
           cur.next = new Node(cur.value);
           cur.next.next = HelpNode1;         //这一步的作用是必须的，就是复制的节点要指向下一个节点
           cur = HelpNode1;
        }

        //拷贝random节点
        cur = head;
        while (cur != null){
            HelpNode1 = cur;
            HelpNode2 = cur.next;
            HelpNode2.rand = HelpNode1.rand;
            cur = cur.next.next;
        }

        //链表分离
        cur = head;
        Node res = head.next;
        while (cur != null){
            HelpNode1 = cur.next.next;
            HelpNode2 = cur.next;
            cur.next = HelpNode1;
            HelpNode2.next = (HelpNode1 == null ? null : HelpNode1.next);
            cur = HelpNode1;
        }
        return res;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = CopyByMap(head);
        printRandLinkedList(res1);
        res2 = CopyList(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = CopyByMap(head);
        printRandLinkedList(res1);
        res2 = CopyList(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }

}
