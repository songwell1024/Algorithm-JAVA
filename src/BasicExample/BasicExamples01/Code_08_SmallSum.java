package BasicExample.BasicExamples01;

/**
 * 小和问题
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
 * @date 2018/11/21/021
 */
public class Code_08_SmallSum {

    public static int getSmallSum(int[] data){
        if (data == null || data.length <= 1){
            return 0;
        }
        return process(data, 0, data.length - 1);
    }

    public static int process(int[] data, int l, int r){
        if (l == r){
            return 0;
        }

        int mid = l + (r - l)/2;
        return process(data, l, mid) + process(data, mid + 1, r) + merge(data, l ,mid, r);
    }

    public static int merge(int[] data, int l, int mid, int r){
        if (l > r || l > mid || mid > r){
            throw new IllegalArgumentException("Error");
        }
        int sum = 0;
//        int pre = l;
        int last = mid + 1;
        int[] help = new int[r - l + 1];
        while (last <= r){
            int pre = l;
            while (pre <= mid){
                if (data[pre] < data[last]){
                    sum += data[pre++];
                }else {
                    break;
                }
            }
            last++;
        }
////也是对的
//        int i = 0;
//        while (pre <= mid && last <= r){
//            sum += data[pre] < data[last] ? data[pre] *(r - last + 1) : 0;
//            help[i++] = data[pre] < data[last] ? data[pre++] : data[last++];
//
//        }
//
//        while (last <= r){
//            help[i++] = data[last++];
//        }
//
//        while (pre <= mid){
//            help[i++] = data[pre++];
//        }
//
//        for (int j = 0; j < help.length; j ++){
//            data[l + j] = help[j];
//        }
        return sum;
    }

    public static void main(String[] args){
        int[] data = {1,4,6,2,3,5};
        System.out.println(getSmallSum(data));
    }



}
