package BasicExample.BasicExamples07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所
 有字 符串拼起来之后形成的字符串具有最低的字典序。
 * @author WilsonSong
 * @date 2018/12/16/016
 */
public class Code_07_LowestLexicography {

    public static String getLowestString(String[] strs){
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        String res = "";
        for (int i = 0; i < strs.length; i++){
            res += strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(getLowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(getLowestString(strs2));

    }

}
