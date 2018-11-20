package BasicDemo.Demo02;

/**
 打印两个有序链表的公共部分
 【题目】 给定两个有序链表的头指针head1和head2，打印两个
 链表的公共部分。
 * @author WilsonSong
 * @date 2018/9/7/007
 */
public class PrintCommonPart {

    private class Node{
        public Node next;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }
    public static void PrintListCommonPart(Node head1, Node head2){
        while (head1 != null && head2 !=  null){
            if (head1.value > head2.value){
                head2 = head2.next;
            }else if (head1.value < head2.value){
                head1 =  head1.next;
            }else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 =head2.next;
            }
        }
    }

}
