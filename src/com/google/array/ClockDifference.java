package com.google.array;

import java.util.List;

public class ClockDifference {
    public int findMinDifference(List<String> timePoints) {
        boolean mark[] = new boolean[60 * 24];
        for (String time : timePoints) {
            String[] arr = time.split(":");
            int h = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int total = h * 60 + m;
            if (mark[total]) return 0;
            mark[total] = true;
        }
        int prev = 0;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }

        }
        min = Math.min(min, 24 * 60 - (last - first));
        return min;
    }
    /**
     *["12:12","00:13"] should be 721 mins not 719
     */
    /*
         int h;
        int m;

        public Time(int h, int m) {
            this.h = h;
            this.m = m;
        }
    }

    public int findMinDifference(List<String> timePoints) {
        List<Time> list = new ArrayList<>();
        for (String point : timePoints) {
            String[] time = point.split(":");
            list.add(new Time(Integer.parseInt(time[0]), Integer.parseInt(time[1])));
        }
        int res = Integer.MAX_VALUE;
        Collections.sort(list, (t1, t2) -> (t1.h == t2.h ? t1.m - t2.m : t1.h - t2.h));
        for (int i = 1; i < list.size(); i++) {
            Time t1 = list.get(i - 1);
            Time t2 = list.get(i);
            if (t1.h == t2.h) {
                int m = t2.m - t1.m;
                res = Math.min(m, res);
            } else {
                if (t2.h - t1.h == 1) {
                    int m = 60 - t1.m + t2.m;
                    res = Math.min(m, res);
                } else {
                    int h = t2.h - t1.h;
                    int m = 60 - t1.m + t2.m;
                    res = Math.min(h * 60 + m, res);
                }
            }
        }

        Time first = list.get(0);
        Time last = list.get(list.size() - 1);
        if (last.h - first.h == 23) {
            res = Math.min(res, 60 - last.m);
        } else {
             res = Math.min((24 - (last.h + 1)) * 60 + (60 - last.m) + first.h * 60 + first.m, res);
        }
        return res;
    }
     */
}
