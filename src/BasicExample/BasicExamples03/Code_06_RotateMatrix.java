package BasicExample.BasicExamples03;

/**
 * 旋转正方形矩阵
 * 给定一个整型正方形矩阵matrix，请把该矩阵调整成
 顺时针旋转90度的样子。
 * @author WilsonSong
 * @date 2018/11/26/026
 */
public class Code_06_RotateMatrix {

    public static void rotateMatrix(int[][] data){
        if (data.length < 1 || data == null){
            return;
        }


    }

    public static void process(int[][] data, int x, int y, int c, int l){
        int xx = x;
        int yy = y;
        if (x > c || y > l){
            return;
        }
        int i= 0;
        int cur;
        while (x < c){
            if (x == xx && y == yy){
               cur = data[x][y];
               cur = swap(data,x ,l, cur);
               cur = swap(data,c,l,cur);
               cur = swap(data,c, y,cur);
               cur = swap(data,x,y,cur);
               y++;
            }else {
                cur = data[x][y];
                
            }

        }


    }

    public static int swap(int[][] data, int x, int y, int index){
        int cur = data[x][y];
        data[x][y] = index;
        return cur;
    }


}
