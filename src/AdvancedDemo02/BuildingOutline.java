package AdvancedDemo02;

import java.util.*;

/**
 * 水平面上有 N 座大楼，每座大楼都是矩阵的形状，
 * 可以用一个三元组表示 (start, end, height)，
 * 分别代表其在x轴上的起点，终点和高度。大楼之间从远处看可能会重叠，
 * 求出 N 座大楼的外轮廓线。
 * 外轮廓线的表示方法为若干三元组，每个三元组包含三个数字 (start, end, height)，
 * 代表这段轮廓的起始位置，终止位置和高度。
 * [
 [1, 3, 3],
 [2, 4, 4],
 [5, 6, 1]
 ]
 外轮廓线：
 [
 [1, 2, 3],
 [2, 4, 4],
 [5, 6, 1]
 ]
 * @author WilsonSong
 * @date 2018/10/25/025
 */
public class BuildingOutline {

    private class Node{
        public int position;
        public int height;
        public boolean isUp;

        public Node(int position, int height, boolean isUp){
            this.position = position;
            this.height = height;
            this.isUp = isUp;
        }
    }

    private class NodeComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.position != o2.position){
                return o1.position - o2.position;
            }
            if (o1.isUp != o2.isUp){          //同一个位置有两个高度的时候，先存小的那一个
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }

    public List<List<Integer>> buildingOutline(int[][] buildings){
        Node[] nodes = new Node[buildings.length * 2];

        for (int i = 0; i < nodes.length; i++){
            if (i % 2 == 0){
                nodes[i] = new Node(buildings[i/2][0],buildings[i/2][2],true);
            }else {
                nodes[i] = new Node(buildings[i/2][1],buildings[i/2][2],false);
            }
        }

        Arrays.sort(nodes,new NodeComparator());
        TreeMap<Integer, Integer> htMap = new TreeMap<>();
        TreeMap<Integer, Integer> posMap = new TreeMap<>();
        for (int i = 0; i < nodes.length; i++){
            if (nodes[i].isUp){        //往上的话其实是次数加
                if (!htMap.containsKey(nodes[i].height)){
                    htMap.put(nodes[i].height, 1);
                }else {
                    htMap.put(nodes[i].height, htMap.get(nodes[i].height) +1);
                }
            }else {                 //往下的话是次数减
                if (htMap.containsKey(nodes[i].height)){
                    if (htMap.get(nodes[i].height) ==1){
                        htMap.remove(nodes[i].height);
                    }else {
                        htMap.put(nodes[i].height, htMap.get(nodes[i].height) - 1);
                    }
                }
            }
            if (htMap.isEmpty()){
                posMap.put(nodes[i].position, 0);
            }else {
                posMap.put(nodes[i].position, htMap.lastKey());
            }
        }

        List<List<Integer>> lists = new ArrayList<>();
        int start = 0;
        int height = 0;
        for (Map.Entry<Integer, Integer> entry : htMap.entrySet()){
            int CurPosition = entry.getKey();
            int CurHeight = entry.getValue();
            if (height != CurHeight){

                if (height != 0){
                    List<Integer> newRecord = new ArrayList<>();
                    newRecord.add(start);
                    newRecord.add(CurPosition);
                    newRecord.add(height);
                    lists.add(newRecord);
                }
                start = CurPosition;
                height = CurHeight;
            }
        }
        return lists;
    }


}
