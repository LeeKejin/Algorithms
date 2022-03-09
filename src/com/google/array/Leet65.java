package com.google.array;

public class Leet65 {
    class Solution {
        public boolean isNumber(String s) {
            if (s.length() == 0) return false;
            s = s.toLowerCase();
            int eNum = 0;
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    if (s.charAt(i) == 'e') {
                        eNum++;
                    }
                }
            }
            if (eNum > 1) return false;
            String[] parts = s.split("e");
            if (parts.length > 2) return false;
            if (parts.length == 2) {
                System.out.println(s);

                boolean front = check(parts[0]);
                boolean back = checkInt(parts[1]);
                return front && back;
            }
            return check(s);
        }

        private boolean checkInt(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                    if (i != 0 || i == s.length() - 1) return false;
                } else if (s.charAt(i) == '.') return false;
                else if (!Character.isDigit(s.charAt(i))) return false;
                count++;
            }
            return count != 0;
        }

        private boolean check(String s) {
            boolean isPoint = false;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                    if (i != 0) return false;
                } else if (s.charAt(i) == '.') {
                    if (isPoint) return false;
                    isPoint = true;

                } else if (!Character.isDigit(s.charAt(i))) return false;
                else if (Character.isDigit(s.charAt(i))) count++;
            }
            return count != 0;
        }

    }
}
