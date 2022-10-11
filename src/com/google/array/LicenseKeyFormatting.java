package com.google.array;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {

        s = s.replaceAll("-", "");
        s = s.toUpperCase();
        if (s.length() <= k) return s;
        int group = s.length() / k;
        int extra = s.length() % k;

        String rest = s.substring(extra);
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < group; i++) {
            String str = rest.substring(j, j + k);
            sb.append(str);
            sb.append("-");
            j = j + k;
        }
        sb.deleteCharAt(sb.length() - 1);
        if (extra == 0) return sb.toString();
        return s.substring(0, extra) + "-" + sb;
    }
}
