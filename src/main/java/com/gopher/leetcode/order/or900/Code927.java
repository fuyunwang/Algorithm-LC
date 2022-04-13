package com.gopher.leetcode.order.or900;

/**
 * @Title Code927
 * @Author fyw
 * @Date 2022/4/13 20:23
 * @Description:
 */
public class Code927 {
    public int[] threeEqualParts(int[] arr) {
        int sum=0;
        for (int x:arr){
            sum+=x;
        }
        if (sum==0)
            return new int[]{0,2};
        if (sum%3!=0)
            return new int[]{-1,-1};
        int avg=sum/3;
        int[] s=new int[]{1,avg,avg+1,2*avg,2*avg+1,3*avg};
        int n=arr.length;
        int[] p=new int[6];// 记录分隔段的索引
        for (int i = 0,j=0,c=0; i < n; i++) {
            if (arr[i]==0)
                continue;
            c++;
            while (j<6&&c==s[j])
                p[j++]=i;
        }
        int zero=n-1-p[5];// 记录每一段1后面多余的0
        if (p[4]-p[3]-1<zero||p[2]-p[1]-1<zero)
            return new int[]{-1,-1};
        if (!check(arr,p[0],p[1]+zero,p[2],p[3]+zero))
            return new int[]{-1,-1};
        if (!check(arr,p[2],p[3]+zero,p[4],p[5]+zero))
            return new int[]{-1,-1};
        return new int[]{p[1]+zero,p[3]+zero+1};
    }
    boolean check(int[] arr,int a,int b,int c,int d){
        for (int i = a,j=c; i <=b; i++,j++) {
            if (arr[i]!=arr[j])
                return false;
        }
        return true;
    }
}
