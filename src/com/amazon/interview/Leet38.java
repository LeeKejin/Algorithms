package com.amazon.interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class Leet38 {
    public String countAndSayLinkedMap(int n) {
        if (n == 1) return "1";
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "1");

        for (int i = 2; i <= n; i++) {
            String prev = map.get(i - 1);
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < prev.length(); j++) {
                int num = prev.charAt(j) - '0';
                int num0 = prev.charAt(j - 1) - '0';
                if (num0 == num) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(num0);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(prev.charAt(prev.length() - 1));

            map.put(i, sb.toString());
        }
        return map.get(n);

    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        return find(countAndSay(n - 1));
    }

    private String find(String prev) {

        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j < prev.length(); j++) {
            int num = prev.charAt(j) - '0';
            int num0 = prev.charAt(j - 1) - '0';
            if (num0 == num) {
                count++;
            } else {
                sb.append(count);
                sb.append(num0);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(prev.charAt(prev.length() - 1));

        return sb.toString();
    }
    

}
