package com.gopher.leetcode.types.structure.trie;

/**
 * @Title TrieTemplate
 * @Author fyw
 * @Date 2022-03-08 17:04
 * @Description
 */
public class TrieTemplate {
    static class Code745{
        class WordFilter {
            class Trie {
                Trie[] children = new Trie[27];
                int idx = -1;
            }

            Trie head = new Trie();

            public void insert(String s, int id) {
                Trie p = head;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == '#') {
                        if (p.children[26] == null) {
                            p.children[26] = new Trie();
                        }
                        p = p.children[26];
                    } else {
                        if (p.children[c - 'a'] == null) {
                            p.children[c - 'a'] = new Trie();
                        }
                        p = p.children[c - 'a'];
                    }
                    p.idx = id;
                }
            }

            public int query(String s) {
                Trie p = head;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '#') {
                        if (p.children[26] == null) {
                            return -1;
                        } else {
                            p = p.children[26];
                        }
                    } else {
                        if (p.children[s.charAt(i) - 'a'] == null) {
                            return -1;
                        } else {
                            p = p.children[s.charAt(i) - 'a'];
                        }
                    }
                }
                return p.idx;
            }

            public WordFilter(String[] words) {
                for (int i = 0; i < words.length; i++) {
                    for (int j = 0; j <= words[i].length(); j++) {
                        insert(words[i].substring(words[i].length() - j, words[i].length()) + "#" + words[i], i);
                    }
                }
            }

            public int f(String prefix, String suffix) {
                return query(suffix + "#" + prefix);
            }
        }

    }
}
