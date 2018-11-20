package BasicDemo.Demo5;

/**
 * 打印一个字符串的全部子序列，包括空字符串
 * 思路就是字符串遍历成数组然后数组的每一个位置的字符选择是该字符还是空格
 * @author WilsonSong
 * @date 2018/9/14/014
 */
public class Print_All_Subsquences {

    public static void PrintAllSubsquences(String strs){
        char[] chars = strs.toCharArray();
        printProcess(chars, 0);


    }

    public static void printProcess(char[] chars, int k){
        if ( k ==chars.length){
            System.out.println(String.valueOf(chars));
            return;
        }
        printProcess(chars, k + 1);
        char tmp = chars[k];
        chars[k] = ' ';
        printProcess(chars, k+1);
        chars[k] = tmp;

    }

    public static void printProcess2(char[] chars, int k, String res){
        if (k == chars.length){
            System.out.println(res);
        }
        printProcess2(chars, k+1, res);
        printProcess2(chars, k+1, res + String.valueOf(chars[k]));

    }

    public static void main(String[] args) {
        String test = "abc";
        PrintAllSubsquences(test);
    }

}
