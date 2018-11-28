package BasicExample.BasicExamples03;

/**
 * 在行列都排好序的矩阵中找数
 * 从左上角开始找
 * @author WilsonSong
 * @date 2018/11/28/028
 */
public class Code_09_FindNumberInSortMatrix {

    public static boolean findNumInSortMatrix(int[][] data, int num) {
        if (data == null || data.length <= 0) {
            return false;
        }

        int x = 0;
        int y = data[0].length-1;
        while (x <= data.length-1 && y >=0){
            if (data[x][y] == num){
                return true;
            }else if (data[x][y] > num){
                y--;
            }else {
                x++;
            }
        }
        return false;

    }
    public static void main(String[] args){
        int[][] data = {{0,1,2,5},{2,3,4,6},{3,4,4,7},{5,7,7,9}};
        System.out.println(findNumInSortMatrix(data,8));
    }

}
