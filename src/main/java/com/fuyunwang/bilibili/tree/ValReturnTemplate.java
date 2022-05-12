package com.fuyunwang.bilibili.tree;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title ValReturnTemplate
 * @Author fyw
 * @Date 2022/5/8 1:19
 * @Description:
 */
public class ValReturnTemplate {
    static class Code104_110_111{

    }
    static class Code543{
        // 二叉树直径
        int res=0;
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return res;
        }
        int dfs(TreeNode root){
            if (root==null)
                return 0;
            int l=dfs(root.left);
            int r=dfs(root.right);
            res=Math.max(res,l+r);
            return Math.max(l,r)+1;
        }
    }

    static class Code687{

    }
    static class Code404{
        public int sumOfLeftLeaves(TreeNode root) {
            if (root==null)
                return 0;
            int res=0;
            res+=root.val;
            if (root.left!=null&&root.left.left==null&&root.left.right==null){
                return res;
            }else{
                res+=sumOfLeftLeaves(root.left);
                res+=sumOfLeftLeaves(root.right);
            }
            return res;
        }
    }
    static class Code124{

    }
    static class Code938{

    }

    static class Code129{

    }
    static class Code1022{

    }

    static class Code1026{
        // 节点与其祖先节点的最大差值
    }

    static class Code508{
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        int maxCount=0;
        public int[] findFrequentTreeSum(TreeNode root) {
            dfs(root);
            int[] res=new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i]=list.get(i);
            }
            return res;
        }
        int dfs(TreeNode root){
            if (root == null) {
                return 0;
            }
            int sum=root.val+dfs(root.left)+dfs(root.right);//得到子树和
            map.put(sum,map.getOrDefault(sum,0)+1);
            if (map.get(sum)>maxCount){
                list=new ArrayList<>();     // trick
                list.add(sum);
                maxCount=map.get(sum);
            }else if (maxCount==map.get(sum)){
                list.add(sum);
            }
            return sum;
        }
    }
}
