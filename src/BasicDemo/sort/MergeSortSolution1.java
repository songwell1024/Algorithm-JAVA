package BasicDemo.sort;

/**
 * 使用归并的思想去处理数组小和问题，具体如下：
 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组
 的小和。
 例子：
 [1,3,4,2,5]
 1左边比1小的数，没有；
 3左边比3小的数，1；
 4左边比4小的数，1、3；
 2左边比2小的数，1；
 5左边比5小的数，1、3、4、2；
 所以小和为1+1+3+1+1+3+4+2=16
 * @author WilsonSong
 * @date 2018/9/3/003
 */
public class MergeSortSolution1 {

    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return mergeSort(arr, 0, arr.length-1);
    }

    private static int mergeSort(int[] arr, int l, int r){

        if (l > r){
            throw new IllegalArgumentException("Error");
        }
        if ( l == r){
            return 0;
        }
        int mid = l + (r-l)/2;
         return mergeSort(arr, l, mid) + mergeSort(arr, mid+1, r) + merge(arr, l, mid, r);

    }

    /**
     * 合并的过程一定要把排完序的数组返回给原数组
     * 要不然的话会出错，因为你在递归的过程中其实是对排完序的数组进行的合并
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @return
     */
    private static int merge(int[] arr, int l, int mid, int r){
        int[] help = new int[r-l+1];
        int i = 0;
        int ret = 0;
        int p1 = l;
        int p2 = mid +1;
        while ( p1 <= mid && p2 <= r){
            ret += arr[p1] < arr[p2]? arr[p1] *(r-p2+1) : 0;
            help[i++] = arr[p1] <  arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){  //这时候不需要在计算小和
            help[i++] =arr[p1++];
        }

        while (p2 <= r){  //这时候不需要在计算小和
            help[i++] =arr[p2++];
        }
        for (int j = 0; j < help.length; j++){
            arr[j+l] = help[j];
        }
        return ret;
    }

    public static void main(String[] args){
        int[] a =  {1,3,4,2,5};
        System.out.println(smallSum(a));

    }

}
