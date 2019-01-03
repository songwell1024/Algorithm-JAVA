package AdvanceExample.AdvanceExamples_01;

import java.util.LinkedList;

/**
 * 给定一个字符串str，str表示一个公式，公式里可能有整数、加减乘除符号和
 左右括号，返回公式的计算结果。
 * @author WilsonSong
 * @date 2019/1/3/003
 */
public class Code_09_ExpressionCompute {

    public static int getStrValue(String str){
        return value(str.toCharArray(), 0)[0];

    }

    public static int[] value(char[] chars, int index){
        if (chars == null){
            return null;
        }
        LinkedList<String> que = new LinkedList<>();
        int pre = 0;
        int[] bar = null;

        while (index < chars.length && chars[index] != '('){
            if (chars[index] >= '0' && chars[index] <= '9'){
                pre =pre * 10 + chars[index] - '0';
            }else if(chars[index] != ')'){
                addNum(que, pre);
                pre = 0;
            }else {
                value(chars, index +1);
                pre = bar[0];
                index = bar[1] + 1;

            }
        }
        addNum(que, pre);
        return new int[]{getNum(que),index};

    }

    public static void addNum(LinkedList<String> que, int pre){
        while (!que.isEmpty()){
            String str = que.pollLast();
            if (str.equals('+') || str.equals('-')){
                que.addLast(str);
            }else {
                int next = Integer.valueOf(que.pollLast());
                pre = str.equals('*') ? pre * next : pre / next;
            }
        }
        que.addLast(String.valueOf(pre));
    }

    public static int getNum(LinkedList<String> que){
        int res = 0;
        boolean add  = false;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()){
            cur = que.pollFirst();
            if (cur.equals('+')){
                add = true;
            }else if (cur.equals("-")){
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res = add ? res + num : res - num;
            }
        }
        return res;
    }

}
