package BasicDemo.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 其实堆排序的过程就是先将一个数组构成最大堆，然后将堆顶元素与队尾元素交换然后将当前堆顶的元素进行下沉操作
 * @author WilsonSong
 * @date 2018/9/4
 */
public class HeapSort {
    public static void heapSort(int[] arr){
       if (arr.length < 2 || arr == null){
           return;
       }
       for (int i = 0; i < arr.length; i++){
           HeapInsert(arr, i);
       }
       for (int i = arr.length-1; i >= 0; i --){
           if (arr[0] > arr[i]){
               swap(arr, i, 0);
               Heapfiy(arr, i);
           }
       }
    }

    /**
     * 插入元素
     * @param arr
     * @param index
     */
    public static void HeapInsert(int[] arr, int index){
        while (arr[index] > arr[(index-1)/2] && (index -1)/2 >= 0){
            swap(arr, index, (index-1)/2);
            index = (index -1)/2;
        }
    }

    private static void Heapfiy(int[] arr, int heapSize){
        int p = 0;
        while ((p *2 +2) <  heapSize){
           if (arr[p*2+1] >= arr[p*2+2] && arr[p] < arr[p*2+1]){
               swap(arr, p, p*2+1);
               p = p*2+1;
           }else if (arr[p*2+1] < arr[p*2+2] && arr[p] < arr[p*2+2]){
                   swap(arr, p, p*2+2);
                   p = p*2+2;
           }else {
               break;
           }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int cur = arr[i];
        arr[i] = arr[j];
        arr[j] = cur;
    }


    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

//    public static void main(String[] args){
//        int[] a = {1,0,3,-1};
//        heapSort(a);
//        for (int aa :a){
//            System.out.println(aa);
//        }
//    }
// for test
public static void main(String[] args) {
    int testTime = 500000;
    int maxSize = 100;
    int maxValue = 100;
    boolean succeed = true;
    for (int i = 0; i < testTime; i++) {
        int[] arr1 = generateRandomArray(maxSize, maxValue);
        int[] arr2 = copyArray(arr1);
        heapSort(arr1);
        comparator(arr2);
        if (!isEqual(arr1, arr2)) {
            succeed = false;
            break;
        }
    }
    System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    int[] arr = generateRandomArray(maxSize, maxValue);
    printArray(arr);
    heapSort(arr);
    printArray(arr);
}


}
