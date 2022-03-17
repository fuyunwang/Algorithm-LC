package com.gopher.ending.greed;

import java.util.*;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-14 10:29
 * @Description 区间贪心
 */
public class Template2 {
    static class CodeWing1{
        // 区间选点
        // 多个闭区间选择最少数量点使得每个区间都至少包含一个点
        /**
         * 区间按照右端点从小到大排序
         * 从前往后依次枚举每个区间，如果满足条件则跳过，否则选择当前区间右端点
         */
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();    // n个区间
            List<PII> list=new ArrayList<>();
            while (n-->0){
                int l=scanner.nextInt();
                int r=scanner.nextInt();
                list.add(new PII(l,r));
            }
            // 右端点从小到大排序
            Collections.sort(list);
            int count=0,end=Integer.MIN_VALUE;
            for(PII pii: list){
                if (pii.first>end){
                    count++;
                    end=pii.second;
                }
            }
            System.out.println(count);
        }
        static class PII implements Comparable<PII>{
            public int first;
            public int second;
            public PII(int first, int second) {
                this.first = first;
                this.second = second;
            }
            @Override
            public int compareTo(PII o) {
                return Integer.compare(this.second,o.second);   // 从小到大排序
            }
        }
    }
    static class CodeWing2{
        // 区间覆盖，选择最少区间将目标区间覆盖
        // 将所有区间按照左端点排序，每次选择能够能够覆盖左端点的区间中右端点最大的区间
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            List<PIIs> list = new ArrayList<PIIs>();
            int start = scan.nextInt();
            int end = scan.nextInt();
            int n = scan.nextInt();
            for(int i = 0;i < n;i++)
            {
                int L = scan.nextInt();
                int R = scan.nextInt();
                list.add(new PIIs(L,R));
            }
            //按左端点排序
            Collections.sort(list);
            boolean flag=false;
            int res=0;
            for (int i = 0; i < n; i++) {
                int j=i;
                int r=Integer.MIN_VALUE;    // 记录满足左边界的条件下最大右边界
                while (j<n&&list.get(j).first<=start){
                    r=Math.max(r,list.get(j).second);
                    j++;
                }
                if (r<start){
                    res=-1;
                    break;
                }
                res++;
                if (r>=end){
                    flag=true;
                    break;
                }
                start=r;
                i=j-1;
            }
            if (!flag)
                System.out.println(-1);
            else
                System.out.println(res);
        }

        static class PIIs implements Comparable<PIIs>{
            public int first;
            public int second;
            public PIIs(int first, int second) {
                this.first = first;
                this.second = second;
            }
            @Override
            public int compareTo(PIIs o) {
                return Integer.compare(this.first,o.first);
            }
        }
    }
    static class CodeWing3{

    }

    static class Code406{
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (o1,o2) -> {
                if(o1[0] == o2[0]) return o1[1]-o2[1];
                return o2[0]-o1[0];
            });
            List<int[]> list = new ArrayList<>();
            for(int[] p: people){
                list.add(p[1],p);
            }
            return list.toArray(new int[0][0]);
        }
    }
    static class Code632{
        // 最小区间、多路归并
    }
    static class Code646{
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
            int res = 1;
            int max = pairs[0][1];
            for (int i = 1; i < pairs.length; i++){
                if (pairs[i][0] > max){
                    res++;
                    max = pairs[i][1];
                }
            }
            return res;
        }
    }
}
