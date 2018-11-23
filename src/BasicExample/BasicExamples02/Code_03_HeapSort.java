package BasicExample.BasicExamples02;

/**
 * 堆排序
 * @author WilsonSong
 * @date 2018/11/23/023
 */
public class Code_03_HeapSort {

    public static void heapSort(int[] data){
        if (data == null || data.length <= 1){
            return;
        }

        for (int i = 0; i < data.length; i++){
            heapInsert(data, i);
        }

        for (int i = data.length-1; i >=0; i--){
            if (data[0] > data[i]){
                swap(data, 0, i);
                heapfiy(data,i);
            }
        }
    }

    public static void heapInsert(int[] data, int i){
        while (data[i] < data[(i -1)/2] && i >=0 && (i -1)/2 >=0){
            swap(data, i, (i -1)/2);
            i = (i-1)/2;
        }
    }

    public static void heapfiy(int[] data, int i){
        int p = 0;
        while (p *2 +2 <i){
            if (data[p * 2 +1] > data[p*2 +2] && data[p] < data[p*2 + 1]){
                swap(data, p, p*2+1);
                p = p*2 +1;
            }else if (data[p*2+2] > data[p * 2 +1] && data[p] < data[p*2 + 2]){
                swap(data, p, p*2+2);
                p = p*2 +2;
            }else {
                break;
            }
        }
    }

    public static void swap(int[] data, int i, int j){
        int help = data[i];
        data[i] = data[j];
        data[j] = help;
    }


}
