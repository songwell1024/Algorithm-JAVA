package AdvanceDemo.AdvancedDemo01;

/**
 * Manacher算法求一个字符串的最长回文子串长度
 * @author WilsonSong
 * @date 2018/10/19/019
 */
public class Manacher {

    public char[] ManacherString(String str){
        char[] c = new char[str.length()*2 +1];
        int index = 0;
        for (int i = 0; i < c.length; i++){
            c[i] = (i&1)==0 ? '#' : str.charAt(index++);
        }
        return c;
    }

    public int MaxLcpsLength(String str){

        if (str.length() == 0 || str == null){
            return 0;
        }
        char[] charArr = ManacherString(str);
        int c = -1;    //回文中心
        int R = -1;    //回文右边界
        int[] PArr = new int[charArr.length];     //存储回文半径的数组
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < charArr.length; i++){
            PArr[i] = R > i ? Math.min(PArr[2*c - i],R -i) : 1;    //最右回文半径的确定
            while (i + PArr[i] < charArr.length && i - PArr[i] > 1){
                if (charArr[i + PArr[i]] == charArr[i - PArr[i]]){
                    PArr[i]++;
                }else {
                    break;
                }
            }
            if (i + PArr[i] > R){
                R = i + PArr[i];
                c = i;
            }
            max = Math.max(max, PArr[i]);
        }
        return max -1;
    }



}
