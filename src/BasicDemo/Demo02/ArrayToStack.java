package BasicDemo.Demo02;

/**
 * 使用数组实现固定大小的栈
 * @author WilsonSong
 * @date 2018/9/5/005
 */
public class ArrayToStack {
    public int[] stack;
    private int size;

    public ArrayToStack(int IntilSize){
        this.stack = new int[IntilSize];
        this.size = 0;
    }

    public void  push(int num){
      if (size < stack.length){
          stack[size] = num;
          size ++;
      }else {
          throw new IllegalArgumentException("Error");
      }
    }

    public int pop(){
        if (stack != null){
            return stack[--size];

        }else {
            throw new  IllegalArgumentException("Error");
        }
    }

    public int peek(){
        if (stack != null){
            return stack[size-1];
        }else {
            throw new IllegalArgumentException("Error");
        }
    }



}
