package AdvanceDemo.AdvancedDemo01;

import java.util.Stack;

/**
 * 一个数组可以构成环形山，相邻的山可以互相看见，然后两座山之间的数若是比两座山的数小也是可以互相看见的，
 * 该数组中有重复元素
 * 使用单调栈来求解
 * @author WilsonSong
 * @date 2018/10/24/024
 */
public class MountainsAndFlame {

    public class Pair{
        public int value;
        public int times;
        public Pair(int value){
            this.value = value;
            this.times = 1;
        }
    }

    public long communictions(int[] arr){
        if (arr.length <= 1 || arr == null){
            return 0;
        }

        int size = arr.length;
        int maxIndex = 0;   //初始化最大值的位置
        for (int i = 0; i < size; i++){
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        int val = arr[maxIndex];
        int index = nextIndex(size, maxIndex);
        long res = 0L;
        Stack<Pair> stack = new Stack<>();
        while (index != maxIndex){
            val = arr[index];
            while (!stack.isEmpty() && stack.peek().value < val){
                int times = stack.pop().times;
                res += getInternalSum(times) + 2*times;
            }
            if (!stack.isEmpty() && stack.peek().value == val){
                stack.peek().times ++;
            }else {
                stack.push(new Pair(val));
            }
            index = nextIndex(size, index);
        }

        //这个是当所有的数都遍历一遍之后栈中海油没有弹出的元素的话进行的处理
        while (!stack.isEmpty()){
            int times = stack.pop().times;
            res += getInternalSum(times);
            if (!stack.isEmpty()){
                res += times;
                if (stack.size() > 1){
                    res += times;
                }else {
                    res += stack.peek().times > 1 ? times : 0;
                }
            }
        }
        return res;
    }


    public int nextIndex(int size, int i){
        return i < (size - 1) ? (i + 1) : 0;        //就是因为是环形的嘛，就是当这个点到最后一个点的时候，回到第一个位置
    }

    public long getInternalSum(int n){
        return n == 1L ? 0L : (long) n * (long) (n-1) / 2L;
    }
}
