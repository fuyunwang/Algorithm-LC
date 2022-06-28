package com.fuyunwang.bilibili.order.subarr;

/**
 * @Title Code978
 * @Author fyw
 * @Date 2022-05-25 9:09
 * @Description 最长湍流子数组
 * dp、状态压缩
 */
public class Code978 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length<2){
            return arr.length;
        }
        int res=0;
        for (int i = 1,up=1,down=1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]){
                up=down+1;
                down=1;
            }else if (arr[i]>arr[i-1]){
                down=up+1;
                up=1;
            }else{
                down=1;
                up=1;
            }
            res=Math.max(res,Math.max(up,down));
        }
        return res;
    }
}
