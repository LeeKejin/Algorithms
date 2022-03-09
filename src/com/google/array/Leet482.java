package com.google.array;

public class Leet482 {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-", "").toUpperCase();
        if (s.length() <= k) return s;
        int part = s.length() % k;
        StringBuilder sb = new StringBuilder();

        for (int i = part; i < s.length(); i += k) {
            String str = s.substring(i, i + k);
            sb.append(str);
            sb.append("-");
        }
        if (part == 0) return sb.toString().substring(0, sb.length() - 1);
        String first = s.substring(0, part);

        return first + "-" + sb.toString().substring(0, sb.length() - 1);
    }
}
