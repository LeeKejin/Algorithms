package com.google.array;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    //"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] levels = new int[paths.length + 1]; //5 levels
        levels[0] = -1; //before dir
        int maxLength = 0;
        for (String path : paths) {
            String name = path; //dir,\tsubdir1,\tsubdir2,\t\tfile.ext
            int level = 1;
            while (name.startsWith("\t")) {
                name = name.substring(1);//subdir1, subdir2, file.ext
                level++;//2,3
            }
            int newLength = levels[level - 1] + name.length() + 1; //-1+3+1,3+7+1,11+8+1
            if (name.contains(".")) {
                maxLength = Math.max(maxLength, newLength); //20
            } else {
                levels[level] = newLength;//[1]=3,[2]=11 //if the file of the same level is longer but does not have a file with a . it is ignored and the length is replaced because it is not a candidate
            }
        }
        return maxLength;
    }

    public int lengthLongestPathStack(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxLen = 0;
        String strs[] = input.split("\n");
        for (String s : strs) {
            int level = s.lastIndexOf('\t') + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + s.length() - level + 1;
            stack.add(len);
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, len - 1);
            }
        }
        return maxLen;
    }
}
