import java.util.LinkedList;  
import java.util.List;  
public class TreeNodemax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1,2,-2,-3,5};
		TreeNode[] node = new TreeNode[1];
		node = new createBinTree(a);
		List<TreeNode> nodelist;
		nodelist = node.createBinTree(a);
		System.out.println(nodelist);
	}

}

class TreeNode{
	public int val;
	public TreeNode left, right;
	private static List<TreeNode> nodeList = null;
	public TreeNode treenode=new TreeNode(-1000000); 
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
	public TreeNode maxnode(TreeNode root){
		if(root == null){
			return root;
		}
		else{
			if(root.val > treenode.val){
				treenode = root;
			}
			maxnode(root.left);
			maxnode(root.right);
		}
		return treenode;
	}
	
	public  List<TreeNode> createBinTree(int[] array) {  
        nodeList = new LinkedList<TreeNode>();  
        // 将一个数组的值依次转换为Node节点  
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {  
            nodeList.add(new TreeNode(array[nodeIndex]));  
        }  
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树  
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {  
            // 左孩子  
            nodeList.get(parentIndex).left = nodeList  
                    .get(parentIndex * 2 + 1);  
            // 右孩子  
            nodeList.get(parentIndex).right = nodeList  
                    .get(parentIndex * 2 + 2);  
        }  
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
        int lastParentIndex = array.length / 2 - 1;  
        // 左孩子  
        nodeList.get(lastParentIndex).left = nodeList  
                .get(lastParentIndex * 2 + 1);  
        // 右孩子,如果数组的长度为奇数才建立右孩子  
        if (array.length % 2 == 1) {  
            nodeList.get(lastParentIndex).right = nodeList  
                    .get(lastParentIndex * 2 + 2);  
        }
        return nodeList;
    }  
}
