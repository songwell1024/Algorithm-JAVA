package BasicExample.BasicExamples05;


import java.util.HashMap;

/**
 * 设计RandomPool结构
 【题目】 设计一种结构，在该结构中有如下三个功能：
 insert(key)：将某个key加入到该结构，做到不重复加入。
 delete(key)：将原本在结构中的某个key移除。 getRandom()：
 等概率随机返回结构中的任何一个key。
 【要求】 Insert、delete和getRandom方法的时间复杂度都是
 O(1)
 * @author WilsonSong
 * @date 2018/12/10/010
 */
public class Code_02_RandomPool {

    public class RandomPool<K>{


        public HashMap<K, Integer> poolKV ;
        public HashMap<Integer,K> poolVK;
        public int size;
        public RandomPool(){
            this.poolKV = new HashMap<>();
            this.poolVK = new HashMap<>();
            this.size = 0;
        }

        public void insert(K key){
            poolKV.put(key,size);
            poolVK.put(size++, key);
        }

        public void delete(K key){
            if (poolKV.containsKey(key)){
                int index = poolKV.get(key);
                int lastIndex = --size;
                K lastKey = poolVK.get(lastIndex);
                poolKV.put(lastKey,index);
                poolVK.put(index,lastKey);
                poolKV.remove(key);
                poolVK.remove(lastIndex);
            }
        }

        public K getRandom(){
            if (size == 0){
                return null;
            }
            int index = (int)(Math.random() * size);
            return poolVK.get(index);
        }





    }

}
