package BasicExample.BasicExamples01;

/**
 * 冒泡排序
 * @author WilsonSong
 * @date 2018/11/20/020
 */
public class Code_00_BubbleSort {

    public static void bubbleSort(int[] data){
        if (data == null || data.length <=1 ){
            return;
        }
        for (int i = data.length -1; i >= 0; i --){
            for (int j = 0; j < i; j ++){
                if (data[j] > data[j+1]){
                    swap(data, j+1,j);
                }
            }
        }
    }
    public static void swap(int[] data, int i, int j){
        int index = data[i];
        data[i] = data[j];
        data[j] = index;
    }

    public static void main(String[] args){
        int[] data = {1,3,2,4,9,6,0};
        bubbleSort(data);
        for(int i :data){
            System.out.println(i);
        }

    }


}
