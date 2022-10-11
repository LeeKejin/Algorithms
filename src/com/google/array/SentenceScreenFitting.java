package com.google.array;

public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int currRow = 0;
        int spaceLeft = cols;
        int cycles = 0;

        for (String w : sentence) {
            if (w.length() > cols) {
                return 0;
            }
        }

        while (currRow < rows) {
            for (String word : sentence) {
                if (spaceLeft - word.length() >= 0) {
                    spaceLeft -= word.length();
                    spaceLeft--;
                } else {
                    currRow++;
                    spaceLeft = cols;
                    spaceLeft -= word.length();
                    spaceLeft--;
                }
                if (currRow == rows) return cycles;
            }
            cycles++;
        }
        return cycles;
    }

    /*
    1.Based on the above observation, in the first for loop we compute the number of words that can be placed in the row
    if ith word is used as the starting word. This is saved as dp[i]. Note that this value can be greater than n.
    2.In the next for loop we calculate how many words are placed in each row based on dp[i].
    Imagine placing the 0th word in the row-0, then this row will hold dp[0] words. Next, which word will be placed
    on the start of next row? We calculate that using dp[k] % n (Remember dp[i] can be greater than n).
     */
    public int wordsTyping1(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int length = 0, words = 0, index = i;
            while (length + sentence[index % n].length() <= cols) {
                length += sentence[index % n].length();
                length += 1; // space
                index++;
                words++;
            }
            dp[i] = words;
        }

        int words = 0;
        for (int i = 0, index = 0; i < rows; i++) {
            words += dp[index];
            index = (dp[index] + index) % n;
        }

        return words / n;
    }

    /**
     * Brutial force
     */
    /*
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int row = 0;
        int i = 0;
        int res = 0;
        while (row < rows) {

            int count = 0;
            while (count < cols) {
                if (i == sentence.length) {
                    res++;
                    i = 0;
                }
                if (count + sentence[i].length() + 1 <= cols) {
                    count += sentence[i].length() + 1;
                    i++;
                } else if (count + sentence[i].length() == cols) {
                    count += sentence[i].length();
                    i++;
                } else {
                    break;
                }
            }
            row++;
        }
      if(i==sentence.length)res++;
        return res;
    }

     */
}
