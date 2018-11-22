package BasicExample.BasicExamples02;

/**
 * 随机快排
 * @author WilsonSong
 * @date 2018/11/22/022
 */
public class QuickSort {

    public static void quickSort(int[] data){
        if (data == null || data.length <= 1){
            return;
        }
        process(data, 0, data.length -1);
    }

    public static void process(int[] data, int L, int R){
        if (L < R){
            int[] p = paration(data, L, R);
            process(data, L, p[0] - 1);
            process(data, p[0] + 1, R);
        }
    }

    public static int[] paration(int[] data, int L, int R){
        int less = L - 1;
        int more = R;


        while (L < more){
            if (data[L] < data[R]){
                swap(data, ++less, L++);
            }else if (data[L] > data[R]){
                swap(data, --more, L);
            }else {
                L++;
            }
        }
        swap(data, more, R);

        return new int[]{less + 1, more};
    }

    public static void swap(int[] data, int i, int j){
        int index = data[i];
        data[i] = data[j];
        data[j] = index;
    }

    public static void main(String[] args){
        int[] data = {1,3,4,5,2,1,0,8};
        quickSort(data);
        for (int i : data){
            System.out.println(i);
        }
    }

}
