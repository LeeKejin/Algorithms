package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class OutputContestMatches {
    int count = 1;

    private void cal(int n) {
        if (n == 2) return;
        n /= 2;
        count++;
        cal(n);
    }

    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        int i = 1;
        int j = n;
        for (int k = 1; k <= n; k++) {
            list.add(k + "");
        }
        cal(n);
        while (count > 0) {
            List<String> innerList = new ArrayList<>();
            while (i < j) {
                innerList.add("(" + list.get(i - 1) + "," + list.get(j - 1) + ")");
                i++;
                j--;
            }
            list.clear();
            list.addAll(innerList);
            i = 1;
            j = list.size();
            count--;
        }
        return list.get(0);
    }

//    public String findContestMatch(int n) {
//        String[] res = new String[n];
//        for (int i = 1; i <= n; i++) res[i - 1] = "" + i;
//        for (; n > 1; n /= 2)
//            for (int i = 0; i < n / 2; i++)
//                res[i] = "(" + res[i] + "," + res[n - 1 - i] + ")";
//        return res[0];
//    }
}
