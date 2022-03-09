package com.google.array.read4;

public class Leet157 {
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int size = read4(buf4);
        int index = 0;
        while (size > 0 && index < n) {
            for (int i = 0; i < size && index < n; i++) {
                buf[index] = buf4[i];
                index++;
            }
            size = read4(buf4);
        }
        // you cannot return n or n-1, it must be index, as file may not have n chars
        return index;
    }

    //use read4 read from file, then save to buff, every time read n charss
    private int read4(char[] buf4) {

        return 0;
    }
}
