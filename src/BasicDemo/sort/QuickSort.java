package BasicDemo.sort;

/**
 * 随机快速排序
 * 其实就是选定位置然后进行比较吧比他大的数放在左边，把比他小的数放在右边
 * @author WilsonSong
 * @date 2018/9/4
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr, 0, arr.length-1);
    }

    private static void sortProcess(int[] arr, int l, int r){
        if (l < r){
            int[] p = particition(arr, l, r);
            sortProcess(arr, l, p[1]);
            sortProcess(arr,p[0],r );
        }

    }

    /**
     * 小于边界和大于边界移动的过程
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int[] particition(int[] arr, int l, int r){
        int less = l-1;
        int more = r ;
        swap(arr, l + (int)(Math.random()*(r-l+1)), r);       //随机选取一个元素与最后一个元素交换，然后以最后一个元素为参考进行快排

        while (l < more){
            if (arr[l] > arr[r]){
                swap(arr, l, r-1);
                more --;
            }else if (arr[l] < arr[r]){
                less++;
                l++;
            }else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[] {  less +1,more -1};
    }

    /**
     * 交换元素
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j){
        int cur = arr[i];
        arr[i] = arr[j];
        arr[j] = cur;
    }

    public static void main(String[] args){
        int[] a = {1,5,6,2,3,0};
        quickSort(a);
        for (int aa : a){
            System.out.println(aa);
        }

    }
}
