package com.amazon.interview.cyclelinkedlist;

import java.util.HashSet;
import java.util.Set;

public class Leet287 {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int pointer = nums[0];
        set.add(nums[0]);
        while (true) {
            pointer = nums[pointer];
            if (set.contains(pointer)) {
                return pointer;
            } else {
                set.add(pointer);
            }
        }
    }

    //https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
    public int findDuplicateCycle(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = slow;
        slow = 0;

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
