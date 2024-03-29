package com.gopher.leetcode.types.window;

import java.util.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-01 21:28
 * @Description 滑动窗口只考虑相关字符或者字符串的添加和删除
 */
public class Template1 {
    static class Code3{
        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> window=new HashMap<>();
            int left=0,right=0;
            int res=0;
            while (right<s.length()){
                char rc=s.charAt(right++);
                window.put(rc,window.getOrDefault(rc,0)+1);
                while (window.get(rc)>1){
                    char lc=s.charAt(left++);
                    window.put(lc,window.getOrDefault(lc,0)-1);
                }
                res=Math.max(res,right-left);
            }
            return res;
        }
    }
    static class Code30{
        public List<Integer> findSubstring(String s, String[] words) {
            if (words==null||words.length==0)
                return Collections.emptyList();
            // 注意这里是不需要顺序的，所以统计词频
            Map<String,Integer> freq=new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                freq.put(words[i],freq.getOrDefault(words[i],0)+1);
            }
            // 声明结果数组
            List<Integer> res=new ArrayList<>();
            // 开始枚举，注意n个相同长度的字符串的枚举范围
            int left=0;
            int n=words.length;
            int len=words[0].length();
            // 用于临时比较频次
            Map<String,Integer> window=new HashMap<>();
            while (left<=s.length()-n*len){
                window.clear();
                int count=0;    // 连续子串要持续比较，所以固定最左侧索引开始比较
                while (count<n){
                    String lWord=s.substring(left+len*count,left+len*(count+1));
                    if (freq.containsKey(lWord)){
                        window.put(lWord,window.getOrDefault(lWord,0)+1);
                        if (window.get(lWord).compareTo(freq.get(lWord))>0){
                            break;//此时说明freq对于一个单词频次还不够用
                        }
                    }else{
                        break;
                    }
                    count++;
                }
                if (count==n){
                    res.add(left);
                }
                left++;// 从下一个索引开始
            }

            return res;
        }
    }

    static class Code76{
        // 找到最小覆盖子串
        public String minWindow(String s, String t) {
            Map<Character,Integer> freq=new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i),0)+1);
            }
            int left=0,right=0;
            Map<Character,Integer> window=new HashMap<>();
            int size=0;// 记录不同字符的总个数
            // 声明结果
            int len=Integer.MAX_VALUE;
            int start=0;

            while (right<s.length()){
                char rc=s.charAt(right++);
                if (freq.containsKey(rc)){
                    window.put(rc,window.getOrDefault(rc,0)+1);
                    if (Objects.equals(window.get(rc),freq.get(rc))){
                        size++;
                    }
                }
                while (size==freq.size()){
                    if (right-left<len){
                        start=left;
                        len=right-left;
                    }
                    char lc=s.charAt(left++);
                    if (freq.containsKey(lc)){
                        if (Objects.equals(window.get(lc),freq.get(lc))){
                            size--;
                        }
                        window.put(lc,window.getOrDefault(lc,0)-1);
                    }
                }
            }
            return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
        }
    }

    static class Code128{


    }
    static class Code1004{
        /**
         * 给定一个二进制数组nums和一个整数k，如果可以翻转最多k个0，则返回数组中连续1的最大个数 。
         * 意思是窗口内最多容许指定数量的0，然后求连续1的最大窗口
         */
        public int longestOnes(int[] nums, int k) {
            int zero=0;
            int res=0;
            for (int i = 0, j=0; i < nums.length; i++) {
                if (nums[i]==0){
                    zero++;
                }
                while (zero>k){
                    // 收缩左端点
                    if (nums[j]==0){
                        zero--;
                    }
                    j++;
                }
                // 代码进行到这里说明[j,i]是一个合法的区间，求其长度
                res=Math.max(res,i-j+1);
            }
            return res;
        }
    }
    static class Code1984{
        // 学生分数的最小差值
        // 要想使每次计算的差值最小，每次取窗口内的值都应该尽可能接近
        public int minimumDifference(int[] nums, int k) {
            Arrays.sort(nums);
            int res=Integer.MAX_VALUE;
            // 固定长度的滑动窗口大小为k，确定每次的索引m和i
            for (int i = nums.length-1;i>=0; i--) {
                int m=i-k+1;
                if (m>=0&&m<nums.length){
                    if (res>nums[i]-nums[m]){
                        res=nums[i]-nums[m];
                    }
                }else if (m<0){
                    break;
                }
            }
            return res;
        }
    }

    static class Code992{
        public int subarraysWithKDistinct(int[] nums, int k) {
            Map<Integer, Integer> s1 = new HashMap<>(), s2 = new HashMap<>();
            int res = 0;
            for (int i = 0, j1 = 0, j2 = 0, cnt1 = 0, cnt2 = 0; i < nums.length; i++){
                if (s1.getOrDefault(nums[i], 0) == 0) cnt1++;   // 记录不同字符的种类数
                s1.put(nums[i], s1.getOrDefault(nums[i], 0) + 1);
                while (cnt1 > k){
                    s1.put(nums[j1], s1.get(nums[j1]) - 1);
                    if (s1.get(nums[j1]) == 0) cnt1 --;
                    j1++;
                }

                if (s2.getOrDefault(nums[i], 0) == 0) cnt2++;
                s2.put(nums[i], s2.getOrDefault(nums[i], 0) + 1);
                while (cnt2 > k-1){
                    s2.put(nums[j2], s2.get(nums[j2]) - 1);
                    if (s2.get(nums[j2]) == 0) cnt2 --;
                    j2++;
                }
                res += j2 - j1;
            }
            return res;
        }
    }

}
