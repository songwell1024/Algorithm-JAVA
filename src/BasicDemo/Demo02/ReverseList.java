package BasicDemo.Demo02;

/**
 * 反转单向和双向链表
 【题目】 分别实现反转单向链表和反转双向链表的函数。
 【要求】 如果链表长度为N，时间复杂度要求为O(N)，额外空间
 复杂度要求为O(1)
 * @author WilsonSong
 * @date 2018/9/6/006
 */
public class ReverseList {

    private class Node{
        Node next;
        int value;

        public Node(Node next, int value){
            this.next = next;
            this.value = value;
        }

        public Node(int value){
            this(null, value);
        }
    }

    //1-->2-->3-->null ----转换----- null<---1<---2<----3;
   public static Node reverseList(Node head){
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

   private class DoubleNode{
       public DoubleNode last;
       public DoubleNode next;
       public int value;

       public DoubleNode(int value){
           this.value = value;
       }

    }

    //  ---->---->
    // 1    2    3
    // <----<----
    //双向链表的一个节点分别有指向前驱和指向后继的两个节点
    //反转的话其实就是指向前驱和指向后继的两个指针交换
    public DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;
    }



}
