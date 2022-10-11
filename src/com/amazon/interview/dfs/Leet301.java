package com.amazon.interview.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet301 {
    public List<String> removeInvalidParenthesesRemoveSet(String s) {
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rmL++;
            } else if (s.charAt(i) == ')') {
                if (rmL != 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        List<String> res = new ArrayList<>();
        dfs(s, 0, res, "", rmL, rmR, 0, '&');
        return res;
    }

    public void dfs(String s, int i, List<String> res, String temp, int rmL, int rmR, int open, char lastSkipped) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }
        if (i == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                res.add(temp);
            }
            return;
        }

        char c = s.charAt(i);

        if (c == '(') {
            if (rmL > 0)
                dfs(s, i + 1, res, temp, rmL - 1, rmR, open, '(');            // not use (

            if (lastSkipped != '(')
                dfs(s, i + 1, res, temp + c, rmL, rmR, open + 1, '&');       // use (

        } else if (c == ')') {
            if (rmR > 0)
                dfs(s, i + 1, res, temp, rmL, rmR - 1, open, ')');                // not use  )

            if (open > 0 && (lastSkipped != ')'))
                dfs(s, i + 1, res, temp + c, rmL, rmR, open - 1, '&');        // use )

        } else {
            dfs(s, i + 1, res, temp + c, rmL, rmR, open, '&');
        }
    }


    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        if (left == 0 && right == 0) return Arrays.asList(s);
        Set<String> set = new HashSet<>();
        dfs(set, s, 0, new StringBuilder(), left, right, 0);
        return new ArrayList<>(set);
    }

    private void dfs(Set<String> set, String s, int i, StringBuilder stringBuilder, int left, int right, int diff) {
        if (i == s.length()) {
            if (left == 0 && right == 0) {
                set.add(stringBuilder.toString());
            }
            return;
        }
        char ch = s.charAt(i);
        if (ch == '(') {
            stringBuilder.append('(');
            dfs(set, s, i + 1, stringBuilder, left, right, diff + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            if (left > 0) {
                dfs(set, s, i + 1, stringBuilder, left - 1, right, diff);
            }
        } else if (ch == ')') {
            if (diff > 0) {
                stringBuilder.append(')');
                dfs(set, s, i + 1, stringBuilder, left, right, diff - 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if (right > 0) {
                dfs(set, s, i + 1, stringBuilder, left, right - 1, diff);
            }
        } else {
            stringBuilder.append(ch);
            dfs(set, s, i + 1, stringBuilder, left, right, diff);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }

    public static void main(String[] args) {
        Leet301 test = new Leet301();
        test.removeInvalidParentheses(")(");
    }
}
