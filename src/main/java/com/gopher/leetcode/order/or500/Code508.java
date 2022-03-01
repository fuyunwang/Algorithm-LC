package com.gopher.leetcode.order.or500;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title Code508
 * @Author fyw
 * @Date 2022/2/17 19:26
 * @Description: 出现次数最多的子树元素和
 */
public class Code508 {
    HashMap<Integer,Integer> count=new HashMap<>();    // 记录每一个节点出现的次数
    List<Integer> list=new ArrayList<>();              // 记录出现次数最多的子树和的值
    int maxCount=0;                                     // 维护最多的次数
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int size=list.size();
        int[] res=new int[size];
        for (int i = 0; i < size; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
    int dfs(TreeNode root){     // 返回以当前root为根节点的子树的和，包含当前节点的值
        if (root==null){
            return 0;
        }
        int sum=root.val+dfs(root.left)+dfs(root.right);
        count.put(sum,count.getOrDefault(sum,0)+1);
        if (count.get(sum)>maxCount){
            list=new ArrayList<>();
            list.add(sum);
            maxCount=count.get(sum);
        }else if (count.get(sum)==maxCount){
            list.add(sum);
        }
        // 进行业务逻辑
//        if (!count.containsKey(sum)&&maxCount==0){
//            count.put(sum,1);
//            maxCount=1;
//            list.add(sum);
//        }else{
//            if (count.containsKey(sum)){
//                int curCount=count.get(sum);
//                curCount++;// 当前的值加一
//                count.put(sum,curCount);
//                if (curCount>maxCount){
//                    // 更新
//                    maxCount=curCount;
//                    list=new ArrayList<>();
//                    list.add(sum);
//                }
//            }else{
//                if (maxCount==1){
//                    list.add(sum);
//                    count.put(sum,1);
//                }
//            }
//        }
        return sum;
    }
}
