package BasicDemo.Demo04;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所
 有字 符串拼起来之后形成的字符串具有最低的字典序。
 其实就是排好序之后依次拼接
 * @author WilsonSong
 * @date 2018/9/13/013
 */
public class LowestLexicography {

    public static String lowestString(String[] strs){
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
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }

}
