package BasicDemo.sort;

import java.util.*;

/**
 * @author WilsonSong
 * @date 2018/9/4/004
 */
public class demo {

    public static void main(String[] args){
        int[] data = {1,5,3,7,100,128,256,0,1000};
        Integer[] nums = IntegerSort(data);
        for (int num : nums){
            System.out.println(num);
        }

        HashMapSort();

    }

    private static void mapSort(){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i  =0; i < 10; i++){
            map.put((int)(Math.random() * i), i);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }

    }

   private static class IntegerCompator implements Comparator<Integer>{

       @Override
       public int compare(Integer o1,  Integer o2) {
           return o1 - o2;
       }
   }


   public static Integer[]  IntegerSort(int[] data){
       Integer[] dataCopy = new Integer[data.length];
       for (int i = 0; i < data.length; i++){
           dataCopy[i] = (Integer) data[i];
       }

       Arrays.sort(dataCopy, new IntegerCompator());
       return dataCopy;
   }

   //字符串排序
   public static class StringComparator implements Comparator<String>{

       @Override
       public int compare(String o1, String o2) {
           return o1.compareTo(o2);
       }
   }

   public static void StringSort(String[] strs){
        Arrays.sort(strs,new StringComparator());
   }

   //第二种简洁写法
   public static void StringSort2(String[] strs){
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
   }


   private static void HashMapSort(){
       HashMap<Integer, Integer> map = new HashMap<>();
       for (int i  =0; i < 10; i++){
           map.put((int)(Math.random() * i), i);
       }

       ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>();
       list.addAll(map.entrySet());
       Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
           @Override
           public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
               return o1.getValue() - o2.getValue();
           }
       });

       for (Map.Entry<Integer, Integer> mapping : list){
           System.out.println(mapping.getKey() +","+ mapping.getValue());
       }

   }


}
