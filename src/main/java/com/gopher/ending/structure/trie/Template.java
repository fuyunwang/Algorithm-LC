package com.gopher.ending.structure.trie;

/**
 * @Title Template
 * @Author fyw
 * @Date 2022/3/12 20:58
 * @Description:
 */
public class Template {
    class Code726{
        class Trie{
            Trie[] children = new Trie[26];
            int idx=-1;
        }
        Trie head;
        public void insert(String str, int id) {
            Trie root = head;
            for (char ch : str.toCharArray()) {
                int cc = ch - 'a';
                if (root.children[cc] == null) {
                    root.children[cc] = new Trie();
                }
                root = root.children[cc];
            }
            root.idx=id;
        }

        public int[] dfs(Trie trie, int len) {
            int[] res = { trie.idx,len};
            for (int i = 0; i < 26; i++) {
                if (trie.children[i] != null && trie.children[i].idx != -1) {
                    int[] tmp = dfs(trie.children[i], len + 1);
                    if (res[1] < tmp[1]) {
                        res = tmp;
                    }
                }
            }
            return res;
        }

        public String longestWord(String[] words) {
            head = new Trie();
            for (int i = 0; i < words.length; i++) {
                insert(words[i],i);
            }
            int[] res = dfs(head, 0);
            if (res[0] == -1) {
                return "";
            }
            return words[res[0]];
        }
    }
}
