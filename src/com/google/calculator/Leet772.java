package com.google.calculator;

import java.util.Stack;

public class Leet772 {
    /*
    + - * / ()
     */
    public int calculate(String s) {
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        char exp = ' ';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '-' || ch == '+') {
                num *= sign;
                stack.push(num);
                num = 0;
                sign = ch == '-' ? -1 : 1;
                processExp(stack, exp);
                exp = ' ';
            } else if (ch == '*' || ch == '/') {
                num *= sign;
                stack.push(num);
                num = 0;
                sign = 1;
                processExp(stack, exp);
                exp = ch;
            } else if (ch == '(') {
                int j = i + 1;
                int braces = 1;

                while (j < s.length()) {

                    if (s.charAt(j) == '(') braces++;
                    if (s.charAt(j) == ')') braces--;

                    if (braces == 0) break;
                    j++;

                }
                num = calculate(s.substring(i + 1, j));
                i = j;
            }
        }
        stack.push(num * sign);
        processExp(stack, exp);
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private void processExp(Stack<Integer> stack, char exp) {
        if (exp == ' ') return;
        int v1 = stack.pop();
        int v2 = stack.pop();
        if (exp == '*') {
            stack.push(v1 * v2);
        }
        if (exp == '/') {
            stack.push(v2 / v1);
        }
    }
}
