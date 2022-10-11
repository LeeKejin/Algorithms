package com.google.array.read4;

public class Read4II {
    char[] buf4 = new char[4];

    int buf4Index = 0;
    int lastSize = 0;

    //everytime start with 0
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (buf4Index == 0) {
                lastSize = read4(buf4);

                if (lastSize == 0) break;
            }

            while (buf4Index < lastSize && index < n) {
                buf[index] = buf4[buf4Index];
                buf4Index++;
                index++;
            }
            if (buf4Index == lastSize) {
                buf4Index = 0;
                lastSize = 0;
            }
        }
        return index;

    }
//
//    char[] buf4 = new char[4];
//
//    int buf4Index = 0;
//    int lastSize = 0;

    /*
    read left chars in buf4, then start new loop
     */
    public int read1(char[] buf, int n) {
        int index = 0;
        if (buf4Index != 0) {
            while (index < n && buf4Index < lastSize) {
                buf[index] = buf4[buf4Index];
                index++;
                buf4Index++;
            }
            if (index == n) return index;
            buf4Index = 0;
            lastSize = 0;
        }
        lastSize = read4(buf4);
        if (lastSize == 0) return index;
        while (lastSize > 0 && index < n) {
            while (buf4Index < lastSize) {
                buf[index] = buf4[buf4Index];
                index++;
                buf4Index++;
                if (index == n) return index;
            }
            lastSize = read4(buf4);
            buf4Index = 0;
        }
        return index;

    }

    private int read4(char[] buf4) {

        return 0;
    }
}
