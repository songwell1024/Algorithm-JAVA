package Demo02;

import java.util.LinkedList;

/**
 * 如何仅用队列结构实现栈结构？
 * 实现的思路是使用两个队列来实现栈结构
 * 具体其实就是一个队列存储元素，然后另一个队列作为辅助队列当要弹出元素的时候把除了栈顶元素外的元素全部添加到另一个链表中
 * 然后互相交换
 * @author WilsonSong
 * @date 2018/9/5/005
 */
public class QueueToStack<E>{

    LinkedList<E> stack;
    LinkedList<E> helpStack;
     public QueueToStack(){
         this.stack = new LinkedList<>();
         this.helpStack = new LinkedList<>();
     }

     public void push(E num){
         stack.add(num);
     }

     public E pop(){
         if (stack.isEmpty()){
             return null;
         }
         while (!stack.isEmpty()){
             helpStack.add(stack.poll());
         }
         E ret = helpStack.poll();
         swap();
         return ret;
     }

     public E peek(){
         if (stack.isEmpty()){
             return null;
         }
         while (!stack.isEmpty()){
             helpStack.add(stack.poll());
         }

         E ret = helpStack.poll();
         helpStack.add(ret);
         swap();
         return ret;
     }

     private void swap(){
         LinkedList<E> cur = stack;
         stack = helpStack;
         helpStack = cur;
     }


}
