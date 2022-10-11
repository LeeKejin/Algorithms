package com.google.array;
//https://leetcode.com/problems/string-compression/submissions/
public class StringCompress {
    public int compress(char[] chars) {
        int count = 1;

        int i = 1;
        int start = 0;
        char ch = chars[0];
        while (i < chars.length) {
            if (chars[i] == ch) {
                count++;
                i++;
            } else {
                if (count == 1) {
                    chars[start] = ch;
                    ch = chars[i];
                    i++;
                    start++;
                } else {
                    char prev = ch;
                    ch = chars[i];
                    if (count < 10) {
                        chars[start] = prev;
                        start++;
                        chars[start] = (char) (count + '0');
                        start++;
                    } else {
                        String c = String.valueOf(count);
                        chars[start] = prev;

                        for (int j = 0; j < c.length(); j++) {
                            start++;
                            chars[start] = c.charAt(j);
                        }
                        start++;
                    }
                    count = 1;
                    i++;
                }
            }
        }
        chars[start] = ch;
        start++;
        if (count == 1) {
            return start;
        }
        if (count < 10) {

            chars[start] = (char) (count + '0');
            start++;
            return start;
        }
        String c = String.valueOf(count);
        for (int j = 0; j < c.length(); j++) {
            chars[start] = c.charAt(j);
            start++;
        }

        return start;
    }
}
