package BasicExample.BasicExamples01;

/**
 * 选择排序
 * 选择未排序的剩余子数组中的最小值或最大值放在未排序子数组的第一个位置
 * @author WilsonSong
 * @date 2018/11/20/020
 */
public class Code_01_SelectionSort {

    public static void selectionSort(int[] data){
        if (data == null || data.length <= 1){
            return;
        }
        for (int i = 0; i < data.length; i++){
            for (int j = i + 1; j < data.length; j++){
                if (data[j] < data[i]){
                    swap(data, i, j);
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
        int[] data = {1,4,5,2,3,0,1};
        selectionSort(data);
        for (int i : data){
            System.out.println(i);
        }
    }


}
