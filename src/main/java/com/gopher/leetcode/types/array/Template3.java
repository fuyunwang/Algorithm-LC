package com.gopher.leetcode.types.array;

/**
 * @Title Template3
 * @Author fyw
 * @Date 2022-03-03 20:41
 * @Description 计数排序
 */
public class Template3 {
    static class Code1748{

    }
    static class Code164{

    }
    static class Code1091{
        // count[i] 当前整数i出现的次数， count.length是256所以最大值就是最大索引就是255
        public double[] sampleStats(int[] count) {
            double[] res=new double[5];
            for (int i = 0; i < count.length; i++) {
                if (count[i]!=0){
                    res[0]=i;
                    break;
                }
            }
            for (int i = 255; i >=0 ; i--) {
                if (count[i]!=0){
                    res[1]=i;
                    break;
                }
            }

            double sum=0;
            int cnt=0;
            for (int i = 0; i < count.length; i++) {
                sum+=(double) i*count[i];
                cnt+=count[i];
            }
            res[2]=sum/cnt;

            // 众数
            int t=0;
            cnt=0;
            for (int i = 0; i < count.length; i++) {
                if (count[i]>cnt){
                    cnt=count[i];
                    t=i;
                }
            }
            res[4]=t;

            // 中位数: (getK(count,cnt/2 +1)+getK(count,cnt/2 +2))/2.0
            cnt=0;
            for (int i = 0; i < count.length; i++) {
                cnt+=count[i];
            }
            if ((cnt&1)!=0){
                res[3]=getK(count,cnt/2 +1);
            }else{
                res[3]=(getK(count,cnt/2 +1)+getK(count,cnt/2))/2.0;
            }

            return res;
        }
        int getK(int[] count,int k){
            int cnt=0;
            for (int i = 0; i < count.length; i++) {
                cnt+=count[i];
                if (cnt>=k){
                    return i;
                }
            }
            return -1;
        }
    }
}
