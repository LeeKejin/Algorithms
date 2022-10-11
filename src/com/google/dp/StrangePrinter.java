package com.google.dp;

/**
 * - For each of the string 's'
 * - If 's' has a length of 1
 * - Then we can use 1 turn to generate the string
 * - If 's' has a length of greater than 1
 * - We can partition the string into substrings 'x' and 'y'
 * - Then we can find the turns of both of the substrings
 * - Then the number of turns of 's' will be 'turns(x) + turns(y)'
 * - Since, we want the smallest number of turns
 * - We will want to pick the index 'k' that will give us
 * the partition that will give us the smallest number of turns
 * - A side case we have to handle is when the first character is
 * equal to the last character
 * - Then we have to decrement the number of turns by 1
 * - Examples: "aa"
 * - We do not want 1 + 1 = 2, because the printer can
 * generate a sequence of the same characters
 * - We will want to decrement it to '2 - 1 = 1'
 * - We can keep track of our current left 'i' and right 'j' boundaries
 * of the input string and find the minimum number of turns
 */
public class StrangePrinter {
    public int strangePrinter(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[][] state = new int[n][n];

        for (int i = 0; i < n; i++) {
            state[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int dist = 1; dist + i < n; dist++) {
                int j = dist + i;
                if (dist == 1) {
                    state[i][j] = (s.charAt(i) == s.charAt(j)) ? 1 : 2;
                    continue;
                }
                state[i][j] = Integer.MAX_VALUE;
                for (int k = i; k + 1 <= j; k++) {
                    int tmp = state[i][k] + state[k + 1][j];
                    state[i][j] = Math.min(state[i][j], tmp);
                }
                if (s.charAt(i) == s.charAt(j)) {
                    state[i][j]--;
                }
            }
        }

        return state[0][n - 1];
    }
}
