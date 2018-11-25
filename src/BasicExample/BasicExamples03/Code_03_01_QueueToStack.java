package BasicExample.BasicExamples03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 如何仅用队列结构实现栈结构？
 * @author WilsonSong
 * @date 2018/11/25/025
 */
public class Code_03_01_QueueToStack<E> {
    Queue<E> stack;
    Queue<E> helpStack;

    public Code_03_01_QueueToStack(){
        stack = new LinkedList<>();
        helpStack = new LinkedList<>();
    }

    public void push(E e){
        stack.add(e);
    }
    public E pop(){
        if (stack.isEmpty()){
            return null;
        }
        while (stack.size() != 1){
            helpStack.add(stack.poll());
        }
        E res = stack.poll();
        swapStack();
        return res;
    }

    public E peek(){
        if (stack.isEmpty()){
            return null;
        }
        while (stack.size() != 1){
            helpStack.add(stack.poll());
        }
        E res = stack.poll();
        helpStack.add(res);
        swapStack();
        return res;
    }

    public void swapStack(){
        Queue<E> cur = stack;
        stack = helpStack;
        helpStack = cur;
    }

    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
//        System.out.println(linkedList.poll());
        LinkedList<Integer> ll = new LinkedList<>();
        while (!linkedList.isEmpty()){
            ll.add(linkedList.poll());
        }
        System.out.println(ll.poll());
    }


}
