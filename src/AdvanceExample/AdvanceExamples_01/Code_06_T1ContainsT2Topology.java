package AdvanceExample.AdvanceExamples_01;

/**
 * 给定一棵二叉树的头节点head，请返回最大搜索二叉子树的大小
 *
 * 1、整体过程是二叉树的后序遍历
 2、遍历到当前结点记为cur，先遍历cur的左子树并收集4个信息，分别是左子树上最大搜索二叉子树的头节点、结点数、树上的最小值和树上的最大值。再遍历cur的右子树收集4个信息，分别是右子树上最大搜索二叉子树的头节点、结点数、最小值、最大值。
 3、根据步骤二收集的信息，判断是否满足以cur为头的结点整体是二叉搜索树。如果满足，就返回cur结点；如果不满足，就返回左子树和右子树各自的最大搜索二叉树中节点数较多的那个树的头节点。
 4、对于整个遍历过程，可以使用全局变量更新的方式实现返回节点cur的四个信息

 * @author WilsonSong
 * @date 2018/12/31/031
 */
public class Code_06_T1ContainsT2Topology {

    public class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }
    public static int getSizeOfBiggestSubTree(Node head){
        if (head == null){
            return 0;
        }

        int[] res = new int[3];
        process(head, res);
        return res[0];
    }

    public static Node process(Node head,int[] res){
        if (head == null){
            res[0] = 0;    //二叉搜索子树中的节点数
            res[1] = Integer.MIN_VALUE;  //二叉搜索子树中的右子树的最大值
            res[1] = Integer.MAX_VALUE;  //二叉搜索子树中左子树的最小值
            return null;
        }

        Node nodeLeft = process(head.left, res);
        int lNum = res[0];//总结点数
        int lMax = res[1];//最大值
        int lMin = res[2];//最小值
        Node nodeRight = process(head.right, res);
        int rNum = res[0];
        int rMax = res[1];
        int rMin = res[2];

        if (nodeLeft == head.left && nodeRight == head.right && head.value > lMax && head.value < rMin){
            res[0] = Math.max(lNum, rNum) + 1;
            return head;
        }
        res[0] = Math.max(lNum, rNum);
        return lNum > rNum ? nodeLeft : nodeRight;
    }


}
