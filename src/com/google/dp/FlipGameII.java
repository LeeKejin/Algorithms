package com.google.dp;

import java.util.HashMap;
import java.util.Map;

public class FlipGameII {
    Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String currentState) {
        if (currentState == null && currentState.length() < 2) return false;
        if (map.containsKey(currentState)) return map.get(currentState);
        for (int i = 1; i < currentState.length(); i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i - 1) == '+') {
                String before = currentState.substring(0, i - 1);
                String after = currentState.substring(i + 1);
                boolean b = canWin(before + "--" + after);
                map.put(before + "--" + after, b);
                if (!b) return true;
            }
        }
        return false;
    }
}
