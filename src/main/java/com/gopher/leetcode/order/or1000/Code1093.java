package com.gopher.leetcode.order.or1000;

/**
 * @Title Code1093
 * @Author fyw
 * @Date 2022/1/28 12:12
 * @Description:
 */
public class Code1093 {
    public double[] sampleStats(int[] count) {
        double[] res=new double[5];
        for (int i = 0; ; i++) {
            if (count[i]!=0){
                res[0]=i;
                break;
            }
        }
        for (int i = 255; ; i--) {
            if (count[i]!=0){
                res[1]=i;
                break;
            }
        }
        double sum=0;
        int cnt=0;
        for (int i = 0; i < 256; i++) {
            if (count[i]!=0){
                sum+= (double) i * count[i];
                cnt+=count[i];
            }
        }
        res[2]=sum/cnt;
        int index=0;
        for (int i = 0; i < 256; i++) {
            if (count[index]<count[i]){
                index=i;
            }
        }
        res[3]=index;
        if (cnt%2==0){
            res[4] = (get(count,cnt/2)+get(count,cnt/2+1))/2.0;
        }else{
            res[4]=get(count,cnt/2);
        }
        return res;
    }
    public int get(int[] count,int cn){
        int res=0;
        for (int i = 0; i < count.length; i++) {
            res+=count[i];
            if (res>=cn){
                return i;
            }
        }
        return -1;
    }
}
