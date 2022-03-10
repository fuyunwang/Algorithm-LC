package com.gopher.leetcode.types.backtrack;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.Stack;

/**
 * @Title BacktrackTemplate3
 * @Author fyw
 * @Date 2022/2/7 19:17
 * @Description: 含括号的递归
 */
public class BacktrackTemplate3 {
    static class Code1106{
        String str;
        int ptr;
        public boolean parseBoolExpr(String expression) {
            ptr=0;
            str=expression;
            return dfs();
        }
        boolean dfs(){
            if (str.charAt(ptr)=='f'){
                ptr++;
                return false;
            }
            if (str.charAt(ptr)=='t'){
                ptr++;
                return true;
            }
            char op=str.charAt(ptr);
            ptr+=2;
            boolean res=true;
            if (op=='|') res=false;
            while (str.charAt(ptr)!=')'){
                if (str.charAt(ptr)==','){
                    ptr++;
                }else{
                    boolean child=dfs();
                    if (op=='|') res|=child;
                    else res&=child;
                }
            }
            ptr++;
            if(op=='!')
                res=!res;
            return res;
        }
    }

    static class Code1096{
        // 花括号展开
    }
    static class Code772{
        int ptr = 0;
        public int calculate(String s) {
            Stack<Integer> nums = new Stack<>();
            char sign = '+';
            int num = 0;
            while (ptr <= s.length()) {  // ptr == s.length() 意味着把剩余未放入栈的数字进行处理
                if (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
                    num = num*10 + s.charAt(ptr) - '0';
                    ptr++;
                } else if (ptr < s.length() && s.charAt(ptr) == '(') {
                    ptr++;
                    num = calculate(s);
                } else {
                    switch (sign) {
                        case '+':
                            nums.push(num);
                            break;
                        case '-':
                            nums.push(-num);
                            break;
                        case '*':
                            nums.push(nums.pop() * num);
                            break;
                        case '/':
                            nums.push(nums.pop() / num);
                            break;
                    }
                    num = 0;
                    if (ptr < s.length() && s.charAt(ptr) == ')') {
                        ptr++;
                        break;
                    }
                    if (ptr < s.length()) sign = s.charAt(ptr);
                    ptr++;
                }
            }
            int sum = 0;
            while (!nums.isEmpty()) sum += nums.pop();
            return sum;
        }
    }
    static class Code988{
        String ans;
        // 字符串拼接
        public String smallestFromLeaf(TreeNode root) {
            dfs(root,new StringBuilder());
            return ans;
        }
        void dfs(TreeNode root,StringBuilder sb){
            if (root==null)
                return;
            sb.append((char)(root.val+'a'));
            if (root.left==null&&root.right==null){
                sb.reverse();
                if (ans==null||sb.toString().compareTo(ans)<0) ans=sb.toString();
                sb.reverse();
            }else{
                dfs(root.left,new StringBuilder(sb));
                dfs(root.right,new StringBuilder(sb));
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
