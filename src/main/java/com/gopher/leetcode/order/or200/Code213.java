package com.gopher.leetcode.order.or200;

/**
 * @Title Code213
 * @Author fyw
 * @Date 2022/2/9 13:37
 * @Description: 打家劫舍II
 * 打家劫舍II的区别在于，路径是个环
 * 对于起点考虑两种情况，选和不选
 */
public class Code213 {
    public int rob(int[] nums) {
        if (nums==null)
            return 0;
        int n=nums.length;
        if (n==0)
            return 0;
        if (n==1)
            return nums[0];

        int[] f=new int[n+1];
        int[] g=new int[n+1];

        // 必不选1的情况
        for (int i = 2; i <=n ; i++) {
            f[i]=g[i-1]+nums[i-1];
            g[i]=Math.max(f[i-1],g[i-1]);
        }
        int res=Math.max(f[n],g[n]);

        //考虑必选1的情况
        f[1]=nums[0];
        g[1]=Integer.MIN_VALUE; // 第一个数必选了，那么为了使最后一个必不能选设置负无穷不会影响最终结果
        for (int i = 2; i <= n; i++) {
            f[i]=g[i-1]+nums[i-1];
            g[i]=Math.max(f[i-1],g[i-1]);
        }
        res=Math.max(res,g[n]);
        return res;
    }

    public int rob1(int[] nums) {
        if (nums==null)
            return 0;
        // 拆环
        int n=nums.length;
        if (n==0)
            return 0;
        if (n==1)
            return nums[0];
        // 0-n-1表示必选1
        int[] f1=new int[n]; // f记录当前第i选的时候最大值
        int[] g1=new int[n]; // g记录当前第i不选的时候最大值
        for (int i = 1; i <= n-1; i++) {
            f1[i]=g1[i-1]+nums[i-1];          // 注意f中的索引1对应的是nums[0]，然而g和f的索引不需要纠结直接考虑递推
            g1[i]=Math.max(f1[i-1],g1[i-1]);   // 第i个没选，第i-1个可选可不选
        }
        int res1=Math.max(f1[n-1],g1[n-1]);
        // 2-n表示必不选1
        int[] f=new int[n+1]; // f记录当前第i选的时候最大值
        int[] g=new int[n+1]; // g记录当前第i不选的时候最大值
        for (int i = 2; i <= n; i++) {
            f[i]=g[i-1]+nums[i-1];          // 注意f中的索引1对应的是nums[0]，然而g和f的索引不需要纠结直接考虑递推
            g[i]=Math.max(f[i-1],g[i-1]);   // 第i个没选，第i-1个可选可不选
        }
        int res2=Math.max(f[n],g[n]);
        return Math.max(res1,res2);
    }
}
