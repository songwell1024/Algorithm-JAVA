package Demo02;

import java.util.Stack;

/**
 *
 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
 回栈中最小元素的操作。
 【要求】
 1．pop、push、getMin操作的时间复杂度都是O(1)。
 2．设计的栈类型可以使用现成的栈结构。
 设计两个栈，一个存储正常元素，一个存储最小元素，最小元素栈实现的时候每次只要有比栈顶元素小的元素就往栈里面压
 若是压入栈的是2,1,0,3,1 则min中元素就是,0,0,0,1,1
 * @author WilsonSong
 * @date 2018/9/5/005
 */
public class stackSolution {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public  void push(int num){
        stack.push(num);
        if (min.isEmpty()){
            min.push(num);
        }else {
            min.push(Math.min(num, min.peek()));
        }

    }

    public int pop(){
        if (stack == null){
            throw new IllegalArgumentException("Error");
        }
        min.pop();
        return stack.pop();
    }

    public int getMin(){
        if (min == null){
            throw new IllegalArgumentException("Error");
        }
        return min.peek();
    }

    public static void main(String[] args){
        stackSolution stackSolution = new stackSolution();
        for (int i = 0; i < 5; i++){
            stackSolution.push(i);
        }
        System.out.println(stackSolution.getMin());
    }

}
