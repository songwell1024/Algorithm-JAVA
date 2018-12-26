package AdvanceExample.AdvanceExamples_01;

/**
 * 给定两个数a和b，如何不用比较运算符，返回较大的数。
 * @author WilsonSong
 * @date 2018/12/26/026
 */
public class Code_01_GetMax {

    public static int flip(int n){
        return n ^ 1;  //异或
    }

    public static int sign(int n){
        return flip(( n<<31) & 1 );   //负数符号位1,1^1 = 0，也就是负数为0，正数为1
    }

    public static int getMax(int a, int b){   //存在栈溢出的问题

        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);      //符号位去反

        return a*scA + b*scB;
    }

    public static int getMax2(int a, int b){
        int c = a - b;

        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int difSab = sa ^ sb;       //a 和 b的符号不同
        int samSab = flip(difSab);  //a 和 b的符号相同

        int reA = difSab &sa + samSab & sc;  //符号相同的话c为正数，则a大，符号不同的时候，a大会溢出
        int reB = flip(reA);
        return reA*a + reB *b;


    }





}
