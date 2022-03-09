package com.google.array;

public class StringCompress {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int count = 1;
        int numIndex = -1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count == 1) {
                    char ch = chars[i - 1];
                    if (numIndex == -1) {
                        numIndex = i - count;
                    }
                    chars[numIndex] = ch;
                    numIndex++;
                    continue;
                }
                char ch = chars[i - 1];
                if (numIndex == -1) {
                    numIndex = i - count;
                }
                chars[numIndex] = ch;
                numIndex++;
                if (count < 10) {
                    chars[numIndex] = (char) (count + '0');
                    numIndex++;
                } else {
                    String str = String.valueOf(count);
                    for (int j = 1; j <= str.length(); j++) {
                        chars[numIndex] = str.charAt(j - 1);
                        numIndex++;
                    }
                }

                count = 1;
            }
        }
        if (count == 1) {
            char ch = chars[chars.length - 1];
            if (numIndex == -1) {
                numIndex = chars.length - count;
            }
            chars[numIndex] = ch;
            numIndex++;
        } else {
            char ch = chars[chars.length - 1];
            if (numIndex == -1) {
                numIndex = chars.length - count;
            }
            chars[numIndex] = ch;
            numIndex++;
            if (count < 10 && count > 1) {
                chars[numIndex] = (char) (count + '0');
                numIndex++;
            } else {
                String str = String.valueOf(count);
                for (int j = 1; j <= str.length(); j++) {
                    chars[numIndex] = str.charAt(j - 1);
                    numIndex++;
                }
            }

        }


        return numIndex;
    }
}
