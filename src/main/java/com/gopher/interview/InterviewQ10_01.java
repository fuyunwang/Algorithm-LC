package com.gopher.interview;

/**
 * @Title InterviewQ10_01
 * @Author fyw
 * @Date 2022/1/28 12:13
 * @Description:
 */
public class InterviewQ10_01 {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] help=new int[m+n];
        int p1=0;
        int p2=0;
        int index=0;
        while (p1<m&&p2<n){
            help[index++]=A[p1]<=B[p2]?A[p1++]:B[p2++];
        }
        while (p1<m){
            help[index++]=A[p1++];
        }
        while (p2<n){
            help[index++]=B[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            A[i]=help[i];
        }
    }
}
