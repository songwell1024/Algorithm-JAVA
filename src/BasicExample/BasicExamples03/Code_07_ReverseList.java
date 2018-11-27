package BasicExample.BasicExamples03;

/**
 * 反转单向和双向链表
 * @author WilsonSong
 * @date 2018/11/27/027
 */
public class Code_07_ReverseList {

    public static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
            next = null;
        }
    }

    public static Node reverseList(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node cur = head.next;
        head.next = null;
        Node help = head;
        head = cur;
        cur = help;
        while (head != null){
            help = head.next;
            head.next = cur;
            cur = head;
            head = help;
        }
        head = cur;
        return head;
    }

    public static Node reverseList2(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    public static class DoubleNode{
        DoubleNode preNode;
        DoubleNode nextNode;
        int value;
        
        public DoubleNode(int value){
            this.value = value;
            this.nextNode = null;
            this.preNode = null;
        }
    }
    
    public static DoubleNode reverseDoubleList(DoubleNode head){
        if (head == null || head.nextNode == null){
            return head;
        }

        DoubleNode nextDoubleNode = null;
        DoubleNode preDoubleNode = null;
        
        while (head != null){
            nextDoubleNode = head.nextNode;
            head.nextNode = preDoubleNode;
            head.preNode =nextDoubleNode;
            preDoubleNode = head;
            head = nextDoubleNode;
        }
        return preDoubleNode;
    }



    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head = reverseList2(head);
        System.out.println(head.value);
    }


}
