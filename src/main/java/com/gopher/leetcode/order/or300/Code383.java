package com.gopher.leetcode.order.or300;

/**
 * @Title Code383
 * @Author fyw
 * @Date 2022/2/9 13:55
 * @Description: 赎金信
 */
public class Code383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (cnt[c - 'a'] <= 0) {
                return false;
            }
            cnt[c - 'a']--;
        }
        return true;
    }
}
