package com.algorithms.dynamicprogramming;

import com.crackingcodeinterview.util.ListNode;
import com.google.tree.TreeNode;
import com.google.tree.utility.TreeUtil;
import com.sun.xml.internal.txw2.output.DumpSerializer;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Test {
    private static final int MOD = 1000000007;
    boolean flag = false;
    Set<Integer> set = new HashSet<>();

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) return "";
        int i;
        char chs[] = palindrome.toCharArray();

        for (i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) != 'a') break;
        }
        if (i == palindrome.length() / 2) {

            chs[palindrome.length() - 1] = 'b';
            return String.valueOf(chs);
        }
        chs[i] = 'a';
        return String.valueOf(chs);
    }

    public static void main(String[] args) {
        Test test = new Test();

        TreeNode node = TreeUtil.deserialize("[5,3,6,2,4,null,7]");
//        test.threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2);
        test.findTarget(node, 9);
    }
}
