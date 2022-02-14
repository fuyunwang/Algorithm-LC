package com.gopher.leetcode.backtrack;

import com.gopher.leetcode.tree.TreeNode;

import java.util.*;

/**
 * @Title BacktrackTemplate5
 * @Author fyw
 * @Date 2022/2/9 12:30
 * @Description: 电话号码的字母组合、不同的搜索二叉树、Code491递增子序列、Code93复原IP地址、Code1863
 */
public class BacktrackTemplate5 {
    class Code17{
        List<String> res=new LinkedList<>();
        HashMap<String,String> map = new HashMap<String,String>()
        {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };
        public List<String> letterCombinations(String digits) {
            if (digits==null||digits.length()<1)
                return Collections.emptyList();
            backtrack(digits,"",0);
            return res;
        }

        public void backtrack(String digits,String state,int start){
            if (start==digits.length()){
                res.add(state);
                return;
            }
            String current=map.get(digits.substring(start,start+1));
            for (int i = 0; i < current.length(); i++) {
                backtrack(digits,state+current.charAt(i),start+1);
            }
        }
    }
    class Code95{
        public List<TreeNode> generateTrees(int n) {
            if (n==0)
                return new ArrayList<>();
            return dfs(1,n);
        }
        List<TreeNode> dfs(int l,int r){
            List<TreeNode> list=new ArrayList<>();
            if (l>r){
                list.add(null);
                return list;
            }
            for (int i = l; i <= r; i++) {

                List<TreeNode> lefts=dfs(l,i-1);
                List<TreeNode> rights=dfs(i+1,r);
                for (TreeNode left:lefts){
                    for (TreeNode right:rights){
                        TreeNode root=new TreeNode(i);
                        root.left=left;
                        root.right=right;
                        list.add(root);
                    }
                }
            }
            return list;
        }
    }
}
