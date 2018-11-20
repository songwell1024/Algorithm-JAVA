package AdvanceDemo.AdvancedDemo01;

import java.util.Stack;

/**
 * 使用单调栈求解最大子矩阵的大小
 * 给一个整型矩阵map,其中的值只有0和1，求其中全是1的矩形中最多有多少个1
 * 例如[1 0 1 1
 *      1 1 1 1
 *      1 1 1 0]   -----------> 6
 * @author WilsonSong
 * @date 2018/10/23/023
 */
public class MaximalRectangle {

    public int getRecSize(int[][] map){
        if (map == null || map.length == 0){
            return 0;
        }
        int MaxArea = 0;
        int[] height = new int[map[0].length];

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < height.length; j++){
                height[j] = map[i][j] == 0 ? 0 : (height[j] + 1);
            }
            MaxArea = Math.max(maxRecFromBottom(height), MaxArea);
        }
        return MaxArea;

    }

    public int maxRecFromBottom(int[] height){
        if (height == null || height.length ==0){
            return 0;
        }
        int MaxRes = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i< height.length; i++){
            while (!stack.isEmpty() && height[i] < stack.peek()){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curVal = (i - k -1 )* height[j];
                MaxRes = Math.max(MaxRes,curVal);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curVal = (height.length - k -1) * height[j];
            MaxRes = Math.max(curVal,MaxRes);
        }
        return MaxRes;
    }


}
