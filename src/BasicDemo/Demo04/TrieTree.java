package BasicDemo.Demo04;

/**
 * 思路就是一个字典树，设置存储26个字母的节点，其实是节点间的路径存储的字母
 * 然后每个及节点还存储path变量记录该节点被走过几次，
 * 然后还有一个end节点，表示是不是一个单词的结尾，还表明有几个单词是以这个节点结尾
 * @author WilsonSong
 * @date 2018/9/13/013
 */
public class TrieTree {

    private static class Node{
        public int path;
        public int end;
        public Node[] nexts;

        public Node(){
            this.path = 0;    //有多少个单词走过这个节点
            this.end = 0;     //有多少个单词是以这个节点为结尾
            nexts = new Node[26];    //26个字母
        }
    }

    public static class Trie{
       private Node root;

       public Trie(){
           root = new Node();
       }

       public void insert(String str){
           if (str == null){
               return;
           }
           char[] word = str.toCharArray();
           int index = 0;
           Node node = root;
           for (int i =0; i < word.length; i++){
               index = word[i] - 'a';    //这个字母应该放在第几个节点上
               if (node.nexts[index] == null){
                   node.nexts[index] = new Node();
               }
               node = node.nexts[index];  //不为空就向下走
               node.path ++;
           }
           node.end ++;
       }
        public void delete(String str){
            if (str == null){
                return;
            }
            char[] word = str.toCharArray();
            int index = 0;
            Node node = root;
            for (int i =0; i < word.length; i++){
                index =  word[i] - 'a';
                if (node.nexts[index] == null){
                    return;
                }else {
                    node.nexts[index].path --;
                    if (node.nexts[index].path== 0 ){
                        node.nexts[index] = null;    //只要有一个节点走过的次数次数变为0，其下面的节点都是这个单词的节点
                        return;
                    }
                    node = node.nexts[index];
                }
            }
            node.end --;
        }

        //查询一个单词
        public int search(String str){
           if (str == null){
               return 0;
           }
           char[] word = str.toCharArray();
           int index;
           Node node = root;
           for (int i = 0; i< word.length; i++){
               index = word[i] - 'a';

               if (node.nexts[index] == null) {
                   return 0;
               }else {
                   node = node.nexts[index];
               }
           }
           return node.end;
        }

        //前缀数量
        public int prefixNumber(String pre){
           if (pre == null){
               return 0;
           }
           char[] word = pre.toCharArray();
           int index;
           Node node = root;
           for (int i = 0; i < word.length; i++){
               index = word[i] - 'a';
               if (node.nexts[index] == null){
                   return 0;
               }
               node = node.nexts[index];
           }
           return node.path;
        }
    }



}
