package sort;

/**
 * 荷兰国旗问题
 给定一个数组arr，和一个数num，请把小于num的数放在数组的
 左边，等于num的数放在数组的中间，大于num的数放在数组的
 右边。
 要求额外空间复杂度O(1)，时间复杂度O(N)
 * @author WilsonSong
 * @date 2018/9/3/003
 */
public class NetherlandsFlag {

    /**
     * 元素的遍历交换
     * @param arr
     * @param num
     * @return
     */
    public static int[] partition(int[] arr, int num, int l, int r){
        int less = l-1;
        int more = r +1;

        while (l < more){

            if (arr[l] > num){
                swap(arr, less +1, l);
                less++;
                l++;
            }else if (arr[l] < num){
                swap(arr, more-1, l);
                more -- ;
                //不做交换，为什么，因为这里的交换过来的元素是大于区域边界的元素，这个元素还没有进行判断呢，属于待定区域的元素
                // 而在左侧的元素是你已经比较过的，其实也就是小于区域左边的是等于区域的元素，所以可以不用重复比较，可以进行l++,然后去比较下一个元素
            }else {
                l++;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j){
//        这么做不行，因为涉及到自己和自己交换
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,6,3,7,0};
        a = partition(a, 3,0, a.length-1);
        for (int aa : a){
            System.out.println(aa);
        }
    }

}
