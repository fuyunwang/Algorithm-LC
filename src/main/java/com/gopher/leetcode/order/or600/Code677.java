package com.gopher.leetcode.order.or600;

/**
 * @Title Code677
 * @Author fyw
 * @Date 2022/2/18 21:01
 * @Description:
 * 字典树
 */
public class Code677 {
    class MapSum {
        class TrieNode{
            TrieNode[] next;
            int val;

            public TrieNode() {
                next=new TrieNode[26];
                val=0;
            }
        }
        TrieNode root;
        public MapSum() {
            root=new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode cur=root;
            for (int i = 0; i < key.length(); i++) {
                int index=key.charAt(i)-'a';
                if (cur.next[index]==null) cur.next[index]=new TrieNode();
                cur=cur.next[index];
            }
            cur.val=val;
        }
        // 计算相同相同字符串前缀下面不同字符串对应值的和
        public int sum(String prefix) {
            TrieNode cur=root;
            for (int i = 0; i < prefix.length(); i++) {
                int index=prefix.charAt(i)-'a';
                if (cur.next[index]==null)
                    return 0;
                cur=cur.next[index];
            }
            return dfs(cur);
        }

        private int dfs(TrieNode node) {
            if (node==null){
                return 0;
            }
            int sum=node.val;
            for(TrieNode child:node.next){
                sum+=dfs(child);
            }
            return sum;
        }
    }
}
