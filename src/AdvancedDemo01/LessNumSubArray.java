package AdvancedDemo01;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组的数量
 * 要求如果数组长度是n则时间复杂度是O(n)的
 * 很明显暴力解决时间复杂度O（N2）
 * @author WilsonSong
 * @date 2018/10/23/023
 */
public class LessNumSubArray {

    /**
     * peek 相当于从栈里拷贝一份出来
     * poll是从栈中取出来，然后
     * @param data
     * @param num
     * @return
     */
    public int getNum(int[] data, int num){
        if (data == null || data.length == 0){
            return 0;
        }

        LinkedList<Integer> listMax = new LinkedList<>();
        LinkedList<Integer> listMin = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;

        while (i < data.length){
            while (j < data.length){
                while (!listMin.isEmpty() && data[listMin.peekLast()] >= data[j]){
                    listMin.pollLast();
                }
                listMin.addLast(j);
                while (!listMax.isEmpty() && data[listMax.peekLast()] <= data[j]){
                    listMax.pollLast();
                }
                listMax.addLast(j);
                if (data[listMax.getFirst()] - data[listMin.getFirst()] > num){
                    break;
                }
                j++;
            }

            //如果最大值和最小值正好是窗口的边界的话就弹出，因为接下来窗口要移动了
            if (listMin.peekFirst() == i){
                listMin.pollFirst();
            }
            if (listMax.peekFirst() == j){
                listMax.pollFirst();
            }

            res += j - i;
            i++;
        }
        return res;
    }
}
