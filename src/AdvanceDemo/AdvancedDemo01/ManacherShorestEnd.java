package AdvanceDemo.AdvancedDemo01;

/**
 * Manacher算法应用
 * 向一个字符串后面添加一个字符串使得该字符串成为回文串，并且添加的串最短
 * 就是通过manacher算法找到包含最后一个字符的最长回文串然后把该回文串前面的字符逆序添加到字符串后面
 * @author WilsonSong
 * @date 2018/10/20/020
 */
public class ManacherShorestEnd {

    public char[] GetManacherString(String str){
        char[] c = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < str.length(); i++){
            c[i] = (i&1)==0? '#' : str.charAt(index++);
        }
        return c;
    }

    public String GetManacherShorestEndString(String str){
        if (str == null || str.length() == 0){
            return null;
        }
        char[] charArr = GetManacherString(str);
        int R = -1;
        int C = -1;
        int[] PArr = new int[charArr.length];
        int maxCotainsEnd = -1;

        for (int i = 0; i< charArr.length; i++){
            PArr[i] = R > i? Math.min(PArr[2*C-i], R-i) : 1;
            while (i +PArr[i] < charArr.length && i -PArr[i] > 1){
                if (charArr[i + PArr[i]] == charArr[i - PArr[i]]){
                    PArr[i] ++;
                }else {
                    break;
                }
            }

            if ( i + PArr[i] > R){
                C = i;
                R = i+ PArr[i];
            }
            if (R == charArr.length){
                maxCotainsEnd = PArr[i];
                break;
            }
        }

        char[] res = new char[str.length() - maxCotainsEnd +1];
        for (int i = 0; i < res.length; i++){
            res[res.length - i - 1] = charArr[2*i+1];
        }
        return String.valueOf(res);         //添加的最短子串
    }
}
