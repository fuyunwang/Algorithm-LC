package com.fuyunwang.bilibili;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title SerialTemplate
 * @Author fyw
 * @Date 2022/5/8 1:16
 * @Description: 与序列化反序列化、基于遍历构造二叉树相关的题目
 */
public class SerialTemplate {
    static class Code105{

    }
    static class Code106{

    }
    static class Code889{

    }

    static class Code606{
        // 类似括号生成
    }
    static class Code988{
        // 类似括号生成
    }

    static class Code297{

    }

    static class Code449{
        public class Codec {
            public String serialize(TreeNode root) {
                if(root==null){
                    return "#";
                }
                return root.val+","+serialize(root.left)+","+serialize(root.right);
            }
            public TreeNode deserialize(String data) {
                String[] s1 = data.split(",");
                List<Integer> s = new ArrayList<Integer>();
                for(int i = 0;i < s1.length;i ++)
                {
                    if(s1[i].equals("#")) continue;
                    s.add(Integer.parseInt(s1[i]));
                }
                return dfs(s, 0, s.size() - 1);
            }

            TreeNode dfs(List<Integer> s, int l, int r) {
                if(l > r) return null;
                //选取第一个为根结点
                TreeNode root = new TreeNode(s.get(l));
                //找到第一个比root.val大的元素的位置
                int idx = l + 1, p = s.get(l);
                while(idx <= r && s.get(idx) < p) idx ++;
                root.left = dfs(s, l + 1, idx - 1);
                root.right = dfs(s, idx, r);
                return root;
            }

        }
    }

    static class Code331{

    }

    static class Code652{
        List<TreeNode> res=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            dfs(root);
            return res;
        }
        String dfs(TreeNode root){
            if (root==null){
                return "#";
            }
            String path=String.valueOf(root.val)+",";
            path+=dfs(root.left)+",";
            path+=dfs(root.right);
            map.put(path,map.getOrDefault(path,0)+1);
            if (map.get(path)==2){
                res.add(root);
            }
            return path;
        }
    }

    static class Code655{

    }

    static class Code971{

    }

    static class Code1028{

    }
}
