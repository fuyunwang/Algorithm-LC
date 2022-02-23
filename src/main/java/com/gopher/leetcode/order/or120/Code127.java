package com.gopher.leetcode.order.or120;

import java.util.*;

/**
 * @Title Code127
 * @Author fyw
 * @Date 2022/2/18 20:23
 * @Description: 单词接龙
 */
public class Code127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 预处理，转换过程的单词必须都在wordList中出现，所以进行保存
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        dict.remove(beginWord);
        // 对当前word词汇进行变换
        int wordLen = beginWord.length();
        boolean flag=false; // 标记是否能够转换到最后结果
        int step = 1;       // 宽搜记录最小层数，即最短路径
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 一层的变换
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] charArray = currWord.toCharArray();
                // 一层变换可以有26种情况，当然有些不满足条件的要筛除
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;   // 每次变换一个单词
                        String nextWord = String.valueOf(charArray);
                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        if (nextWord.equals(endWord)){
                            flag=true;
                            break;
                        }
                        dict.remove(nextWord);  // 不重复
                        queue.offer(nextWord);
                    }
                    charArray[j] = origin;
                }
            }
            step++;
            if (flag){
                break;
            }
        }
        return flag?step:0;
    }
}
