package BasicExample.BasicExamples07;

/**
 * 字典树
 * @author WilsonSong
 * @date 2018/12/13/013
 */
public class TrieTree {

    public class Node{
        public int path;
        public int end;
        public Node[] nexts;

        public Node(){
            this.path = 0;
            this.end = 0;
            this.nexts = new Node[26];
        }
    }

    private Node root;
    public TrieTree(){
        root = new Node();
    }

    public void insert(String word){
        if (word == null){
            return;
        }

        char[] words = word.toCharArray();
        Node node = root;
        int index;
        for (char c: words){
            index = c - 'a';
            if (node.nexts[index] == null){
                node.nexts[index] = new Node();
            }
            node = node.nexts[index];
            node.path ++;
        }
        node.end++;
    }

    public void delete(String word){
        if (word == null){
            return;
        }

        char[] words = word.toCharArray();
        Node node = root;
        int index;
        for (char c : words){
            index =c - 'a';
            if (node.nexts[index] != null){
                node = node.nexts[index];
                node.path --;
            }else {
                throw new IllegalArgumentException("Error");
            }
            node.end--;
        }
    }

    public int search(String word){
        if (word == null){
            return 0;
        }

        char[] words = word.toCharArray();
        int index;
        Node node = root;
        for (char c : words){
            index = c - 'a';
            if (node.nexts[index] == null){
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;

    }

    public int prefixNum(String word){
        if (word == null){
            return 0;
        }
        char[] words = word.toCharArray();
        int index;
        Node node = root;
        int res = Integer.MAX_VALUE;
        for (char c : words){
            index = c - 'a';
            if (node.nexts[index] == null){
                return 0;
            }
            node = node.nexts[index];
            res = Math.min(node.path, res);
        }
        return Math.min(node.path,res);
    }

}
