package AdvanceDemo.AdvancedDemo01;

/**
 * BFPRT算法，求解无序数组中的第K小的数字,时间复杂度O(N)
 * @author WilsonSong
 * @date 2018/10/22/022
 */
public class BFPRT {

    public int GetMinthKByBFPRT(int[] data, int k){
        int[] copyData = copyData(data);
        return BFPRTProcess(data, 0, data.length-1,k-1);
    }

    public int[] copyData(int[] data){
        int[] copyArr = new int[data.length];
        for (int i =0; i < copyArr.length; i++){
            copyArr[i] = data[i];
        }
        return copyArr;
    }

    public int BFPRTProcess(int[] data, int L, int R, int i){
        if (L == R){
            return data[L];
        }

        int pivot = MedianOfMedians(data, L, R);
        int[] pivotRange = partition(data, L, R, pivot);
        if (i >= pivotRange[0] && i <= pivotRange[1]){
            return data[i];
        }else if (i < pivotRange[0]){
            return BFPRTProcess(data, L, pivotRange[0]-1, i);
        }else {
            return BFPRTProcess(data, pivotRange[1] +1, R,i);
        }
    }

    //取中位数树组的中位数
    public int MedianOfMedians(int[] data, int L, int R){
        int num = R - L +1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num/5 + offset];      //数组的划分,中位数数组
        for (int i = 0; i < mArr.length; i++){
            int BeginI = L + i*5;
            int EndI = BeginI +4;
            mArr[i] = getMedian(data, BeginI, EndI); //找中位数
        }

        return BFPRTProcess(data,0, mArr.length-1,mArr.length/2);    //返回的是中位数数组的中位数
    }

    public int getMedian(int[] data, int L, int R){
        insertionSort(data, L, R);
        int sum = R + L;
        int mid = (sum / 2) + (sum % 2);
        return data[mid];
    }

    public void insertionSort(int[] data, int L, int R){
        for (int i = L + 1; i < R + 1; i++){
            for(int j = i; j < R; j--){
                if (data[j-1] > data[j]){
                    swap(data, j-1, j);
                }else {
                    break;
                }
            }
        }
    }

    public void swap(int[] data, int i, int j){
        int cur = data[i];
        data[i] = data[j];
        data[j] = cur;
    }

    //返回进一步求解的范围
    public int[] partition(int[] data, int L, int R, int pivotValue){
        int small = L - 1;
        int cur = L;
        int big = R + 1;
        while (cur != big){
            if (data[cur] < pivotValue){
                swap(data, ++ small, cur++);
            }else if (data[cur] > pivotValue){
                swap(data, cur, --big);
            }else {
                cur ++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }


}
