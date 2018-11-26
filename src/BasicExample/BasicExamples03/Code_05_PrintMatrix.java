package BasicExample.BasicExamples03;

/**
 * 转圈打印矩阵
 * @author WilsonSong
 * @date 2018/11/25/025
 */
public class Code_05_PrintMatrix {

    public static void printMatrix(int[][] data){
        if (data.length < 1 || data == null){
            return;
        }

        process(data,0,0, data.length-1, data[0].length-1);
    }

    public static void process(int[][] data,int x, int y, int c, int l){
        int xx = x;
        int yy = y;
        if (x > c || y > l){
            return;
        }
        //打印四周边界，想一想

        if (x <= c && y <= l){
            while (y < l){
                System.out.println(data[x][y++]);
            }
        }

        if (x <= c && y == l){
            while (x < c){
                System.out.println(data[x++][y]);
            }
        }

        if (x == c && y ==l){
            while (y > yy){
                System.out.println(data[x][y--]);
            }
        }

        if (x == c && y <= l){
            while (x > xx){
                System.out.println(data[x--][y]);
            }
        }

        process(data,xx+1,yy+1,c -1, l -1);
    }

    public static void main(String[] args){
        int[][] matrix = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 },{ 13, 14, 15 }};
        printMatrix(matrix);
    }

}
