package com.google.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeFreeTime {
    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> first = schedule.get(0);
        for (int i = 1; i < schedule.size(); i++) {
            List<Interval> list = schedule.get(i);
            list.addAll(first);
            Collections.sort(list, (a, b) -> (a.start == b.start ? a.end - b.end : a.start - b.start));
            Queue<Interval> queue = new LinkedList<>();
            List<Interval> mergeList = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (queue.isEmpty()) {
                    queue.add(list.get(j));
                } else {
                    if (list.get(j).start >= queue.peek().start && list.get(j).start <= queue.peek().end) {
                        Interval interval = queue.poll();
                        queue.add(new Interval(Math.min(interval.start, list.get(j).start), Math.max(interval.end, list.get(j).end)));
                    } else {
                        mergeList.add(queue.poll());
                        queue.add(list.get(j));
                    }
                }
            }
            if (!queue.isEmpty()) mergeList.add(queue.poll());
            first.clear();
            first.addAll(mergeList);
        }
        if (first.size() == 1) return new ArrayList<>();
        List<Interval> res = new ArrayList<>();
        for (int i = 1; i < first.size(); i++) {
            res.add(new Interval(first.get(i - 1).end, first.get(i).start));
        }
        return res;
    }

    //Flat the schedule
    public List<Interval> employeeFreeTimeFlat(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList<>();
        for (List<Interval> list : schedule) {
            for (Interval interval : list) {
                intervals.add(interval);
            }
        }

        Collections.sort(intervals, (a, b) -> (a.start == b.start ? a.end - b.end : a.start - b.start));
        List<Interval> overlapWorkList = new ArrayList<>();
        Queue<Interval> queue = new LinkedList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (queue.isEmpty()) {
                queue.add(intervals.get(i));
            } else {
                if (queue.peek().start <= intervals.get(i).start && intervals.get(i).start <= queue.peek().end) {
                    Interval interval = queue.poll();
                    queue.add(new Interval(Math.min(interval.start, intervals.get(i).start), Math.max(interval.end, intervals.get(i).end)));
                } else {
                    overlapWorkList.add(queue.poll());
                    queue.add(intervals.get(i));
                }
            }
        }
        if (!queue.isEmpty()) {
            overlapWorkList.add(queue.poll());
        }

        List<Interval> res = new ArrayList<>();
        if (overlapWorkList.size() == 1) return res;
        for (int i = 1; i < overlapWorkList.size(); i++) {
            res.add(new Interval(overlapWorkList.get(i - 1).end, overlapWorkList.get(i).start));
        }
        return res;
    }
}
