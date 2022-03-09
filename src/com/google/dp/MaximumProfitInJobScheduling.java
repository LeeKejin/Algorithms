package com.google.dp;

import java.util.ArrayList;
import java.util.List;

public class MaximumProfitInJobScheduling {
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
        int n = startTime.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs.add(job);
        }
        int dp[] = new int[n + 1];
        jobs.sort((j1, j2) -> j1.end - j2.end);
        for (int i = 1; i <= n; i++) {
            int index = getLast(jobs, i);
            dp[i] = Math.max(dp[index] + jobs.get(i - 1).profit, dp[i - 1]);
        }
        return dp[n];
    }

    private int getLast(List<Job> jobs, int i) {
        int l = 0;
        int r = i - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (jobs.get(mid).end <= jobs.get(i - 1).start) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (jobs.get(l).end <= jobs.get(i - 1).start) return l + 1;
        return 0;
    }

    public static void main(String[] args) {
        MaximumProfitInJobScheduling test = new MaximumProfitInJobScheduling();
        test.jobScheduling(
                new int[]{4, 3, 1, 2, 4, 8, 3, 3, 3, 9},
                new int[]{5, 6, 3, 5, 9, 9, 8, 5, 7, 10},
                new int[]{9, 9, 5, 12, 10, 11, 10, 4, 14, 7});
    }

}
