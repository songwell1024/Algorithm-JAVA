package BasicExample.BasicExamples03;

/**
 * 打印两个有序链表的公共部分
 * @author WilsonSong
 * @date 2018/11/30/030
 */
public class Code_10_PrintCommonPart {

    private class Node{
        private Node next;
        private int value;
        public Node(int value){
            this.next = null;
            this.value = value;
        }
    }

    public void printCommonPart(Node head1, Node head2){
        while (head1 == null || head2 == null){
            return;
        }
        while (head1!= null && head2 != null){
            if (head1.value > head2.value){
                head2 = head2.next;
            }else if (head1.value < head2.value){
                head1 = head1.next;
            }else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

}
