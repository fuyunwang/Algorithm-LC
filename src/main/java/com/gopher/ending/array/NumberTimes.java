package com.gopher.ending.array;

/**
 * @Title NumberTimes
 * @Author fyw
 * @Date 2022/3/12 17:58
 * @Description: 重复、数字出现的次数
 */
public class NumberTimes {
    static class FirstCode{
        // 只出现一次的数字，异或
        static class Code136{

        }
        static class Code260{       // 136题的扩展，先将所有数异或，然后根据异或结果进行二进制位划分，其中相同一类的用136题解决
            public int[] singleNumber(int[] nums) {
                int all=0;
                for(int num:nums){
                    all^=num;
                }

                int k=0;
                while (((all>>k)&1)==0) k++;

                return new int[]{get(nums,k,0),get(nums,k,1)};
            }
            int get(int[] nums, int k,int t){
                int res=0;
                for(int num:nums){
                    if (((num>>k)&1)==t){
                        res^=num;
                    }
                }
                return res;
            }
        }

        static class Code389{
            public char findTheDifference(String s, String t) {
                char[] s1=s.toCharArray();
                char[] t1=t.toCharArray();
                char res=0;
                for (char s11:s1){
                    res^=s11;
                }
                for (char t11:t1){
                    res^=t11;
                }
                return res;
            }
        }
    }

}
