package com.gopher.leetcode.order.or200;

/**
 * @Title Code211
 * @Author fyw
 * @Date 2022/2/18 14:15
 * @Description: 添加与搜索单词
 * 前缀树应用，类似Code208，算是208的变种
 */
public class Code211 {
    class WordDictionary {
        class TrieNode{
            TrieNode[] next;
            boolean end;

            public TrieNode() {
                next=new TrieNode[26];
                end=false;
            }
        }
        TrieNode root;
        public WordDictionary() {
            root=new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur=root;
            for (int i = 0; i < word.length(); i++) {
                int index=word.charAt(i)-'a';
                if (cur.next[index]==null) cur.next[index]=new TrieNode();
                cur=cur.next[index];
            }
            cur.end=true;
        }

        public boolean search(String word) {
            return dfs(word,root,0);
        }
        boolean dfs(String word,TrieNode node,int index){   // 查找字符串
            int n=word.length();
            if (index==n)
                return node.end;
            char c = word.charAt(index);
            if (c=='.'){
                for (int i = 0; i < 26; i++) {
                    if (node.next[i]!=null&&dfs(word,node.next[i],index+1)) return true;
                }
                return false;
            }else{
                int curIndex=c-'a';
                if (node.next[curIndex]==null) return false;
                return dfs(word,node.next[curIndex],index+1);
            }

        }
    }
}
