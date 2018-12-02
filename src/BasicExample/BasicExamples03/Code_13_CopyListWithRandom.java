package BasicExample.BasicExamples03;

import java.util.HashMap;

/**
 * 复制含有随机指针节点的链表
 * @author WilsonSong
 * @date 2018/12/2/002
 */
public class Code_13_CopyListWithRandom {

    public static class Node{
        public Node next;
        public Node random;
        public int value;

        public Node(int value){
            this.value = value;
            this.next  =null;
            this.random = null;
        }
    }

    //解法一就是O(n2),先遍历一遍复制next,然后在遍历一遍复制random
    //解法2就是使用O(N)的复杂度和额外的O(N)的空间复杂度

    public static Node copyListWithRandom1(Node head){
        if (head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur, new Node(cur.value));
        }

        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    //不使用额外的数据结构，空间复杂度O(1)，且在时间复杂度为 O(N)
    public static Node copyListWithRandom(Node head){
        if (head == null){
            return null;
        }
        Node helpNode1;
        Node helpNode2;
        Node cur = head;
        while (cur != null){
            helpNode1 = cur.next;
            helpNode2 = new Node(cur.value);
            cur.next = helpNode2;
            helpNode2.next = helpNode1;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null){
            cur.next.random = cur.random;
            cur = cur.next.next;
        }
        cur = head.next;
        while (cur!= null){
            if (cur.next != null){
                cur.next = cur.next.next;
                cur = cur.next;
            }else {
                break;
            }

        }
        return head.next;
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
            System.out.print(cur.random == null ? "- " : cur.random.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res2 = copyListWithRandom(head);
        printRandLinkedList(res2);

        System.out.println("=========================");

    }



}
