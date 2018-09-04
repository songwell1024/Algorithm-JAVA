package sort;

import java.util.*;

/**
 * @author WilsonSong
 * @date 2018/9/4/004
 */
public class demo {

    public static void main(String[] args){
        mapSort();

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
