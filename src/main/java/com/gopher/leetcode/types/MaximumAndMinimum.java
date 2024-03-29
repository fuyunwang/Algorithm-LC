package com.gopher.leetcode.types;

/**
 * @Title MaximunAndMinimum
 * @Author fyw
 * @Date 2022-03-09 16:57
 * @Description
 */
public class MaximumAndMinimum {
    static class Code1011{
        public int shipWithinDays(int[] weights, int days) {
            int l = 1, r = 500 * (int)5e4;
            while (l < r)
            {
                int mid = l + r >> 1;
                if (check(weights, days, mid))
                    r = mid;
                else
                    l = mid + 1;
            }
            return r;
        }

        boolean check(int[] w, int d, int x) {
            int cnt = 1;
            for (int i = 0, s = 0; i < w.length; i ++ ) {
                if (w[i] > x)
                    return false;
                if (s + w[i] > x) {
                    cnt ++ ;
                    s = 0;
                }
                s += w[i];
            }
            return cnt <= d;
        }

    }
    static class Code738{
        // 比。。。小的满足。。。的最大。。
        public int monotoneIncreasingDigits(int n) {
            String raw=String.valueOf(n);
            int i=0;
            while (i+1<raw.length()&&raw.charAt(i)<=raw.charAt(i+1)) i++;
            if (i==raw.length()-1)
                return n;
            int j=i;
            while (j>0&&raw.charAt(j)==raw.charAt(j-1)) j--;
            StringBuilder sb=new StringBuilder();
            sb.append(raw, 0, j).append(raw.charAt(j)-'0'-1);
            for (int k = j+1; k < raw.length(); k++) {
                sb.append(9);
            }
            return Integer.parseInt(sb.toString());
        }
    }
}
