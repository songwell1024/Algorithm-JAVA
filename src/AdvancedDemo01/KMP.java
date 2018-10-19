package AdvancedDemo01;

/**
 * KMP 算法
 * @author WilsonSong
 * @date 2018/10/17/017
 */
public class KMP {

    public int getIndexOf(String str1, String str2){
        if (str1 == null || str2 == null || str1.length() < str2.length() || str2.length() <1){
            return -1;
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[] next = getNext(c2);
        int i1 = 0; //指向c1的指针
        int i2 = 0; //指向c2的指针
        while (i2 < c2.length && i1 < c1.length){
            if (c1[i1] == c2[i2]){
                i1++;
                i2++;
            }else if (next[i2] == -1){
                i1++;
            }else {
                i2 = next[i2];
            }
        }
        return i2 == c2.length ?  i1-i2 : -1;
    }

    //获取待比较字符串的每个字符的最大前缀和最大后缀
    public int[] getNext(char[] str2){
        if (str2.length == 0 || str2 == null){
            return new int[] {-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while ( i < next.length){
            if (str2[i-1] == str2[cn]){
                next[i++] = ++cn;
            }else if (next[cn] > 0){
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
