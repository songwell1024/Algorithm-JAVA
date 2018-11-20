package BasicDemo.sort;

/**
 * 冒泡排序
 * 前一个元素与后一个元素比较，大于交换
 * 每次排序后最大的元素会来到数组的末尾
 * 下一次比较就可以不比较最后一个元素，只需要比较到end-1即可
 * @author WilsonSong
 * @date 2018/9/3/003
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        if (arr != null && arr.length >1){
            for (int i = arr.length-1; i > 0; i--){
                for (int j = 0; j < i; j ++){
                    if (arr[j] > arr[i]){
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
        int[] a = {2,3,1,0,5};
        bubbleSort(a);
        System.out.println(a.toString());
    }

}
