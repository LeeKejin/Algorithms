package com.crackingcodeinterview.chapter10;

public class SearchWord_10_4 {
    public int findString(String[] words, String s) {
        int l = 0;
        int r = words.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (words[mid].equals(s)) return mid;
            int leftM = findL(l, mid - 1, words);
            int rightM = findR(mid + 1, r, words);
            if (leftM == -1 && rightM == -1) return -1;
            if (leftM == -1) {
                String right = words[rightM];
                if (s.compareTo(right) >= 0) {
                    l = rightM;
                } else {
                    return -1;
                }
            } else if (rightM == -1) {
                String left = words[leftM];
                if (s.compareTo(left) <= 0) {
                    r = leftM;
                } else {
                    return -1;
                }
            } else {
                String right = words[rightM];
                String left = words[leftM];
                if (s.compareTo(left) <= 0) {
                    r = leftM;
                } else if (s.compareTo(right) >= 0) {
                    l = rightM;
                } else {
                    l = leftM + 1;
                    r = rightM - 1;
                }
            }
        }
        return -1;
    }

    private int findR(int low, int high, String[] words) {
        while (low <= high) {
            if (!words[low].equals("")) return low;
            low++;
        }
        return -1;
    }

    private int findL(int low, int high, String[] words) {
        while (high >= low) {
            if (!words[high].equals("")) return high;
            high--;
        }
        return -1;
    }
}
