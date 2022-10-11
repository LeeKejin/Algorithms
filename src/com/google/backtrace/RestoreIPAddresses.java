package com.google.backtrace;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return new ArrayList<>();
        dfs(s, new ArrayList<>());
        return res;
    }

    private void dfs(String s, List<String> list) {
        if (list.size() == 4 && s.length() == 0) {

            String ip = generateIp(list);
            res.add(ip);

            return;
        }
        if (s.length() == 0) return;

        for (int i = 1; i <= 3; i++) {
            if (s.length() < i) return;
            String temp = s.substring(0, i);
            if (temp.length() > 1 && temp.startsWith("0")) return;
            for (char c : temp.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return;
                }
            }
            if (Integer.parseInt(temp) > 255) continue;
            list.add(temp);
            dfs(s.substring(i), list);
            list.remove(list.size() - 1);
        }
    }

    private String generateIp(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
