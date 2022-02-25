package com.gopher.leetcode.order.or700;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code748
 * @Author fyw
 * @Date 2022/2/9 14:41
 * @Description: 最短补全词
 */
public class Code748 {
    public boolean check(Map<Character, Integer> a, Map<Character, Integer> b) {
        for (Character key : b.keySet()) {
            if (!a.containsKey(key) || a.get(key) < b.get(key)) {
                return false;
            }
        }
        return true;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                cnt.put(Character.toLowerCase(c), cnt.getOrDefault(Character.toLowerCase(c), 0) + 1);
            }
        }
        String res = "";
        for (String word : words) {
            Map<Character, Integer> a = new HashMap<>();
            for (char c : word.toCharArray()) {
                a.put(Character.toLowerCase(c), a.getOrDefault(Character.toLowerCase(c), 0) + 1);
            }
            if (check(a, cnt) && (res.length() == 0 || res.length() > word.length())) {
                res = word;
            }
        }
        return res;
    }

}
