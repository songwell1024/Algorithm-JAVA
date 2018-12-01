package BasicExample.BasicExamples03;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * @author WilsonSong
 * @date 2018/12/1/001
 */
public class Code_11_IsPalindromeList {

    public static class Node{
        public Node next;
        public int value;

        public Node(int value ){
            this.value = value;
            this.next = null;
        }
    }

    //O(n)的额外空间复杂度
    public static boolean isPalindromeList(Node head){
        if (head == null){
            return true;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            head = cur.next;
        }

        while (head!=null){
            if (head.value == stack.pop().value){
                head = head.next;
            }else {
                return false;
            }
        }
        return true;
    }


    //额外空间复杂度O(1)
    public static boolean isPalindromeList2(Node head){
        if (head == null){
            return true;
        }

        Node n1 = head;
        Node n2 = head;
        while (n2 != null && n2.next!= null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1;
        Node n3 = reverseList(n2);
        n1.next = null;
        while (head != null && n3 != null){
            if (head.value != n3.value){
                return false;
            }
            head = head.next;
            n3 = n3.next;

        }
        return true;
    }

    //反转列表
    public static Node reverseList(Node head){
        if (head == null){
            return null;
        }
        Node pre = null;
        Node next;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(555);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(1);

        System.out.println(isPalindromeList2(head));
    }
}
