package BasicDemo.sort;

/**
 * 使用归并排序打印所有的逆序对 具体如下：
 逆序对问题
 在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序
 对。
 * @author WilsonSong
 * @date 2018/9/3/003
 */
public class MergeSortSolution2 {

    public static void ReverseOrderPair(int[] arr){
        if (arr == null || arr.length < 2 ){
            return;
        }
        MergeSort(arr, 0, arr.length-1);
    }

    private static void  MergeSort(int[] arr, int l, int r){
        if (l > r){
            throw new IllegalArgumentException("Error");
        }
        if (l == r){
            return;
        }
        int mid =  l + (r - l)/2;
        MergeSort(arr, l, mid);
        MergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r){
        int[] help = new int[r - l +1];
        int i = 0;
        int p1 = l;
        int p2 = mid +1;
        while (p1 <= mid && p2 <= r){
            if (arr[p1] > arr[p2]){
                int cur = p1;
                while (cur <= mid){
                    System.out.println("[" + arr[cur] + "," + arr[p2] + "]");
                    cur ++;
                }
                help[i++] = arr[p2++];
            }else {
                help[i++] = arr[p1++];
            }
        }
        while (p1 <= mid){
            help[i++] = arr[p1 ++];
        }
        while (p2 <= r){
            help[i++]  = arr[p2++];
        }

        for (i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }


    public static void main(String[] args){
        int[] a = {2,1,0,3,2};
        ReverseOrderPair(a);
    }
}
