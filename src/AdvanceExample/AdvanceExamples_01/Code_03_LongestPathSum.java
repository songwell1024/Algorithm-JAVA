package AdvanceExample.AdvanceExamples_01;

import java.util.HashMap;

/**
 * 给定一棵二叉树的头节点head，和一个整数sum，二叉树每个节点上都
 有数字，我们规定路径必须是从上往下的，求二叉树上累加和为sum的
 最长路径长度。
 路径可以是任意路径，并不一定非要是从根节点开始的，可以使从任何节点开始到任何节点结束，只要满足从上往下的要求即可

 思路就是创建路径和与层次的关系，然后每棵子树分别递归求取符合条件的路径，然后选取最大的

 生成哈希表map，map的作用是记录从head开始的一条路径上的累加和，其中key值表示某个累加和，value表示累加和出现的最早层数。
 例如，假设某个路径上的节点值为[1, 2, 3, -3, 5]，那么map中的记录为[1 : 1, 3 : 2, 6 : 3, 3 : 2, 8 : 5]，注意value表示累加和出现的最早层数，
 所以map中的第四个记录和第二个记录相同，所以第四条记录其实不必要插入，map的记录应该为[1 : 1, 3 : 2, 6 : 3, 8 : 5]。

 在map中添加（0， 0）记录，表示累加和 0 不用任何节点就可以得到。先序遍历二叉树，
 假设遍历到的当前位置是cur，层数为level，此时的累加和应为cur的父节点的累加和presum加上cur节点的值，
 即cursum = presum + cur.val。如果（presum + cur.val, level）这个记录已经存在于map中，则不需要再次插入。
 接下来，我们要做的工作是，判断是否有以cur结尾的路径的累加和 等于题目所给的指定值sum。
 只需要在map中寻找是否有cursum - sum这个记录即可，如果存在这个记录的话 level - map[cursum - sum]就是满足条件的一个路径长度，
 使用全局变量更新路径的最大值。

 需要注意的是，在遍历完二叉树的子树要返回到cur的父节点是，需要将map中该节点的记录删去（如果之前插入的话），否则可能出现路径不是自顶向下的情况。
 * @author WilsonSong
 * @date 2018/12/30/030
 */
public class Code_03_LongestPathSum {

    public class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }



    public static int getLongestPathSum(Node root, int sum){
        if (root == null){
            return 0;
        }

        HashMap<Integer, Integer> curMap = new HashMap<>();
        curMap.put(0,0);

        return process(root,sum, 0,1, 0, curMap);
    }

    public static int process(Node root, int sum, int preSum, int level,int maxLen, HashMap<Integer, Integer> curMap){
        if (root == null){
            return maxLen;
        }

        int curSum = preSum + root.value;
        if (!curMap.containsKey(curSum)){
            curMap.put(curSum, level);
        }
        if (curMap.containsKey(curSum - sum)){
            maxLen = Math.max(level - curMap.get(curSum -sum), maxLen);
        }

        process(root.left, sum, curSum, level + 1, maxLen, curMap);
        process(root.right, sum, curSum, level + 1, maxLen, curMap);

        if (curMap.get(curSum) == level){
            curMap.remove(curSum);
        }
        return maxLen;

    }
}
