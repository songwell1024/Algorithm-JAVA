package Demo02;

import java.util.Stack;

/**
 * 如何仅用栈结构实现队列结构？
 * 思路仅仅使用栈实现队列是一样的
 * @author WilsonSong
 * @date 2018/9/5/005
 */
public class StackToQueue<E> {
    Stack<E> queue = new Stack<>();
    Stack<E> helpQueue = new Stack<>();

    public void push(E e){
        queue.push(e);
    }

    public E poll(){
        if (queue.isEmpty()){
            return null;
        }
        while (!queue.isEmpty()){
            helpQueue.push(queue.pop());
        }
        E ret = helpQueue.pop();
        swap();
        return ret;
    }

    public E peek(){
        if (queue.isEmpty()){
            return null;
        }
        while (!queue.isEmpty()){
            helpQueue.push(queue.pop());
        }
        E ret = helpQueue.pop();
        helpQueue.push(ret);
        swap();
        return ret;
    }

    private void swap(){
        Stack<E> cur  = queue;
        queue = helpQueue;
        helpQueue = cur;
    }

}
