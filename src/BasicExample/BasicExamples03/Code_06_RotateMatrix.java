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

        process(data,0,0,data.length-1, data[0].length-1);
    }

    public static void process(int[][] data, int x, int y, int c, int l){
        int xx = x;
        int yy = y;
        if (x > c || y > l){
            return;
        }
        int i= 0;
        int cur;
        while (y < l){
            if (x == xx && y == yy){
               cur = data[x][y];
               cur = swap(data,x ,l, cur);
               cur = swap(data,c,l,cur);
               cur = swap(data,c, y,cur);
               cur = swap(data,x,y,cur);
               y++;
            }else {
                cur = data[x][y];
                cur = swap(data,x+y, l, cur);
                cur = swap(data,c, l-y, cur);
                cur = swap(data,c-y, yy, cur);
                cur = swap(data,x, y, cur);
                y++;
            }
        }

        process(data, xx+1, yy+1, c-1,l-1);

    }
    public static int swap(int[][] data, int x, int y, int index){
        int cur = data[x][y];
        data[x][y] = index;
        return cur;
    }

    public static void main(String[] args){
        int[][] matrix = { { 1, 2, 3 }, { 5, 6, 7 }, { 9,10,11}};
        rotateMatrix(matrix);
        System.out.println("dada");
    }


}
