package BasicExample.BasicExamples03;

/**
 * 使用数组实现固定大小的队列
 * @author WilsonSong
 * @date 2018/11/24/024
 */
public class Code_01_ArrayToQueue {
    public int[] queue;
    public int size;
    public int tail;
    public int front;

    public Code_01_ArrayToQueue(int initialSize){
        if (initialSize < 0){
            throw new IllegalArgumentException("Error");
        }
        this.queue = new int[initialSize];
        this.size = 0;
        this.front = 0;
        this.tail = 0;
    }

    public void push(int elem){
        if (size > queue.length){
            throw new IllegalArgumentException("Error");
        }
        if (tail == front){
            queue[tail] = queue[front] = elem;
            size++;
        }else {
            queue[tail] = elem;
            tail = tail == queue.length-1 ? 0 : tail + 1;
            size++;
        }
    }

    public int peek(){
        if (queue == null){
            throw new IllegalArgumentException("queue is empty");
        }
        return queue[front];
    }

    public int poll(){
        if (size == 0){
            throw new IllegalArgumentException("queue is empty");
        }
        int index = front;
        front = front == queue.length-1 ? 0 : front + 1;
        size--;
        return queue[index];
    }

}
