package Demo02;

/**
 * 转圈打印矩阵
 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 15 16 打印结果为：1，2，3，4，8，12，16，15，14，13，9，
 5，6，7，11， 10
 【要求】 额外空间复杂度为O(1)。
 * @author WilsonSong
 * @date 2018/9/6/006
 */
public class PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix){
        if (matrix == null){
            throw new IllegalArgumentException("Error");
        }
        int tr = 0;
        int tc = 0;
        int dr = matrix.length-1;
        int dc = matrix[0].length-1;

        while (tr<= dr && tc <= dc){
            printEdge(matrix, tr++, tc++, dr--, dc--);
        }
    }

    public static void printEdge(int[][] m, int tr, int tc, int dr, int dc){
       //只有一行的时候
        if (tr ==  dr){
            for (int i = tc; i <= dc; i ++){
                System.out.println(m[tr][i] + " ");
            }
        }

        //只有一列的时候
        else if (tc == dc){
            for (int i = tr; i <= dr; i++){
                System.out.println(m[i][tc] + " ");
            }
        }

        else {     //不止一行或不止一列的时候
            int curR = tr;
            int curC = tc;
            while (curC != dc){
                System.out.println(m[tr][curC] + " ");
                curC++;
            }
            while (curR != dr){
                System.out.println(m[curR][curC] + " ");
                curR++;
            }
            while (curC != tc){
                System.out.println(m[dr][curC] + " ");
                curC--;
            }
            while (curR != tr){
                System.out.println(m[curR][tc] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }

}
