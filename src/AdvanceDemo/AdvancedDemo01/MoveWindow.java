package AdvanceDemo.AdvancedDemo01;

import java.util.LinkedList;

/**
 * 窗口及窗口内的最大值个最小值的更新结构（使用单调双向队列），时间复杂度O(N)
 * 生成窗口最大值数组，有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口
 * 向右边滑一个位置，求窗口内的最大值的更新结构
 * @author WilsonSong
 * @date 2018/10/22/022
 */
public class MoveWindow {

    public int[] getMaxWindow(int[] data, int w){
        if (data == null || w < 1 || data.length < w){
            return null;
        }
        LinkedList<Integer> qMax = new LinkedList<>();

        int[] res = new int[data.length - w +1];
        int index = 0;
        for (int i = 0; i <data.length; i++){
            while (!qMax.isEmpty() && data[qMax.peekLast()] <= data[i] ){
                qMax.peekLast();
            }
            qMax.addLast(i);

            if (qMax.peekFirst() == i - w){
                qMax.pollFirst();
            }
            if (i > w -1){
                res[index++] = data[qMax.peekFirst()];
            }
        }
        return res;
    }
}
