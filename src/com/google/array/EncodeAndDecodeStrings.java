package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        if (strs.isEmpty()) return Character.toString((char) 258);
        String space = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
            sb.append(space);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.equals(Character.toString((char) 258))) return new ArrayList<>();
        String[] strs = s.split(Character.toString((char) 257), -1);
        List<String> list = new ArrayList<>();
        for (String str : strs) {
            list.add(str);
        }
        return list;
    }
}
