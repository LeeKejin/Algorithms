package com.google.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Nlog(N)
 */
public class MaximumProfitInJobScheduling1 {
    class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> list = new ArrayList<>();

        for (int i = 0; i < startTime.length; i++) {
            list.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(list, (j1, j2) -> j1.end == j2.end ? j2.profit - j1.profit : j1.end - j2.end);
        int dp[] = new int[startTime.length + 1];
        for (int i = 1; i <= list.size(); i++) {
            if (i == 1) {
                dp[i] = list.get(i - 1).profit;
            } else {
                int prev = binarySearch(list, i - 2, list.get(i - 1).start);
                if (prev == -1) {
                    dp[i] = Math.max(dp[i - 1], list.get(i - 1).profit);
                } else {
                    dp[i] = Math.max(dp[i - 1], list.get(i - 1).profit + dp[prev]);
                }
            }
        }
        return dp[startTime.length];
    }

    private int binarySearch(List<Job> list, int r, int target) {
        int l = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            Job job = list.get(mid);
            if (job.end == target) {
                return mid + 1;
            }
            if (job.end < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (r == -1) return -1;
        return r + 1;
    }

    //find the end bigger than start but with the smallest index, because profit is reverse sorted
    private int binarySearch1(List<Job> list, int r, int target) {
        int l = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid).end == target) {
                if (mid - 1 < l || list.get(mid - 1).end != list.get(mid).end) return mid + 1;
                while (mid - 1 >= l && list.get(mid - 1).end == list.get(mid).end) {
                    mid--;
                }
                return mid + 2;
            }
            if (list.get(mid).end < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (r == -1) return -1;
        return r + 1;
    }

}
