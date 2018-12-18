package BasicExample.BasicExamples08;

/**
 * 打印一个字符串的全部子序列，包括空字符串
 * 遍历字符串数组，选择要还是不要来到的这个位置的字符串
 * @author WilsonSong
 * @date 2018/12/18/018
 */
public class Code_03_Print_All_Subsquences {

    //遍历
    public static void printAllSubquences(String str){

        System.out.println("");
        char[] strs = str.toCharArray();

        for (int i = 0; i < str.length(); i++){
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = i; j < str.length(); j++){
                stringBuffer.append(strs[j]);
                System.out.println(stringBuffer.toString());
            }
        }
    }

    //递归
    public static void printAllSubquencesByProcess(String str){
        char[] chars = str.toCharArray();
        process(chars,0,"");

    }

    public static void process(char[] chars, int i, String res){
        if (i == chars.length){
            System.out.println(res);
            return;
        }

        process(chars, i+1, res);
        process(chars, i+1, res + String.valueOf(chars[i]));

    }


    public static void process2(char[] chars, int i){
        if (i == chars.length){
            System.out.println(String.valueOf(chars[i]));
        }

        process2(chars,i+1);

        char tmp = chars[i];
        chars[i] = ' ';
        process2(chars,i+1);
        chars[i] = tmp;
    }

    public static void main(String[] args){
        printAllSubquences("abc");
    }

}
