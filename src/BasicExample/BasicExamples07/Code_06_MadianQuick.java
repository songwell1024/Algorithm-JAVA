package BasicExample.BasicExamples07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 一个数据流中，随时可以取得中位数
 * @author WilsonSong
 * @date 2018/12/16/016
 */
public class Code_06_MadianQuick {
    public static class MedianHolder{
        private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new MinHeapComparator());
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComaprator());

        public  void heapfiyTwoHeapSize(){
            if (this.minHeap.size() == this.maxHeap.size() + 2){
                maxHeap.add(minHeap.poll());
            }
            if (this.maxHeap.size() == this.minHeap.size() + 2){
                minHeap.add(maxHeap.poll());
            }
        }

        public  void addNum(int num){
            if (maxHeap.size() == 0){
                this.maxHeap.add(num);
                return;
            }

            if (maxHeap.peek() >= num){
                this.maxHeap.add(num);
            }else {
                if (this.minHeap.isEmpty()){
                    this.minHeap.add(num);
                    return;
                }
                if (this.minHeap.peek() > num){
                    this.maxHeap.add(num);
                }else {
                    this.minHeap.add(num);
                }
            }
            heapfiyTwoHeapSize();

        }


        public  int getMadian(){
            if (this.minHeap.size() + this.maxHeap.size() == 0){
                return 0;
            }

            if ((this.minHeap.size() + this.maxHeap.size()%2 == 0)){
                return (this.minHeap.peek() + this.maxHeap.peek())/2;
            }
            return this.minHeap.size() > this.maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }
    }

    private static class MaxHeapComaprator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 > o1){
                return 1;
            }else {
                return -1;
            }
        }

    }

    //Comparator里面的compare方法默认就是从小到大排序（o1-o2 或者是 -1）
    private static class MinHeapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2){
                return 1;
            }else {
                return -1;
            }
        }
    }

    public static void main(String[] args){
        MedianHolder medianHolder = new MedianHolder();
        int[] nums = {1,3,7,6,5};
        for (int num : nums){
            medianHolder.addNum(num);
        }
        System.out.println("qaq");


    }


}
