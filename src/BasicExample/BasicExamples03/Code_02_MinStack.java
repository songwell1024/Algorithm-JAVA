package BasicExample.BasicExamples03;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
 回栈中最小元素的操作。
 * @author WilsonSong
 * @date 2018/11/24/024
 */
public class Code_02_MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public Code_02_MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int ele){
        stack.push(ele);
        if (minStack != null){
            if (ele < minStack.peek()){
                minStack.push(ele);
            }
        }else {
            minStack.push(ele);
        }
    }

    public int pop(){
        if (stack == null){
            throw new IllegalArgumentException("stack is empty");
        }
        int ret = stack.pop();
        if (ret == minStack.peek()){
            minStack.pop();
        }
        return ret;
    }

    public int peek(){
        if (stack == null){
            throw new IllegalArgumentException("stack is empty");
        }
        return stack.peek();
    }

    public int getMin(){
        if (minStack == null){
            throw new IllegalArgumentException("stack is empty");
        }
        return minStack.peek();
    }

}
