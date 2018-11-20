package BasicExample.BasicExamples01;

/**
 * 插入排序
 * 把当前选择的元素放在已经排好序的数组中
 * @author WilsonSong
 * @date 2018/11/20/020
 */
public class Code_02_InsertSort {

    public static void insertSort(int[] data){
        if (data == null || data.length <= 1){
            return;
        }

        for (int i = 0; i < data.length; i ++){
            for (int j = 0; j < i; j ++){
                if (data[i] < data[j]){
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
        insertSort(data);
        for (int i : data){
            System.out.println(i);
        }
    }
}
