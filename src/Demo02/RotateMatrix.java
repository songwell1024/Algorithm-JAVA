package Demo02;

/**
 * 旋转正方形矩阵
 【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成
 顺时针旋转90度的样子。
 【要求】 额外空间复杂度为O(1)。
 解题的思路也是先外圈旋转然后内圈旋转
 * @author WilsonSong
 * @date 2018/9/6/006
 */
public class RotateMatrix {

    public static void rotate(int[][] matrix){
        int tr = 0;
        int tc = 0;
        int dr = matrix.length-1;
        int dc = matrix[0].length-1;

        while (tr < dr){
            rotateEdge(matrix, tr++, tc++, dr--, dc--);
        }
    }

    public static void rotateEdge(int[][] m, int tr, int tc, int dr, int dc){
        int times = dc - tc;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tr][tc + i];
            m[tr][tc + i] = m[dr - i][tc];
            m[dr - i][tc] = m[dr][dc - i];
            m[dr][dc - i] = m[tr + i][dc];
            m[tr + i][dc] = tmp;
        }
    }


}
