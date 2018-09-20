package Demo5;


/**
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 加起来。返回最小的路径和。
 * @author WilsonSong
 * @date 2018/9/20/020
 */
public class MinPath {

    public static int getMinPath(int[][] data){

        if (data == null){
            return 0;
        }
        return Min(data,0,0);
    }

    public static int Min(int[][] data, int row, int col){

        if (row == data.length-1 && col == data[0].length-1){
            return data[row][col];
        }else if (row == data.length-1){
            return data[row][col] + Min(data,row,col+1);
        }else if (col == data[0].length-1){
            return data[row][col] + Min(data,row+1,col);
        }else {
            if (data[row][col+1] < data[row+1][col]){
                return data[row][col] + Min(data,row, col+1);
            }else {
                return data[row][col] + Min(data,row+1, col);
            }
        }
    }

    public static void main(String[] args){
        int[][] m = {{1,2,3},{3,1,6},{7,0,9}};
        System.out.println(getMinPath(m));
    }

}
