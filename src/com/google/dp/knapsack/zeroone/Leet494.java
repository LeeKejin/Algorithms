package com.google.dp.knapsack.zeroone;

import java.util.Arrays;

/*
这道题目咋眼一看和动态规划背包啥的也没啥关系。

本题要如何使表达式结果为target，

既然为target，那么就一定有 left组合 - right组合 = target。

left + right等于sum，而sum是固定的。

公式来了， left - (sum - left) = target -> left = (target + sum)/2 。

target是固定的，sum是固定的，left就可以求出来。

此时问题就是在集合nums中找出和为left的组合。
确定dp数组以及下标的含义
dp[j] 表示：填满j（包括j）这么大容积的包，有dp[i]种方法

有哪些来源可以推出dp[j]呢？

不考虑nums[i]的情况下，填满容量为j - nums[i]的背包，有dp[j - nums[i]]种方法。

那么只要搞到nums[i]的话，凑成dp[j]就有dp[j - nums[i]] 种方法。

举一个例子,nums[i] = 2： dp[3]，填满背包容量为3的话，有dp[3]种方法。

那么只需要搞到一个2（nums[i]），有dp[3]方法可以凑齐容量为3的背包，相应的就有多少种方法可以凑齐容量为5的背包。

那么需要把 这些方法累加起来就可以了，dp[j] += dp[j - nums[i]]

所以求组合类问题的公式，都是类似这种：


dp[j] += dp[j - nums[i]]

作者：carlsun-2
链接：https://leetcode-cn.com/problems/target-sum/solution/dai-ma-sui-xiang-lu-494-mu-biao-he-01bei-rte9/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

链接：https://leetcode-cn.com/problems/target-sum/solution/dai-ma-sui-xiang-lu-494-mu-biao-he-01bei-rte9/
 */
public class Leet494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target) return 0;
        if ((sum + target) % 2 != 0) return 0;
        int bagSize = (sum + target) / 2;
        bagSize = Math.abs(bagSize);
        int dp[] = new int[bagSize + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = bagSize; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[bagSize];
    }

    int count = 0;

    public int findTargetSumWaysBackTrace(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    private void calculate(int[] nums, int i, int sum, int s) {
        if (i == nums.length && sum == s) {
            count++;
        } else if (i < nums.length) {
            calculate(nums, i + 1, sum + nums[i], s);
            calculate(nums, i + 1, sum - nums[i], s);
        }
    }

    /**
     * DFS
     */
    /*
     private static Map<String, Integer> memo; // key: serialized curIndex and targetSum, value: its corresponding number of ways

    Map<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    private int dfs(int[] nums, int target, int i, int cur) {
        if (i == nums.length && cur == target) {
            map.put(i + "," + cur, map.getOrDefault(i, 0) + 1);

            return 1;
        }
        if (i == nums.length) return 0;
        if (map.containsKey(i + "," + cur)) return map.get(i + "," + cur);
        int add = dfs(nums, target, i + 1, cur + nums[i]);
        int sub = dfs(nums, target, i + 1, cur - nums[i]);
        map.put(i + "," + cur, add + sub);
        return map.get(i + "," + cur);
    }
     */
}
