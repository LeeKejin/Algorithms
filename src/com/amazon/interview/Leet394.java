package com.amazon.interview;

import java.util.Stack;
//https://leetcode.com/problems/decode-string/
//compress string
//compression
//"3[a]2[bc]"-> aaabcbc
public class Leet394 {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        int number = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (Character.isLetter(ch)) {
                sb.append(ch);
            } else if (ch == '[') {
                numberStack.push(number);
                charStack.push(sb.toString());
                number = 0;
                sb = new StringBuilder();
            } else {
                int n = numberStack.pop();
                StringBuilder inner = new StringBuilder();
                StringBuilder prev = new StringBuilder(charStack.pop());
                for (int j = 0; j < n; j++) {
                    inner.append(sb);
                }


                prev.append(inner);
                sb = new StringBuilder();
                sb.append(prev);
            }
        }
        return sb.toString();
    }
}
