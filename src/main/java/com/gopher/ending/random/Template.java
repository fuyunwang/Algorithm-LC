package com.gopher.ending.random;

import java.util.*;

/**
 * @Title Template
 * @Author fyw
 * @Date 2022-03-12 13:52
 * @Description 带有概率随机性质的题目
 */
public class Template {

    static class Code710{
        // 将黑名单中的数全部移到尾部
        class Solution {
            int len,n;
            HashMap<Integer,Integer> map = new HashMap<>();
            public Solution(int N, int[] blacklist) {
                HashSet<Integer> set = new HashSet<>();
                this.n = N;
                len = blacklist.length;
                for(int i=N-len;i<=N-1;i++) set.add(i);
                for(int i:blacklist)
                    if(set.contains(i)) set.remove(i);
                Iterator<Integer> iterator = set.iterator();
                for(int i:blacklist)
                    if(i<N-len) map.put(i,iterator.next());
            }

            public int pick() {
                int k = new Random().nextInt(n-len);
                if(map.containsKey(k)) return map.get(k);
                return k;
            }
        }
    }

}
