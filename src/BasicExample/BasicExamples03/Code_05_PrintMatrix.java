package BasicExample.BasicExamples03;

/**
 * 转圈打印矩阵
 * @author WilsonSong
 * @date 2018/11/25/025
 */
public class Code_05_PrintMatrix {

    public void printMatrix(int[][] data){
        if (data.length < 1 || data == null){
            return;
        }

        process(data,0,0, data.length, data[0].length);
    }

    public void process(int[][] data,int x, int y, int c, int l){
        if (c <= 0 || l <=0){
            return;
        }
        //打印四周边界，想一想
//        while (x < c && y < l){
//            System.out.println(data[x][y++]);
//        }
//        while (x < c && y == l - 1){
//            System.out.println(data[++x][y]);
//        }
//
//        while (x == c-1 && y >=0){
//            System.out.println(data[x][--y]);
//        }
//
//        while (x > 0)

        process(data,x,y+1,c -2, l -2);
    }

}
