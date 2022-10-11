package com.crackingcodeinterview.chapter1;

public class CheckPermutation_1_2 {
    public boolean CheckPermutation(String s1, String s2) {
        int arr[] = new int[26];
        for (char ch : s1.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch : s2.toCharArray()) {
            arr[ch - 'a']--;
            if (arr[ch - 'a'] < 0) return false;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
}
