package com.google.heap;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    List<String> visits;
    int size;
    int cur;

    public BrowserHistory(String homepage) {
        visits = new ArrayList<>();
        visits.add(homepage);
        size = 1;
        cur = 0;
    }

    public void visit(String url) {
        if (cur + 1 < visits.size()) {
            visits.set(cur + 1, url);
        } else {
            visits.add(url);
        }
        cur++;
        size = cur + 1;
    }

    public String back(int steps) {
        int index = Math.max(0, cur - steps);
        cur = index;
        return visits.get(cur);
    }

    public String forward(int steps) {
        int index = Math.min(size - 1, cur + steps);
        cur = index;
        return visits.get(cur);
    }
    /*
     Stack<String> visitStack = new Stack<>();
    Stack<String> historyStack = new Stack<>();


    public BrowserHistory(String homepage) {
        visitStack.push(homepage);
    }

    public void visit(String url) {
        visitStack.push(url);
        historyStack.clear();
    }

    public String back(int steps) {
        while (visitStack.size() > 1 && steps > 0) {
            historyStack.push(visitStack.pop());
            steps--;
        }
        return visitStack.peek();
    }

    public String forward(int steps) {
        if (historyStack.isEmpty()) return visitStack.peek();
        while (historyStack.size() > 0 && steps > 0) {
            visitStack.push(historyStack.pop());
            steps--;
        }
        return visitStack.peek();
    }
     */
}
