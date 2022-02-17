package com.gopher.swordoffer;

import java.util.Stack;

/**
 * @Title SwordOffer33
 * @Author fyw
 * @Date 2022/2/2 13:58
 * @Description: 验证后序遍历二叉搜索树，类似Code255
 */
public class SwordOffer33 {
    public boolean verifyPostorder(int[] postorder) {
        // 维护一个单调递增的栈，默认参数顺序是 左右根，使用根右左的逆序方式遍历
        Stack<Integer> stack=new Stack<>();
        int max=Integer.MAX_VALUE;
        for (int i = postorder.length-1; i >= 0 ; i--) {
            if (postorder[i]>max){
                // 这里比较的是左子节点与左子节点的根节点比较的关系
                return false;
            }
            while (!stack.isEmpty()&&postorder[i]<stack.peek()){
                // 说明右节点遍历完刚开始左子树节点遍历
                max=stack.pop();
            }
            stack.push(postorder[i]);// 如果是右子树直接加入了，如果是左子树那么栈中当前左子树节点的根和整个右子树已经弹出了
        }
        return true;
    }
}
