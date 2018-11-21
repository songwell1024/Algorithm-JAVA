package BasicExample.BasicExamples01;

/**
 * 逆序对
 * 在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序
 对。
 * @author WilsonSong
 * @date 2018/11/21/021
 */
public class Code_08_InvertedSequence {

    public static void getInvertedSequence(int[] data){
        if (data == null || data.length <= 1){
            return;
        }
        process(data, 0, data.length -1);
    }
    public static void process(int[] data, int l, int r){
        if (l == r){
            return;
        }

        int mid = l + (r - l)/2;
        process(data, l, mid);
        process(data, mid + 1, r);
        merge(data, l, mid, r);
    }

    public static void merge(int[] data, int l, int mid, int r){

        int pre = l;
        int last = mid + 1;
        int[] help = new int[r - l + 1];
        int i = 0;

        while (pre <= mid && last <= r){
            int cur = mid + 1;
            if (data[pre] > data[last]){
                help[i++] = data[last];
                while (cur <= last){
                    System.out.println(data[pre] + ',' + data[cur++]);
                }
                last++;
            }else {
                help[i++] = data[pre];
            }
        }
        while (pre <= l){
            help[i++] = data[pre ++];
        }
        while (last <= r){
            help[i++] = data[last++];
        }

        for (i = 0; i < help.length; i++){
            data[l+i] = help[i];
        }
    }

}
