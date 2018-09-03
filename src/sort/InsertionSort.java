package sort;

import java.util.Comparator;

/**
 * 插入排序
 * 第i个元素每次和前一个元素比较，小于的话就交换位置，
 * 然后该元素继续和其前一个位置元素交换，直至其不能在发生交换，
 * 这样的话前i个元素都已经排好序，然后i+1的元素继续上面的比较
 * @author WilsonSong
 * @date 2018/9/3
 */
public class InsertionSort {
    public static void insertSort(int[] arr){
        if (arr != null && arr.length > 1){
            for (int i = 0;  i < arr.length-1;  i ++){
                for (int j = i; j > 1; j--){
                    if (arr[j] < arr [j -1]){
                        swap(arr,j ,j-1);
                    }
                }
            }
        }
    }


    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
//        int cur = arr[i];
//        arr[i] = arr[j];
//        arr[j] = cur;
    }

    public static void main(String[] args){
        int[] a = {1,3,0,4,2,7};
        insertSort(a );
        for (int aa :a ){
            System.out.println(aa);
        }
    }
}
