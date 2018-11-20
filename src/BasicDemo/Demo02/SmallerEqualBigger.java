package BasicDemo.Demo02;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 【题目】 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个
 整 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot
 的节点，中间部分都是值等于pivot的节点，右部分都是值大于 pivot的节点。
 除这个要求外，对调整后的节点顺序没有更多的要求。 例如：链表9->0->4->5-
 >1，pivot=3。 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总
 之，满 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部
 分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做 要求。
 进阶： 在原问题的要求之上再增加如下两个要求。
 在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左 到右的
 顺序与原链表中节点的先后次序一致。 例如：链表9->0->4->5->1，pivot=3。
 调整后的链表是0->1->9->4->5。 在满足原问题要求的同时，左部分节点从左到
 右为0、1。在原链表中也 是先出现0，后出现1；中间部分在本例中为空，不再
 讨论；右部分节点 从左到右为9、4、5。在原链表中也是先出现9，然后出现4，
 最后出现5。
 如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
 * @author WilsonSong
 * @date 2018/9/7/007
 */
public class SmallerEqualBigger {

    private static class Node{
        public Node next;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    //使用额外的空间O(N)，因为思路其实就是将链表中的内容存储到数组中，然后数组使用荷兰国旗问题来实现上面的求解
    public static Node listPartition1(Node head, int pivot){
        if (head == null){
            return null;
        }
        Node cur = head;
        int i = 0;
        while (cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodes = new Node[i];
        cur = head;
        for (i = 0; i< nodes.length; i++){
            nodes[i] = cur;
            cur = cur.next;
        }
        ArrayPartition(nodes,pivot);
        for (i = 1; i != nodes.length; i++) {
            nodes[i - 1].next = nodes[i];
        }
        nodes[i - 1].next = null;
        return nodes[0];
    }

    private static void ArrayPartition(Node[] nodes, int pivot){
        int first = -1;
        int last = nodes.length;
        int index = 0;
        while (index != last){
            if (nodes[index].value > pivot){
                swap(nodes, index, last-1);
                last--;
            }else if (nodes[index].value < pivot){
                first ++;
                swap(nodes, first, index);
                index ++;
            }else {
                index ++;
            }
        }
    }

    private static void swap(Node[] nodes, int i, int j){
        Node cur = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = cur;
    }

    public static Node listPartition2(Node head, int pivot){
        Node SH = null;  //small head
        Node ST = null;  // small tail
        Node EH = null;
        Node ET = null;
        Node BH = null;
        Node BT = null;
        Node next = null;

        while (head != null){
            next = head.next;       //这两部必须做，要不然指向head的时候就指向了整个链表
            head.next = null;
            if (head.value < pivot){
                if (SH == null){
                   SH = head;
                   ST = head;
                }else {
                    ST.next = head;
                    ST = head;
                }
            }else if (head.value == pivot){
                if (EH == null){
                    EH = head;
                    ET = head;
                }else {
                    ET.next = head;
                    ET = head;
                }
            }else {
                if (BH == null){
                    BH = head;
                    BT = head;
                }else {
                    BT.next = head;
                    BT = head;
                }
            }
            head = next;
        }

        if (SH != null && EH != null && BH != null){
            ST.next = EH;
            ET.next = BH;
            return SH;

        }else if (SH != null && EH != null){
            ST.next = EH;
            return SH;
        }else if (SH != null && BH != null){
            ST.next = BH;
            return SH;
        }else if (EH != null && BH != null){
            ET.next = BH;
            return EH;
        }else if (EH != null){
            return EH;
        }else if ( BH != null){
            return BH;
        }else {
            return SH;
        }
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
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }

}
