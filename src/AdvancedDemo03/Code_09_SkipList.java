package AdvancedDemo03;

import java.util.ArrayList;

/**
 * 跳表结构的实现
 * @author WilsonSong
 * @date 2018/11/8/008
 */
public class Code_09_SkipList {

    public class SkipListNode{
        public Integer value;
        public ArrayList<SkipListNode> nextNodes;

        public SkipListNode(Integer value){
            this.value = value;
            nextNodes = new ArrayList<>();
        }
    }

    public class SkipList{
        private SkipListNode head;     //系统最小
        private int maxLevel;          //系统最小的最大层数
        private int size;
        private final double PROBABLITY = 0.5;

        public SkipList(){
            head = new SkipListNode(null);
            maxLevel = 0;
            size = 0;
            head.nextNodes.add(null);
        }

        public SkipListNode getHead() {
            return head;
        }

        public void add(Integer NewValue){
            if (!contains(NewValue)){
                size ++;
                int level = 0;
                while (Math.random() < PROBABLITY){
                    level ++;
                }
                while (level < maxLevel){
                    head.nextNodes.add(null);
                    maxLevel ++;
                }

                SkipListNode newNode = new SkipListNode(NewValue);
                SkipListNode curNode = head;
                do {
                    curNode = findNext(NewValue, curNode, level);
                    newNode.nextNodes.add(0, curNode.nextNodes.get(level));
                    curNode.nextNodes.set(level, newNode);
                }while (level-- >0);
            }
        }


        public boolean contains(Integer value){
            SkipListNode node = find(value);
            return node != null && node.value != null && equalTo(node.value, value);
        }

        private SkipListNode find(Integer value){
            return find(value, head, maxLevel);
        }

        private SkipListNode find(Integer value,SkipListNode current, int level){
            do {
                current = findNext(value, current, level);
            }while (level-- >0);
            return current;
        }

        private SkipListNode findNext(Integer value, SkipListNode current, int level){
            SkipListNode next = current.nextNodes.get(level);
            while (next != null){
                Integer e = next.value;
                if (lessThan(e, value)){
                    break;
                }
                current = next;
            }
            return current;
        }

        public void delete(Integer deleteValue){
            if (contains(deleteValue)){
                SkipListNode deleteNode = find(deleteValue);
                size --;
                int level = maxLevel;
                SkipListNode current = head;
                do {
                    current = findNext(deleteNode.value, current,level);
                    if (deleteNode.nextNodes.size() > level){
                        current.nextNodes.set(level,deleteNode.nextNodes.get(level));
                    }
                }while (level-- >0);
            }
        }

        private boolean lessThan(Integer a, Integer b){
            return a.compareTo(b) == -1;
        }

        private boolean equalTo(Integer a, Integer b){
            return a.compareTo(b) == 0;
        }
    }






}
