package AdvancedDemo02;

/**
 * 给定一棵二叉树的头节点head，请返回最大搜索二叉子树的大小
 * @author WilsonSong
 * @date 2018/10/28/028
 */
public class BiggestSubBSTInTree {

    private class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    private class ReturnType{
        public int size;
        public Node node;
        public int max;
        public int min;

        public ReturnType(int size, Node node, int max, int min){
            this.size = size;
            this.node = node;
            this.max = max;
            this.min = min;
        }
    }


    public int getBiggestSubBSTInTree(Node head){
        if (head == null){
            return 0;
        }
        return process(head).size;
    }

    private ReturnType process(Node head){

        if (head == null){
            return new ReturnType(0, null, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Node left = head.left; //下面的函数不能直接把head.left直接放进去，这样的话在右子树递归的话可能会出错，具体的没试过，就是说这样写肯定不会错
        ReturnType LeftSubTreeInf = process(left);
        Node right = head.right;
        ReturnType RightSubTreeInf = process(right);
        int MaxSize = 0;

        int Lsize = LeftSubTreeInf.size;
        int Rsize = RightSubTreeInf.size;
        int Isize = 0;

        if (LeftSubTreeInf.node == head.left && RightSubTreeInf.node == head.right
                && LeftSubTreeInf.max < head.value && RightSubTreeInf.min > head.value){
            Isize = Lsize + Rsize + 1;
        }

        MaxSize = Math.max(Math.max(Lsize,Rsize),Isize);

        Node CurNode = Lsize > Rsize ? head.left : head.right;
        if (MaxSize == Isize){
            CurNode = head;
        }

        return new ReturnType(MaxSize, CurNode, Math.max(head.value,Math.max(LeftSubTreeInf.max,RightSubTreeInf.max)),
                Math.max(Math.max(LeftSubTreeInf.min, RightSubTreeInf.min),head.value));
    }

}
