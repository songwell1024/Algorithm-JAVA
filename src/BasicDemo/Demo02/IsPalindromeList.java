package BasicDemo.Demo02;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 【题目】 给定一个链表的头节点head，请判断该链表是否为回
 文结构。 例如： 1->2->1，返回true。 1->2->2->1，返回true。
 15->6->15，返回true。 1->2->3，返回false。
 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂
 度达到O(1)。
 * @author WilsonSong
 * @date 2018/9/7/007
 */
public class IsPalindromeList {

    private static class Node{
        public Node next;
        public int value;

        public Node(Node next, int value){
            this.value = value;
            this.next = next;
        }

        public Node(int value){
            this(null, value);
        }
    }

    //使用了额外O(n)的空间复杂度
    public static boolean IsPalindromeListByStack(Node head) {
        Node cur = head;
        Stack<Integer> stack = new Stack<>();

        while (cur != null){
            stack.push(cur.value);
            cur = cur.next;
        }

        while (head != null){
            if (stack.pop() != head.value){
                return false;
            }else {
                head = head.next;
            }
        }
        return true;
    }

    //使用了快指针走两步，然后利用回文结构的对称性质进行判断的，使用了额外O(n/2)的空间复杂度
    public static boolean IsPalindromeListByStack1(Node head){
        Node FastHead = head;
        Stack<Integer> stack = new Stack<>();

        while (FastHead != null){
            if (FastHead.next != null){
                FastHead = FastHead.next.next;
            }else {
                FastHead = FastHead.next;
            }
            stack.push(head.value);
            head = head.next;
        }
        while (head != null){
            if (head.value != stack.pop()){
                return false;
            }else {
                head = head.next;
            }
        }
        return true;
    }

    //使用快指针走两步
    public static boolean IsPalindromeListByStack2(Node head){
        Node FastHead = head;
        Node cur = head;
        if (head == null || head.next == null){
            return true;
        }
        while (FastHead.next != null && FastHead.next.next != null){
            FastHead = FastHead.next.next;
            cur = cur.next;
        }

        Node ReverseNode = cur.next;
        Node helpNode = reverse(ReverseNode);
        Node node = helpNode;
        while (helpNode != null){
            if (head.value != helpNode.value){
                cur.next =reverse(node);
                return false;
            }else {
                head = head.next;
                helpNode = helpNode.next;
            }
        }
        cur.next = reverse(node);
        return true;
    }

    //链表反转
    private static Node reverse(Node head){
        Node next = null;
        Node pre = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(IsPalindromeListByStack(head) + " | ");
        System.out.print(IsPalindromeListByStack2(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
//        System.out.println(isPalindrome3(head) + " | ");
//        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindromeListByStack(head) + " | ");
        System.out.print(IsPalindromeListByStack2(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
//        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(IsPalindromeListByStack(head) + " | ");
        System.out.print(IsPalindromeListByStack2(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
//        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindromeListByStack(head) + " | ");
        System.out.print(IsPalindromeListByStack2(head) + " | ");
//        System.out.print(isPalindrome2(head) + " | ");
//        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindromeListByStack(head) + " | ");
        System.out.print(IsPalindromeListByStack2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");
    }



}
