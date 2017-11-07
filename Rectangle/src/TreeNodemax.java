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
        // ��һ�������ֵ����ת��ΪNode�ڵ�  
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {  
            nodeList.add(new TreeNode(array[nodeIndex]));  
        }  
        // ��ǰlastParentIndex-1�����ڵ㰴�ո��ڵ��뺢�ӽڵ�����ֹ�ϵ����������  
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {  
            // ����  
            nodeList.get(parentIndex).left = nodeList  
                    .get(parentIndex * 2 + 1);  
            // �Һ���  
            nodeList.get(parentIndex).right = nodeList  
                    .get(parentIndex * 2 + 2);  
        }  
        // ���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե����ó�������  
        int lastParentIndex = array.length / 2 - 1;  
        // ����  
        nodeList.get(lastParentIndex).left = nodeList  
                .get(lastParentIndex * 2 + 1);  
        // �Һ���,�������ĳ���Ϊ�����Ž����Һ���  
        if (array.length % 2 == 1) {  
            nodeList.get(lastParentIndex).right = nodeList  
                    .get(lastParentIndex * 2 + 2);  
        }
        return nodeList;
    }  
}
