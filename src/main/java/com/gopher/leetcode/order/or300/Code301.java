package com.gopher.leetcode.order.or300;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code301
 * @Author fyw
 * @Date 2022/2/9 13:29
 * @Description:
 */
public class Code301 {
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        // 统计要删除多少左括号和右括号
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') l++;
            else if (s.charAt(i) == ')') {
                if (l == 0) r++;
                else l--;
            }
        }
        dfs(s.toCharArray(), 0, 0, l, r);
        return ans;
    }
    // cnt表示左括号减去右括号的数量。
    private void dfs(char[] s, int u, int cnt, int l, int r) {
        if (u == s.length) {
            // 搜到字符串结尾且左右括号数量相同
            if (cnt == 0) ans.add(path.toString());
            return;
        }
        // 输入可能包含了除 ( 和 ) 以外的字符。
        if (s[u] != '(' && s[u] != ')') {
            path.append(s[u]);
            dfs(s, u + 1, cnt, l, r);
            path.deleteCharAt(path.length() - 1);
        } else if(s[u] == '(') {
            int k = u;
            while (k < s.length && s[k] == '(') k++;
            // 连续有k-u个左括号
            l -= k - u;
            // 依次枚举删掉k-u个到0个左括号，
            for (int i = k - u; i >= 0; i--) {
                // 如果删掉的左括号数量没超过l的限制
                if (l >= 0) dfs(s, k, cnt, l, r);
                path.append('(');
                cnt++;
                l++;
            }
            for (int i = k - u; i >= 0; i--) {
                path.deleteCharAt(path.length() - 1);
                cnt--;
                l--;
            }
        } else if (s[u] == ')') {
            int k = u;
            while (k < s.length && s[k] == ')') k++;
            r -= k - u;
            for (int i = k - u; i >= 0; i--) {
                // cnt不小于0是保证左括号不少于右括号
                if (cnt >= 0 && r >= 0) dfs(s, k, cnt, l, r);
                path.append(')');
                cnt--;
                r++;
            }
            for (int i = k - u; i >= 0; i--) {
                path.deleteCharAt(path.length() - 1);
                cnt++;
                r--;
            }
        }
    }

}
