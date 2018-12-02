package BasicExample.BasicExamples03;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * @author WilsonSong
 * @date 2018/12/1/001
 */
public class Code_12_SmallerEqualBigger {

    public static class Node{
        private Node next;
        private int value;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    public static Node remoteListToSmallerEqualBigger(Node head,int pivot){
        if (head == null){
            return null;
        }
        Node pivotNode = new Node(pivot);
        Node dumyHead = new Node(-1);
        dumyHead.next = pivotNode;
        pivotNode.next = head;
        Node pre = pivotNode;
        Node pivotPre = dumyHead;
        Node pivotNext = head;
        Node cur = head;

        while (cur != null){
            if (cur.value < pivot){
                Node node = cur;
                cur = cur.next;
                pre.next = node.next;
                pivotPre.next = node;
                pivotNext = pivotNode.next;
                node.next = pivotNode;
                pivotPre = node;

            }else if (cur.value ==pivot){
                if (pivotNode.next == cur){
                    cur = cur.next;
                    pre  = pre.next;
                }else {
                    Node node = cur;
                    cur = cur.next;
                    pre.next = node.next;
                    pivotNode.next = node;
                    node.next = pivotNext;
                    pivotNext = node;
                }


            }else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        if (pivotPre != dumyHead){
            pivotPre.next = pivotNext;
        }
        head = dumyHead.next;
        if (head == pivotNode){
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args){
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(6);
        head = remoteListToSmallerEqualBigger(head,3);
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
