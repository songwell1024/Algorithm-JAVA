package Demo02;

/**
 * 数组实现固定大小队列
 * @author WilsonSong
 * @date 2018/9/5
 */
public class ArrayToQueue {
    int[] queue;
    int size;
    int front;
    int tail;

    public ArrayToQueue(int initialSize){
        if (initialSize < 0){
            throw new IllegalArgumentException("Error");
        }
        this.queue = new int[initialSize];
        this.size = 0;
        this.front = 0;
        this.tail = 0;
    }

    public void push(int num){
        if (size >= queue.length){
            throw new IllegalArgumentException("Error");
        }
        queue[tail] = num;
        tail  = tail == queue.length-1 ? 0 : tail +1;   //到栈底的话是要回到栈顶的
        size ++;
    }

    public int poll(){
        if (size == 0){
            throw new IllegalArgumentException("Error");
        }
        int ret = queue[front];
        front = front == queue.length-1 ? 0 : front +1;  //到栈底的话是要回到栈顶的
        size --;
        return ret;
    }

    public int peek(){
        if (size == 0){
            throw new IllegalArgumentException("Error");
        }
        return queue[front];
    }
}
