package BasicExample.BasicExamples08;

import java.util.HashSet;

/**
 * 打印一个字符串的全排列，并且不出现重复的排列方式
 *
 * 让每个字符都当一次head，把第一个字符和后面的字符一一交换
 * 然后，固定第一个字符，（见上图黑框），求后面字符的全排列（递归思想），
 * 也就是继续把后面的字符分成两部分，第一个字符和后面的字符逐一交换。
 * 去重的全排列就是从第一个字符开始，每个字符分别与它后面非重复出现的字符交换。
 *
 *  * 思路：
 1、将一个字符串分为两部分：第一部分为第一个字符，之后的子串属于第二部分；
 2、将第一个字符依次分别与它后面非重复出现的字符交换；
 3、每交换一次，对新串的第二部分子串进行递归的1、2操作；
 4、操作完之后，要把交换的两个字符恢复原位：这样做是为了避免出现重复的排序；
 5、到达字符串的最末位截止。
 * @author WilsonSong
 * @date 2018/12/19/019
 */
public class Code_04_Print_All_Permutations {

    public static void printAllPermutations(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chars, int i){
        if (i == chars.length){
            System.out.println(String.valueOf(chars));
        }

        HashSet<Character> hashSet = new HashSet<>();
        for (int j = i; j < chars.length; j++){
            if (!hashSet.contains(chars[j])){
                hashSet.add(chars[j]);
                swap(chars,i,j);
                process(chars,i+1);
                swap(chars,i,j);
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args){
        printAllPermutations("abc");
    }




}
