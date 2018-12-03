package BasicExample.BasicExamples03;


/**
 * 两个单链表相交的一系列问题
 【题目】 在本题中，单链表可能有环，也可能无环。给定两个
 单链表的头节点 head1和head2，这两个链表可能相交，也可能
 不相交。请实现一个函数， 如果两个链表相交，请返回相交的
 第一个节点；如果不相交，返回null 即可。 要求：如果链表1
 的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外
 空间复杂度请达到O(1)。
 * @author WilsonSong
 * @date 2018/12/2/002
 */
public class Code_14_FindFirstIntersectNode {
    public static class Node{
        public Node next;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node findFirstIntersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if (loop1 == null && loop2 != null){
            return null;
        }
        if (loop1 != null && loop2 == null){
            return null;
        }
        if (loop1 == null && loop2 == null){
            return getIntersectNodeOfNoLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null){

        }

    }

    //获取环节点
    public static Node getLoopNode(Node head){
        Node c1 = head;
        Node c2 = head;

        while (c1 != null){
            if (c2 == null){
                return null;
            }
            if (c1 != c2){
                c1 = c1.next;
                c2 = c2.next == null ? null : c2.next.next;
            }else {
                break;
            }
        }
        c1 = head;
        while (c1 != null){
            if (c1 != c2){
                c1 = c1.next;
                c2 = c2.next;
            }else {
                return c1;
            }
        }

        return null;
    }

    //两个无环链表的相交问题
    public static Node getIntersectNodeOfNoLoop(Node head1, Node head2){
        Node c1 = head1;
        Node c2 = head2;

        int count1 = 0;
        int count2 = 0;

        while (c1 != null){
            c1 = c1.next;
            count1++;
        }
        while (c2 != null){
            c2 = c2.next;
            count2++;
        }
        c1 = head1;
        c2 = head2;
        if (count1 > count2){
            int count = count1 - count2;
            while (count >= 0){
                c1 = c1.next;
                count --;
            }
            while (c2 != null){
                if (c1 == c2){
                    return c1;
                }else {
                    c1 = c1.next;
                    c2 = c2.next;
                }
            }
        }
        if (count1 < count2){
            int count = count2 - count1;
            while (count >=0 ){
                c2 = c2.next;
                count--;
            }

            while (c1 != null){
                if (c1 == c2){
                    return c1;
                }else {
                    c1 = c1.next;
                    c2 = c2.next;
                }
            }
        }

        if (count1 == count2){
            while (c1 != null){
                if (c1 == c2){
                    return c1;
                }else {
                    c1 = c1.next;
                    c2 = c2.next;
                }
            }
        }
        return null;
    }

    //两个有环链表的交点
    public static Node getIntersectNodeWithNoLoop(Node head1, Node head2,Node loop1, Node loop2){
        Node c1 = head1;
        Node c2 = head2;
        if (loop1 == loop2){
            int n = 0;
            while (c1 != loop1){
                c1 = c1.next;
                n++;
            }
            while (c2 != loop2){
                c2 =c2.next;
                n--;
            }
            c1 = head1;
            c2 = head2;
            int k = n;
            if ( k > 0){
                while (n >= 0){
                    c1 = c1.next;
                    n--;
                }
                while (c1 != loop1.next){
                    if (c1 != c2){
                        c1 = c1.next;
                        c2 = c2.next;
                    }else {
                        return c1;
                    }
                }
            }else if (k <0){
                while (n <0){
                    c2 = c2.next;
                    n++;
                }
                while (c1 != loop1.next){
                    if (c1 != c2){
                        c1 = c1.next;
                        c2 = c2.next;
                    }else {
                        return c2;
                    }
                }
            }else {
               while (c1 != null){
                   if (c1 == c2){
                       return c1;
                   }else {
                       c1 = c1.next;
                       c2  = c2.next;
                   }
               }
            }

        }else {
           Node cur =loop1.next;
           while (cur != loop1){
               if (cur == loop2){
                   return loop1;
               }else {
                   cur = cur.next;
               }
           }
        }


    }


}
