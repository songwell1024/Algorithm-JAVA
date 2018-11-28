package BasicExample.BasicExamples03;

/**
 * “之”字形打印矩阵
 * @author WilsonSong
 * @date 2018/11/27/027
 */
public class Code_08_ZigZagPrintMatrix {

    public static void zigZagPrintMatrix(int[][] data){
        if (data == null || data.length <= 0 || data[0].length <= 0){
            return;
        }
        int x = 0;
        int y = 0;
        int c = data.length-1;
        int l = data[0].length-1;
        boolean flag = true;

        while (x <= c && y <= l) {
            if (flag){
                while (x <= c && y >= 0){
                    System.out.println(data[x++][y--]);
                }
                x--;
                y++;
                flag = !flag;
                if (x==c){
                    y++;
                }else {
                    x++;
                }
            }else {
                while (x>=0 && y <= l){
                    System.out.println(data[x--][y++]);
                }
                x++;
                y--;
                flag = !flag;
                if (y == l){
                    x++;
                }else {
                    y++;
                }
            }
        }
    }

    public static void main(String[] args){
//        int[][] data = {{1,2,3}, {4,5,6},{7,8,9}};
        int[][] data = {{1,2}, {4,5},{7,8}};
        zigZagPrintMatrix(data);
    }
}
