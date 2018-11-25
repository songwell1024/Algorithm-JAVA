package BasicExample.BasicExamples03;

import java.util.Stack;

/**
 * 如何仅用栈结构实现队列结构？
 * @author WilsonSong
 * @date 2018/11/25/025
 */
public class Code_03_02_StackToQueue<E> {

    private Stack<E> queue;
    private Stack<E> helpQueue;

    public Code_03_02_StackToQueue(){
        this.queue = new Stack<>();
        this.helpQueue = new Stack<>();
    }

    public void push(E e){
        queue.push(e);
    }

    public E pop(){
        if (queue.isEmpty()){
            return null;
        }
        while (!queue.isEmpty()){
            helpQueue.push(queue.pop());
        }
        E e = helpQueue.pop();
        swapQueue();
        return e;
    }

    public E peek(){
        if (queue.isEmpty()){
            return null;
        }
        while (!queue.isEmpty()){
            helpQueue.push(queue.pop());
        }
        E e = helpQueue.peek();
        swapQueue();
        return e;
    }

    public void swapQueue(){
        queue = helpQueue;
        helpQueue = null;
    }


}
