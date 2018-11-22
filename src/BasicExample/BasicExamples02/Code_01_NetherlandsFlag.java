package BasicExample.BasicExamples02;

/**
 * 荷兰国旗问题
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 * @author WilsonSong
 * @date 2018/11/22/022
 */
public class Code_01_NetherlandsFlag {

    public static void NetherlandsFlagExamples(int[] arr, int num){
        int l = 0;
        int r = arr.length-1;

        while (l != r && l <= arr.length -1 && r >=0){
            if (arr[l] > num){
                swap(arr, l,r);
                r--;
            }else {
                l++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int index = arr[i];
        arr[i] = arr[j];
        arr[j] = index;
    }

    public static void main(String[] args){
        int[] arr = {1,5,6,3,7,0,9,3};
        NetherlandsFlagExamples(arr, 4);
        for (int i : arr){
            System.out.println(i);
        }
    }


}
