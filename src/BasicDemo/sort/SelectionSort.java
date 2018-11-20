package BasicDemo.sort;

/**
 * 选择排序
 * 每次循环找i——(n-1)区间内的最小元素与i位置元素交换
 * @author WilsonSong
 * @date 2018/9/3/003
 */
public class SelectionSort {
    public static void selectionSort(int[] arr){
        if (arr != null && arr.length >1){
            for (int i = 0; i <arr.length ; i ++){
                for (int j  = i; j <arr.length; j++){
                    if (arr[j] < arr[i]){
                        swap(arr, i, j);
                    }
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int cur = arr[i];
        arr[i] = arr[j];
        arr[j] = cur;
    }


    public static void main(String[] args){
        int[] a = {1,5, 4, 6, 0};
        selectionSort(a);
        for (int aa : a){
            System.out.println(aa);
        }
    }
}
