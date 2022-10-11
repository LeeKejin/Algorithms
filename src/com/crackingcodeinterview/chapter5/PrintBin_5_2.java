package com.crackingcodeinterview.chapter5;

import com.google.tree.TreeNode;

import java.util.Arrays;

public class PrintBin_5_2 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        int count = 32;
        while (num != 0 && count > 0) {
            num *= 2;
            if (num >= 1) {
                sb.append("1");
                num -= 1;
            } else {
                sb.append("0");
            }
            count--;
        }
        if (sb.length() >= 32) return "ERROR";
        return "0." + sb;
    }

  
}
