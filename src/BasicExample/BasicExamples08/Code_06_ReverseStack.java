package BasicExample.BasicExamples08;

import java.util.Stack;

/**
 * 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能
 使用递归函数。如何实现？
 其实递归的过程就是使用系统栈来实现的，所以其实是借助了系统栈
 * @author WilsonSong
 * @date 2018/12/22/022
 */
public class Code_06_ReverseStack {

    public static void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getLastPopElement(stack);
        reverseStack(stack);
        stack.push(i);

    }

    public static int getLastPopElement(Stack<Integer> stack){
        int res = stack.pop();
        if (stack.isEmpty()){
            return res;
        }else {
            int last = getLastPopElement(stack);
            stack.push(res);
            return last;
        }

    }


}
