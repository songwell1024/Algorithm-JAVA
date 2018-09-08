package Demo02;


/**
 两个单链表相交的一系列问题
 【题目】 在本题中，单链表可能有环，也可能无环。给定两个
 单链表的头节点 head1和head2，这两个链表可能相交，也可能
 不相交。请实现一个函数， 如果两个链表相交，请返回相交的
 第一个节点；如果不相交，返回null 即可。 要求：如果链表1
 的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外
 空间复杂度请达到O(1)。
 * @author WilsonSong
 * @date 2018/9/8/008
 */
public class FindFirstIntersectNode {

    public static class Node{
        public Node next;
        public int  value;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node FindListFirstIntersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if (loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }else if (loop1 != null && loop2 != null){
            return bothLoop(head1, head2, loop1, loop2);
        }else {
            return null;   //一个有环一个没环的话肯定是不想交的
        }

    }

    private static Node getLoopNode(Node head){
        Node fast = head;
        Node slow = head;
        while (slow != null){
            if (fast== null){
                return null;
            }
            if (fast != slow){
                slow = slow.next;
                fast = fast.next == null ? null : fast.next.next;
            }
        }
        fast = head;
        while (fast != null){
            if (fast == slow){
                return fast;
            }
        }
        return null;
    }

    //两个链表都没有环
    private static Node noLoop(Node head1, Node head2){
        Node cur1 = head1;
        Node cur2 = head2;
        Node ret;
        int n = 0;
        while (cur1.next != null){
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null){
            n--;      //此时就求出来了两个链表的长度差
            cur2 = cur2.next;
        }
        //此时cur1和cur2都走到了最后链表的最后一个点
        if (cur1 != cur2){
            return null;
        }
        ret = cur1;
        cur1 = head1;
        cur2 = head2;
        int k = n;
        if (k > 0){
            while (n > 0){
                cur1 = cur1.next;
            }
            while (cur1 != null){
                if (cur1 != cur2){
                    cur1 = cur2.next;
                    cur2 = cur2.next;
                }else {
                    return cur1;
                }
            }
        }else if (k < 0){
            while ( n < 0){
                 cur2 = cur2.next;
            }
            while (cur2 != null){
                if (cur1 != cur2){
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }else {
                    return cur2;
                }
            }
        }else {
            return ret;
        }
        return null;
    }

    //两个都有环
    private static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2){
        Node cur1 = head1;
        Node cur2 = head2;

        if (loop1 == loop2){

        }



    }


}
