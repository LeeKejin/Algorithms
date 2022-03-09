package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class Leet722 {
    public List<String> removeComments(String[] source) {
        boolean commentMode = false;
        List<String> res = new ArrayList<>();
        StringBuilder currLine = new StringBuilder();
        for (String line : source) {
            int i = 0;
            while (i < line.length()) {
                if (!commentMode) {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    }
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        commentMode = true;
                        i += 2;
                    } else {
                        currLine.append(line.charAt(i));
                        i++;
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        i += 2;
                        commentMode = false;
                    } else {
                        i++;
                    }
                }
            }
            if (!commentMode) {
                if (currLine.length() != 0) {
                    res.add(currLine.toString());
                }

                currLine = new StringBuilder();
            }

        }
        return res;
    }
}
