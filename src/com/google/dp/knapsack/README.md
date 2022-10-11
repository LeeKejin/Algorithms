常见的背包类型主要有以下几种： 1、0/1背包问题：每个元素最多选取一次 2、完全背包问题：每个元素可以重复选择 3、组合背包问题：背包中的物品要考虑顺序 4、分组背包问题：不止一个背包，需要遍历每个背包

而每个背包问题要求的也是不同的，按照所求问题分类，又可以分为以下几种： 1、最值问题：要求最大值/最小值 2、存在问题：是否存在…………，满足………… 3、组合问题：求所有满足……的排列组合

分类解题模板 背包问题大体的解题模板是两层循环，分别遍历物品nums和背包容量target，然后写转移方程， 根据背包的分类我们确定物品和容量遍历的先后顺序，根据问题的分类我们确定状态转移方程的写法
    
首先是背包分类的模板： 1、0/1背包：外循环nums,内循环target,target倒序且target>=nums[i]; 2、完全背包：外循环nums,内循环target,target正序且target>=nums[i];
3、组合背包：外循环target,内循环nums,target正序且target>=nums[i]; 4、分组背包：这个比较特殊，需要三重循环：外循环背包bags,内部两层循环根据题目的要求转化为1,2,3三种背包类型的模板

然后是问题分类的模板： 1、最值问题: dp[i] = max/min(dp[i], dp[i-nums]+1)或dp[i] = max/min(dp[i], dp[i-num]+nums); 2、存在问题(bool)：dp[i]=dp[i]||dp[i-num]; 3、组合问题：dp[i]
+=dp[i-num];

这样遇到问题将两个模板往上一套大部分问题就可以迎刃而解
https://leetcode-cn.com/problems/last-stone-weight-ii/solution/yi-pian-wen-zhang-chi-tou-bei-bao-wen-ti-5lfv/

如果求组合数就是外层for循环遍历物品，内层for遍历背包。

如果求排列数就是外层for遍历背包，内层for循环遍历物品
https://leetcode-cn.com/problems/combination-sum-iv/solution/dai-ma-sui-xiang-lu-377-zu-he-zong-he-iv-pj9s/

动态规划：518.零钱兑换II (opens new window)中求的是组合数，动态规划：377. 组合总和 Ⅳ (opens new window)中求的是排列数。