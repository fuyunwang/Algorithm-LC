package com.gopher.leetcode.order.or120;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code139
 * @Author fyw
 * @Date 2022/2/8 21:19
 * @Description: 单词拆分
 * 一个字符串有n个字母即n-1个空隙，有2^(n-1)种分割情况
 * 秦九韶算法
 */
public class Code139_140 {
    // 状态表示: f[i]表示s[1~i]所有的合法划分方案，属性是否为空
    // 状态计算，f[1~i] 、f[2~i]等划分情况，看下是否至少有一个子集非空
    public boolean wordBreak(String s, List<String> wordDict) {

        int n=s.length();
        s=" "+s;
        boolean[] f = new boolean[n + 10];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                String t = s.substring(j,i + 1);
                if(wordDict.contains(t)) f[i] = f[j - 1] || f[i]; // 可以选可以不选
            }
        }
        return f[n];
    }

    class Code140{
        // 返回所有划分方案
        List<String> ans = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        int n;
        boolean[] f;
        void dfs(String s, int u, String path)
        {
            if(u == n + 1)
            {
                ans.add(path);
                return ;
            }
            for(int i = u;i <= n;i ++)
            {
                String t = s.substring(u, i + 1);
                if(f[i] && set.contains(t))
                {
                    String next = path.length() == 0 ? t : path + " " + t ;
                    dfs(s, i + 1, next);
                }
            }
        }
        public List<String> wordBreak(String s, List<String> wordDict) {
            //初始化
            for(String t : wordDict)    set.add(t);
            n = s.length();
            s = " " + s;
            f = new boolean[n + 10];
            f[0] = true;

            for(int i = 1;i <= n;i ++) {
                for(int j = 1;j <= i;j ++) {
                    String t = s.substring(j,i + 1);
                    if(wordDict.contains(t)) f[i] = f[j - 1] || f[i];
                }
            }
            if(!f[n]) return ans;


            dfs(s, 1, "");
            return ans;
        }

    }
}
