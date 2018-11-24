package BasicExample.BasicExamples03;

/**
 * 数组实现固定大小的栈
 * @author WilsonSong
 * @date 2018/11/24/024
 */
public class Code_02_ArrayToStack {

    private int[] stack;
    private int size;

    public Code_02_ArrayToStack(int initialSize){
        if (initialSize < 0){
            throw new IllegalArgumentException("initial size can not smaller than 0");
        }
        this.stack = new int[initialSize];
        this.size = 0;
    }

    public  void push(int ele){
        if (size == stack.length){
            throw new IllegalArgumentException("stack is full");
        }
        stack[size] = ele;
        size++;
    }

    public int peek(){
        if (size > 0){
            return stack[size-1];
        }else {
           throw new IllegalArgumentException("Error");
        }
    }

    public int poll(){
        if (size > 0){
            return stack[--size];
        }else {
            throw new IllegalArgumentException("Error");
        }
    }


}
