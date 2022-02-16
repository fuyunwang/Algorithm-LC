package com.gopher.leetcode.order.or200;

/**
 * @Title Code208
 * @Author fyw
 * @Date 2022/2/9 13:51
 * @Description: 实现前缀树
 */
public class Code208 {
    class Trie {

        private TrieNode root;
        private class TrieNode {
            TrieNode[] next;
            boolean end;

            public TrieNode() {
                next = new TrieNode[26];
                end = false;
            }
        }

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char chr : word.toCharArray()) {
                int idx = chr - 'a';
                if (cur.next[idx] == null) cur.next[idx] = new TrieNode();
                cur = cur.next[idx];
            }
            cur.end = true;
        }


        public boolean search(String word) {
            TrieNode cur = root;
            for (char chr : word.toCharArray()) {
                int idx = chr - 'a';
                if (cur.next[idx] == null) return false;
                cur = cur.next[idx];
            }
            return cur.end;
        }


        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (char chr : prefix.toCharArray()) {
                int idx = chr - 'a';
                if (cur.next[idx] == null) return false;
                cur = cur.next[idx];
            }
            return true;
        }



    }

}
