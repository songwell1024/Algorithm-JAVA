package BasicExample.BasicExamples08;

/**
 * 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只
 母牛，假设不会死。求N年后，母牛的数量。
 * @author WilsonSong
 * @date 2018/12/22/022
 */
public class Code_05_Cows {

    public static int getCowsNum(int N){
        if (N <= 0){
            return 0;
        }
        if (N <= 3){
            return N ;
        }
        return getCowsNum(N -1) + getCowsNum(N -3);
    }

    //母牛只能活10年
    public static int getCowsNum2(int N){
        if (N <= 0){
            return 0;
        }
        if (N <= 3){
            return N ;
        }
        if (N < 10){
            return getCowsNum(N -1) + getCowsNum(N -3);
        }
        else {
            return getCowsNum(N -1) + getCowsNum(N -3) - 2;
        }

    }



    public static void main(String[] args){
        System.out.println(getCowsNum(1));
    }


}
