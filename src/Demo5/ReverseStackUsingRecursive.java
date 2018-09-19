package Demo5;

import java.util.Stack;

/**
 * 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能
 使用递归函数。如何实现？
 为什么使用递归可以实现不使用额外的数据结构就可以实现逆序一个栈，因为在递归的过程中
 其实系统自动给你分配一个栈然后记录每一步的所有的状态
 * @author WilsonSong
 * @date 2018/9/19/019
 */
public class ReverseStackUsingRecursive {

    public static void Reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return ;
        }

        int i = getAndRemoveElement(stack);
        Reverse(stack);
        stack.push(i);
    }

    public static int getAndRemoveElement(Stack<Integer> stack){
        int result = stack.pop();   //先把栈顶的取出来，这是准备放到栈底的 不断的有result接住弹出的元素
        if (stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveElement(stack);
            stack.push(result);
            return last;   //最后剩下的是栈顶的元素
        }
    }



}
