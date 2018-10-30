package AdvancedDemo02;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 一个公司的上下节关系是一棵多叉树，这个公司要举办晚会，你作为组织者已经摸清了大家的心理：一个员工的直
 接上级如果到场，这个员工肯定不会来。每个员工都有一个活跃度的值，决定谁来你会给这个员工发邀请函，怎么
 让舞会的气氛最活跃？返回最大的活跃值。
 举例：
 给定一个矩阵来表述这种关系
 matrix =
 {
 1,6
 1,5
 1,4
 }
 这个矩阵的含义是：
 matrix[0] = {1 , 6}，表示0这个员工的直接上级为1,0这个员工自己的活跃度为6
 matrix[1] = {1 , 5}，表示1这个员工的直接上级为1（他自己是这个公司的最大boss）,1这个员工自己的活跃度
 为5
 matrix[2] = {1 , 4}，表示2这个员工的直接上级为1,2这个员工自己的活跃度为4
 为了让晚会活跃度最大，应该让1不来，0和2来。最后返回活跃度为10
 * @author WilsonSong
 * @date 2018/10/29/029
 */
public class MaxHappy {

    public class Node{
        public List<Node> nexts;
        public int value;

        public Node(int value){
            this.value = value;
            this.nexts = new ArrayList<>();
        }
    }
    public class ReturnData{
        public int lai_huo;
        public int bu_lai_huo;
        public ReturnData(int lai_huo, int bu_lai_huo){
            this.lai_huo = lai_huo;
            this.bu_lai_huo = bu_lai_huo;
        }
    }

    public int getMaxHappy(Node head){
        ReturnData data = process(head);
        return Math.max(data.lai_huo, data.bu_lai_huo);
    }

    public ReturnData process(Node head){

        int lai_huo = 0;
        int bu_lai_huo = 0;
        for (int i = 0; i < head.nexts.size(); i++){
            lai_huo += process(head.nexts.get(i)).bu_lai_huo;
            bu_lai_huo = Math.max(process(head.nexts.get(i)).lai_huo, process(head.nexts.get(i)).bu_lai_huo);
        }

        return new ReturnData(lai_huo, bu_lai_huo);

    }
}
