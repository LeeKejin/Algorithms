package com.google.heap.meetingroom;

import java.util.PriorityQueue;

public class Leet252 {
    public boolean canAttendMeetings(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> (a1[0] - a2[0]));
        for (int[] interval : intervals) {
            queue.add(interval);
        }
        int[] start = queue.poll();
        while (!queue.isEmpty()) {
            int[] meeting = queue.poll();
            if (meeting[0] < start[1]) return false;
            start = meeting;
        }
        return true;
    }
}
