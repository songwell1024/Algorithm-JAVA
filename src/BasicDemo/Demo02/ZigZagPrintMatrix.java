package BasicDemo.Demo02;

/**
 * “之”字形打印矩阵
 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这
 个矩阵，例如： 1 2 3 4 5 6 7 8 9 10 11 12
 “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，
 8，12
 【要求】 额外空间复杂度为O(1)。
 * @author WilsonSong
 * @date 2018/9/6/006
 */
public class ZigZagPrintMatrix {

   public  static void PrintMatrixZigZag(int[][] data){
       int tr = 0;
       int tc = 0;
       int dr = 0;
       int dc = 0;
       int endR = data.length-1;
       int endC = data[0].length -1;
       boolean form = false;

       while (tc <= endC && tr <= endR){
           if (tc < endC && dr < endR){
               PrintZigZag(data, tr, tc++, dr++, dc, form);
               form = !form;
           }else if (dr < endR){
                PrintZigZag(data, tr++, tc, dr++, dc,form);
                form = !form;
           }else  if (tc < endC){
               PrintZigZag(data, tr, tc++, dr, dc++, form);
               form = !form;
           }else {
               PrintZigZag(data, tr++, tc, dr, dc++, form);
               form = !form;
           }
       }
   }

   public static void  PrintZigZag(int[][] data, int tr, int tc, int dr, int dc, boolean from){
       if (from){
           while (tr <= dr && tc >=dc){
               System.out.println(data[tr++][tc--]);
           }
       }else {
           while (dr >= tr && dc<= tc ){
               System.out.println(data[dr--][dc++]);
           }
       }
   }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        PrintMatrixZigZag(matrix);

    }

}
