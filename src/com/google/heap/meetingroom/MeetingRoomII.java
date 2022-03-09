package com.google.heap.meetingroom;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> (a1[0] - a2[0]));
        for (int[] interval : intervals) {
            queue.add(interval);
        }
        PriorityQueue<Integer> end = new PriorityQueue<>();
        int[] start = queue.poll();
        end.add(start[1]);
        int count = 1;
        while (!queue.isEmpty()) {
            int[] meeting = queue.poll();
            if (meeting[0] < end.peek()) {
                count++;
            } else {
                end.poll();
            }
            end.add(meeting[1]);

        }
        return count;
    }

    public int minMeetingRooms1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (queue.isEmpty()) {
                count++;
                queue.add(intervals[i]);
            } else if (queue.peek()[1] <= intervals[i][0]) {
                queue.poll();
                queue.add(intervals[i]);
            } else {
                count++;
                queue.add(intervals[i]);
            }
        }

        return count;
    }
}
