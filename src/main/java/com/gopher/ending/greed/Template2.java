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
        // 区间选点，多个闭区间选择最少数量点使得每个区间都至少包含一个点
        // 最大不相交区间数量，尽可能选择最多的区间使其不相交
        /**
         * 区间按照右端点从小到大排序
         * 从前往后依次枚举每个区间，如果满足条件则跳过，否则选择当前区间右端点
         */
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();    // n个区间
            List<int[]> list=new ArrayList<>();
            while (n-->0){
                int l=scanner.nextInt();
                int r=scanner.nextInt();
                list.add(new int[]{l,r});
            }
            // 右端点从小到大排序
            Collections.sort(list,(l1,l2)->l1[1]-l2[1]);
            int count=0,end=Integer.MIN_VALUE;
            for(int[] pii: list){
                if (pii[0]>end){
                    count++;
                    end=pii[1];
                }
            }
            System.out.println(count);
        }
    }
    static class CodeWing2{
        // 区间覆盖，选择最少区间将目标区间覆盖
        // 将所有区间按照左端点排序，每次选择能够能够覆盖左端点的区间中右端点最大的区间
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            List<int[]> list = new ArrayList<int[]>();
            int start = scan.nextInt();
            int end = scan.nextInt();
            int n = scan.nextInt();
            for(int i = 0;i < n;i++)
            {
                int L = scan.nextInt();
                int R = scan.nextInt();
                list.add(new int[]{L,R});
            }
            //按左端点排序
            Collections.sort(list,(l1,l2)->l1[0]-l2[0]);
            boolean flag=false;
            int res=0;
            for (int i = 0; i < n; i++) {
                int j=i;
                int r=Integer.MIN_VALUE;    // 记录满足左边界的条件下最大右边界
                while (j<n&&list.get(j)[0]<=start){
                    r=Math.max(r,list.get(j)[1]);
                    j++;
                }
                if (r<start){       // 说明中间有空隙不能覆盖直接结束返回-1
                    res=-1;
                    break;
                }
                res++;              // 连续片段多了一种
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
    }
    static class CodeWing3{
        // 区间分组，分成尽可能少的组使得组内区间都不相交
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            List<int[]> list=new ArrayList<>();
            while (n-->0){
                int l=scanner.nextInt();
                int r=scanner.nextInt();
                list.add(new int[]{l,r});
            }
            // 首先按照左端点排序
            Collections.sort(list,(l1,l2)->l1[0]-l2[0]);
            PriorityQueue<Integer> queue=new PriorityQueue<>();// 小根堆，每次扩展较小的分组
            for (int[] cur:list) {
                if (queue.isEmpty()||queue.peek()>=cur[0]){
                    // 如果队列为空或者队列的右端点最大值小于当前左端点的最小值
                    queue.offer(cur[1]);
                }else{
                    queue.poll();
                    queue.offer(cur[1]);
                }
            }
            System.out.println(queue.size());
        }
    }

    static class Code1024{
        // 视频拼接，区间覆盖 [0,time]
        public int videoStitching(int[][] clips, int time) {
            int start=0;
            int end=time;
            Arrays.sort(clips, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0],o2[0]);
                }
            });
            boolean flag = false;
            int res=0;
            for (int i = 0; i < clips.length; i++) {
                int j=i;
                int r=Integer.MIN_VALUE;    // 当前可扩展的最大右边界
                while (j<clips.length&&clips[j][0]<=start){
                    r=Math.max(r,clips[j][1]);
                    j++;
                }
                if (r<start){
                    res=-1;
                    break;
                }
                res++;  //当前连续可扩展的第一个区间结束了，累加
                if (r>=end){
                    flag=true;
                    break;
                }
                start=r;
                i=j-1;
            }
            if (!flag)
                return -1;
            return res;
        }
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
