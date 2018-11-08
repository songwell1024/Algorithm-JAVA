package AdvancedDemo04;

import java.util.LinkedList;

/**
 * 给定一个字符串str，str表示一个公式，公式里可能有整数、加减乘除符号和
 左右括号，返回公式的计算结果。
 【举例】
 str="48*((70-65)-43)+8*1"，返回-1816。
 str="3+1*4"，返回7。 str="3+(1*4)"，返回7。
 【说明】
 1．可以认为给定的字符串一定是正确的公式，即不需要对str做公式有效性检
 查。
 2．如果是负数，就需要用括号括起来，比如"4*(-3)"。但如果负数作为公式的
 开头或括号部分的开头，则可以没有括号，比如"-3*4"和"(-3*4)"都是合法的。
 3．不用考虑计算过程中会发生溢出的情况
 * @author WilsonSong
 * @date 2018/11/8/008
 */
public class Code_07_ExpressionCompute {

    public int getStrValue(String str){
        return value(str, 0)[0];
    }

    public int[] value(String str, int index){
        LinkedList<String> que = new LinkedList<>();
        int pre = 0;
        int[] bar = null;
        while (index < str.length() && str.charAt(index) != ')'){
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9'){     //字符串的当前值是数字
                pre = pre * 10 + str.charAt(index++) - '0';
            }else if (str.charAt(index) != '('){           //字符串的当前值是+ - * /
                addNum(que,pre);
                que.addLast(String.valueOf(str.charAt(index++)));
                pre = 0;
            }else {                //当前的字符是'(' 递归的调用函数
                bar = value(str, index + 1);
                pre = bar[0];
                index = bar[1] + 1;
            }
        }
        addNum(que, pre);      //   递归完成之后else执行完之后需要进行一次计算  就是把括号内的值pre与栈里的值进行一次计算
        return new int[]{getNum(que), index};     //执行到这里之后把括号之内的值进行计算完成返回
    }

    public void addNum(LinkedList<String> que, int pre){       //que中只存数字和+ -， 若是有* / 计算完后重新加入que中
        if (!que.isEmpty()){
            String cur = que.pollLast();
            if (cur.equals("+") || cur.equals("-")){
                que.addLast(cur);
            }else {
                int next = Integer.valueOf(que.pollLast());
                pre = cur.equals("*") ? pre * next : next / pre;
            }
        }
        que.addLast(String.valueOf(pre));
    }

    //计算只剩下+ -的que中的值
    public int getNum(LinkedList<String> que){
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()){
            cur = que.pollFirst();
            if (cur.equals("+")){
                add = true;
            }else if (cur.equals("-")){
                add = false;
            }else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }
}
