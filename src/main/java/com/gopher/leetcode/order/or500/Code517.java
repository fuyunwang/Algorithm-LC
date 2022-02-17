package com.gopher.leetcode.order.or500;

/**
 * @Title Code517
 * @Author fyw
 * @Date 2022/2/8 21:57
 * @Description: 超级洗衣机
 */
public class Code517 {
    public int findMinMoves(int[] machines) {
        if (machines==null||machines.length==0)
            return -1;
        int sum=0;
        for (int i = 0; i < machines.length; i++) {
            sum+=machines[i];
        }
        if (sum%machines.length!=0){
            return -1;
        }
        int avg=sum/machines.length;// 计算每台机器平均需要的衣服数量
        int leftSum=0;      // 计算左侧的状态，是需要收入衣服还是支出衣服
        int res=0;
        for (int i = 0; i < machines.length; i++) {
            int leftRest=leftSum-i*avg;
            int rightRest=(sum-leftSum-machines[i])-(machines.length-i-1)*avg;
            if (leftRest<0&&rightRest<0){
                res=Math.max(res,Math.abs(leftRest)+Math.abs(rightRest));
            }else{
                res=Math.max(res,Math.max(Math.abs(leftRest),Math.abs(rightRest)));
            }


            leftSum+=machines[i];
        }
        return res;
    }
}
