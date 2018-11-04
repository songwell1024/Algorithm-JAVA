package AdvancedDemo02;

import java.util.HashMap;

/**
 * 一个内存结构，按照访问的次数进行删除
 * 就是这个内存结构有一定的大小，当现在内存中的东西满了之后需要添加新的东西
 * 就需要删除原先内存中的一个元素
 * 删除的话删除那个访问次数最少的元素
 * 要是有多个访问次数一样的元素的话就删除那个最久远访问的元素
 * 并且get和set时间复杂度O（1）
 * @author WilsonSong
 * @date 2018/11/4/004
 */
public class LFU {

    private class Node{
        public Integer key;
        public Integer value;
        public Integer times;
        public Node up;
        public Node down;

        public Node(int key, int value, int times){
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }

    public class LFUCache{

        private class NodeList{
            public Node head;
            public Node tail;
            public NodeList next;
            public NodeList last;

            public NodeList(Node node){
                this.head = node;
                this.tail = node;
            }

            public void addNodeFromHead(Node newHead){
                if (head == null){
                    head = newHead;
                }else {
                    newHead.down = head;
                    head.up = newHead;
                    head = newHead;
                }
            }

            public boolean isEmpty(){
                return head == null;
            }

            public void deleteNode(Node node){
                if (head == null){
                    return;
                }
                if (head == tail){
                    head = null;
                    tail = null;
                }else {
                    if (head == node){
                        head = node.down;
                        head.up = null;
                    }else if (tail == node){
                        tail = tail.up;
                        tail.down = null;
                    }else {
                        node.down.up = node.up;
                        node.up.down = node.down;
                    }
                }
                node.up = null;
                node.down = null;
            }
        }

        public int capacity;
        public int size;
        public HashMap<Integer, Node> records;     //key -> node
        public HashMap<Node, NodeList> heads;     //每个节点所在的链表
        public NodeList headList;     //头结点下的链表。其实就是第一个竖着的链表

        public LFUCache(int capacity){
            this.capacity = capacity;
            this.size = 0;
            headList = null;
            records = new HashMap<>();
            heads = new HashMap<>();
        }

        public void set(int key, int value){
            if (records.containsKey(key)){
                Node node = records.get(key);
                node.value = value;
                node.times ++;
                NodeList curList = heads.get(node);
                move(node, curList);
            }else {
                if (size == capacity){
                    Node node = headList.tail;
                    headList.deleteNode(node);
                    modify(headList);
                    records.remove(node.key);
                    heads.remove(node);
                    size --;
                }
                Node node = new Node(key, value, 1);
                if (headList == null){
                    headList = new NodeList(node);
                }else {
                    if (headList.head.times.equals(node.times)){
                        headList.addNodeFromHead(node);
                    }else {
                        NodeList newList = new NodeList(node);
                        newList.next = headList;
                        headList.last = newList;
                        headList = newList;
                    }
                }
                records.put(key, node);
                heads.put(node, headList);
                size ++;
            }
        }

        public void move(Node node, NodeList oldList){
            oldList.deleteNode(node);
            NodeList preList = modify(oldList) ? oldList.last : oldList;
            NodeList nextList = oldList.next;
            if (nextList == null){
                NodeList newList = new NodeList(node);
                if (preList != null){
                    preList.last = newList;
                }
                newList.last = preList;
                if (headList == null){
                    headList = newList;
                }
            }else {
                if (nextList.head.times.equals(node.times)){
                    nextList.addNodeFromHead(node);
                    heads.put(node, nextList);
                }else {
                    NodeList newList = new NodeList(node);
                    if (preList != null){
                        preList.next = newList;
                    }
                    newList.last = preList;
                    newList.next = nextList;
                    nextList.last = newList;
                    if (headList == nextList){
                        headList = newList;
                    }
                    heads.put(node, newList);
                }
            }
        }

        //链表进行调整
        public boolean modify(NodeList list){
            if (list.isEmpty()){
                if (headList == list){
                    headList = headList.next;
                    if (headList != null){
                        headList.last = null;
                    }
                }else {
                    list.last.next = list.next;
                    if (list.next != null){
                        list.next.last = list.last;
                    }
                }
                return true;
            }
            return false;
        }

        public int get(int key){
            if (!records.containsKey(key)){
                return -1;
            }
            Node node = records.get(key);
            NodeList curList = heads.get(node);
            node.times ++;
            move(node, curList);
            return node.value;
        }
    }

}
