package AdvancedDemo02;

import java.util.HashMap;

/**
 * 设计可以变更的缓存结构（LRU）
 【题目】
 设计一种缓存结构，该结构在构造时确定大小，假设大小为K，并有两个功能：
 set(key,value)：将记录(key,value)插入该结构。
 get(key)：返回key对应的value值。
 【要求】
 1．set和get方法的时间复杂度为O(1)。
 2．某个key的set或get操作一旦发生，认为这个key的记录成了最经常使用的。
 3．当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 【举例】
 假设缓存结构的实例是cache，大小为3，并依次发生如下行为：
 1．cache.set("A",1)。最经常使用的记录为("A",1)。
 2．cache.set("B",2)。最经常使用的记录为("B",2)，("A",1)变为最不经常的。
 3．cache.set("C",3)。最经常使用的记录为("C",2)，("A",1)还是最不经常的。
 4．cache.get("A")。最经常使用的记录为("A",1)，("B",2)变为最不经常的。
 5．cache.set("D",4)。大小超过了3，所以移除此时最不经常使用的记录("B",2)，
 加入记录 ("D",4)，并且为最经常使用的记录，然后("C",2)变为最不经常使用的
 记录
 * @author WilsonSong
 * @date 2018/10/30/030
 */
public class LRU {
    //双向链表的节点
    public class Node<V>{
        public Node<V> last;
        public Node<V> next;
        public V value;

        public Node(V value){
            this.value = value;
        }
    }

    public class NodeDoubleLinkedList<V>{
        private Node<V> head;
        private Node<V> tail;

        public NodeDoubleLinkedList(){
            this.head = null;
            this.tail = null;
        }

            public void addNode(Node<V> node){
               if (node == null){
                   return;
               }
               if (head == null && tail == null){
                   head = node;
                   tail = node;
               }else {
                   tail.next = node;
                   node.last = tail;
                   tail = node;
               }
            }

            public Node<V> removeHeadNode(){
                if (head == null){
                    return null;
                }

                Node<V> res = head;     //因为要返回值才设置这么一个变量，否则不用设置
                if (head == tail){
                    tail = null;
                    head = null;
                }else {
                    head = res.next;
                    res.next = null;
                    head.last = null;
                }
                return res;
            }

            public void moveNodeToTail(Node<V> node){
                if (head == tail){
                    return;
                }
                if (tail == node){
                    return;
                }else if (head == node){
                    head = node.next;
                    head.last = null;
                    node.next = null;
                    node.last = null;
                    addNode(node);
                }else {
                    Node<V> LastNode = node.last;
                    Node<V> NextNode = node.next;
                    LastNode.next = NextNode;
                    NextNode.last = LastNode;
                    node.last = null;
                    node.next = null;
                    addNode(node);
                }
            }
    }

    public class MyCache<K, V>{
        HashMap<K,Node<V>> KeyValueMap ;      //这里面存的必须是node节点类型，node其实存储的是地址，要是直接存value，然后在链表中删除操作的时候利用和这个value新new个node，在链表中就找不到了
        HashMap<Node<V>, K> ValueKeyMap ;
        private int capacity;
        NodeDoubleLinkedList<V> linkedList;

        public MyCache(int capacity){
            this.capacity = capacity;
            KeyValueMap = new HashMap<>();
            ValueKeyMap = new HashMap<>();
            linkedList = new NodeDoubleLinkedList<>();
        }

        public V get(K key){
            if (!KeyValueMap.containsKey(key)){
                return null;
            }else {
                Node<V> node = KeyValueMap.get(key);
                linkedList.moveNodeToTail(node);
                return node.value;
            }
        }

        public void set(K key, V value){
            if (KeyValueMap.containsKey(key)){
                Node<V> node = KeyValueMap.get(key);       //这个地方存的是地址，所以这个node和双向链表中的node是一个，也指向上一个下一个的指针，
                node.value = value;
                linkedList.moveNodeToTail(node);
            }else {
                Node<V> node = new Node<>(value);
                KeyValueMap.put(key,node);
                ValueKeyMap.put(node, key);
                linkedList.addNode(node);
                if (KeyValueMap.size() == capacity +1){
                    removeMostUnUsedCache();
                }
            }
        }

        private void removeMostUnUsedCache(){
            Node<V> removeNode = linkedList.removeHeadNode();    //删除的节点
            K removeKey = ValueKeyMap.get(removeNode);
            ValueKeyMap.remove(removeNode);
            KeyValueMap.remove(removeKey);
        }
    }
}
