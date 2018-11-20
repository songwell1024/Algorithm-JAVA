package BasicDemo.Demo03;

/**
 * 找后继节点
 * @author WilsonSong
 * @date 2018/9/9/009
 */
public class SuccessorNode {

    private static class Node{
        public Node left;
        public Node right;
        public Node parent;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    //找后继节点
    public static Node getSuccessNode(Node node){
        if (node == null){
            return null;
        }
        if (node.right != null){        //一个节点的右孩子不为空的时候他的后继节点一定是右孩子的最左节点，想想中序遍历的方式就能明白
            return getLeftNode(node);
        }else {     //当前节点没有右子树的时候就找当前节点是作为哪一个节点的左子树的最后一个节点  具体就是找当前节点的父节点是父节点的父节点的左孩子时停止
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftNode(Node node){
        if (node == null || node.right == null){
            return null;
        }
        node = node.right;
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

}
