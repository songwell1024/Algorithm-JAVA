package BasicExample.BasicExamples01;

/**
 * 归并排序
 * @author WilsonSong
 * @date 2018/11/21/021
 */
public class Code_07_MergeSort {

    public static void mergeSort(int[] data){
        if (data == null || data.length <= 1){
            return;
        }
        sortProcess(data, 0, data.length -1);
    }

    public static void sortProcess(int[] data, int L, int R){
        if (L == R){
            return;
        }

        sortProcess(data, L , (L + R)/2);
        sortProcess(data, (L + R)/2 + 1, R);
        merge(data, L, R);
    }

    public static void merge(int[] data, int L, int R){
        int[] help = new int[R - L + 1];
        int mid = L + (R + L)/2;
        int pre = L;
        int cur = mid + 1;

        for (int i = 0; i < help.length; i++){
          if (pre <= mid && cur <= R ){
              if (data[pre] <= data[cur]){
                  help[i] = data[pre++];
              }else {
                  help[i] = data[cur++];
              }
          }else if (cur <= R){
              help[i] = data[cur++];
          }else {
              help[i] = data[pre++];
          }
        }

        for (int i = 0; i < help.length; i++){
            data[L + i] = help[i];
        }

    }

    public static void main(String[] args){
        int[] data = {1,4,2,3,6,5};
        mergeSort(data);
        for (int i : data){
            System.out.println(i);
        }
    }


}
