package sort;

/**
 * 归并排序，基于二分和递归的思想
 * [3,6,2,5,7,1] -- [3,6,2] [5,7,1]排序 -- 然后合并
 * 其实就这把他二分到最下，然后在合并的过程中去比较
 * 时间复杂度是O(n*logn)
 * @author WilsonSong
 * @date 2018/9/3/003
 */
public class MergeSort {

    /**
     * 归并排序
     * @param arr
     */
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        sortProcess(arr, 0, arr.length-1);
    }

    /**
     * 分治思想+递归思想实现归并排序
     * @param arr
     * @param l
     * @param r
     */
    private static void sortProcess(int[] arr, int l, int r){
        if ( l > r){
            throw new IllegalArgumentException("Error");
        }
        if (l == r){
            return;
        }
        int mid =  l + (r-l)/2;
        sortProcess(arr, l, mid);
        sortProcess(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 融合的过程
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
     private static void merge(int[] arr, int l, int mid, int r){
         int[] help = new int[r - l + 1];
         int i = 0;
         int p1 = l;
         int p2 = mid +1;

         while (p1 <= mid && p2 <=r){
             help[i++] = arr[p1] < arr[p2]?  arr[p1++] : arr[p2 ++];
         }
         while (p1 <= mid){
             help[i++] = arr[p1++];
         }

         while (p2 <= r){
             help[i++] = arr[p2++];
         }

         for (int j = 0; j< help.length; j++){
             arr[j+l] = help[j];
         }
     }

    public static void main(String[] args){
        int[] a = {2,5,3,4,8,1};
        mergeSort(a);
        for (int aa : a){
            System.out.println(aa);
        }
    }

}
