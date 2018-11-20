package BasicDemo.Demo5;

import java.util.HashSet;

/**
 * 打印一个字符串的全部排列
 * 打印一个字符串的全部排列，要求不要出现重复的排列
 * 思路：
 1、将一个字符串分为两部分：第一部分为第一个字符，之后的子串属于第二部分；
 2、将第一个字符依次与后面的字符交换；
 3、每交换一次，对新串的第二部分子串进行递归的1、2操作；
 4、操作完之后，要把交换的两个字符恢复原位：这样做是为了避免出现重复的排序；
 5、到达字符串的最末位截止。
 * @author WilsonSong
 * @date 2018/9/14/014
 */
public class Print_All_Permutations {

   // 打印一个字符串的全部排列
    public static void PrintAllPermutations(String strs){
        char[] chars = strs.toCharArray();
        PrintProcess(chars, 0);
    }

    public static void PrintProcess(char[] chars, int k){
        if (k == chars.length){
            System.out.println(String.valueOf(chars));
            return;
        }
        for (int j = k; j < chars.length; j++){
            swap(chars, j,k);
            PrintProcess(chars,k+1);
        }
    }

    //打印一个字符串的全部排列，要求不要出现重复的排列
    public static void PrintAllPermutations2(String strs){
        char[] chars = strs.toCharArray();
        PrintProcess2(chars, 0);
    }

    public static void PrintProcess2(char[] chars, int k){
        if (k == chars.length){
            System.out.println(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = k; j < chars.length; j++){
            if (!set.contains(chars[j])){
                set.add(chars[j]);
                swap(chars, j,k);
                PrintProcess2(chars,k+1);
            }

        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        String test1 = "abc";
        PrintAllPermutations(test1);
        System.out.println("======");
        PrintAllPermutations2(test1);
        System.out.println("======");

        String test2 = "acc";
        PrintAllPermutations(test2);
        System.out.println("======");
        PrintAllPermutations2(test2);
        System.out.println("======");
    }

}
