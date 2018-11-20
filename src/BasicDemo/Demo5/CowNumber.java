package BasicDemo.Demo5;

/**
 * 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只
 母牛，假设不会死。求N年后，母牛的数量。
 * @author WilsonSong
 * @date 2018/9/19/019
 */
public class CowNumber {

    public static int NumCow(int n){
        if (n <= 3){
            return n;
        }
        return NumCow(n-1) + NumCow(n-3);      //其实就是前一年加上前三年的数量，因为今年能生牛的就是三年前的牛

    }

    public static int NumCow2(int n){
        int res = 0;
        if (n <= 3){
            return n;
        }
        else {
            for (int i = 4; i <= n; i ++){
                res = res + 3 + i - 3;     //推出的规律
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(NumCow2(n));
        System.out.println(NumCow2(n));
    }

}


