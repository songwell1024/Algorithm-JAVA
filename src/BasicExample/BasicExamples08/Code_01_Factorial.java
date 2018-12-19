package BasicExample.BasicExamples08;

/**
 * n!
 * @author WilsonSong
 * @date 2018/12/17/017
 */
public class Code_01_Factorial {

    public static int factorial(int n){
        if (n == 1){
            return 1;
        }
        return n* factorial(--n);
    }

    public static void main(String[] args){
        System.out.println(factorial(5));
    }



}
