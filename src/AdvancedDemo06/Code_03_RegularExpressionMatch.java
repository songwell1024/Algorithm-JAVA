package AdvancedDemo06;

/**
 * 给定字符串str，其中绝对不含有字符'.'和'*'。再给定字符串exp，
 其中可以含有'.'或'*'，'*'字符不能是exp的首字符，并且任意两个
 '*'字符不相邻。exp中的'.'代表任何一个字符，exp中的'*'表示'*'
 的前一个字符可以有0个或者多个。请写一个函数，判断str是否能被
 exp匹配。
 * @author WilsonSong
 * @date 2018/11/19/019
 */
public class Code_03_RegularExpressionMatch {

    public boolean matchProcess(String str, String exp, int i, int j){
        if (str == null || exp == null || str.length() != exp.length()){
            return false;
        }
        char[] str1 = str.toCharArray();
        char[] exp1 = exp.toCharArray();

        if (j == exp1.length){
            return i == str1.length;
        }
        //表示j+1位置不能为* 且i位置有字符与j位置的字符进行匹配
        if (j  + 1 == exp1.length && exp1[j+1] != '*'){
            return i != str1.length && (exp1[j] == str1[j] || exp1[j] == '.') && matchProcess(str,exp,i+1,j+1);
        }

        //j+1位置是*，且j+1位置还有字符
        while (j + 1 != exp1.length && (exp1[j] == str1[i] || exp1[j] == '.')){
            if (matchProcess(str,exp,i, j +2)){
                return true;
            }
        }
        matchProcess(str,exp, i, j + 2);



    }

}
