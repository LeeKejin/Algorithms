package com.google.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leet227 {
    /*
    Cal with + - * / only
    * */
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char exp = ' ';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-') {
                num *= sign;
                sign = -1;
                stack.push(num);
                num = 0;
                processExp(stack, exp);
                exp = ' ';
            }
            if (ch == '+') {
                num *= sign;
                stack.push(num);
                num = 0;
                sign = 1;
                processExp(stack, exp);
                exp = ' ';
            }
            if (ch == '*' || ch == '/') {
                num *= sign;
                stack.push(num);
                num = 0;
                sign = 1;
                processExp(stack, exp);
                exp = ch;
            }

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
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
        if (exp != ' ') {
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


    Stack<Integer> numStack = new Stack<>();
    Stack<Character> optStack = new Stack<>();

    public int calculateWith2Stacks(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                numStack.push(num);
                num = 0;
                while (!optStack.isEmpty() && map.get(optStack.peek()) >= map.get(ch)) {
                    reCal();
                }
                optStack.push(ch);

            }
        }
        numStack.push(num);
        while (!optStack.isEmpty()) {
            reCal();
        }
        return numStack.pop();
    }

    private void reCal() {
        int n1 = numStack.pop();
        int n2 = numStack.pop();
        char opt = optStack.pop();
        if (opt == '+') {
            numStack.push(n1 + n2);
        } else if (opt == '*') {
            numStack.push(n1 * n2);
        } else if (opt == '-') {
            numStack.push(n2 - n1);
        } else if (opt == '/') {
            numStack.push(n2 / n1);
        }
    }

}
