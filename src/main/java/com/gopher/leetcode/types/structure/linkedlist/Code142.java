package com.gopher.leetcode.types.structure.linkedlist;

/**
 * @Title Code142
 * @Author fyw
 * @Date 2022/2/6 19:50
 * @Description: 如果链表有环就返回环入口点
 */
public class Code142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){
                // 从相遇节点开始，另从头和相遇节点开始同步运行
                ListNode index1=head;
                ListNode index2=fast;
                while (index1!=index2){
                    index1=index1.next;
                    index2=index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    // 类似题目，原地寻找数组中的重复数
    static class Code287{
        public int findDuplicate(int[] nums) {
            int slow=0;
            int fast=0;
            while (true){
                slow=nums[slow];
                fast=nums[nums[fast]];
                if (slow==fast){
                    slow=0;
                    while (slow!=fast){
                        slow=nums[slow];
                        fast=nums[fast];
                    }
                    return slow;
                }
            }
        }
    }

}
