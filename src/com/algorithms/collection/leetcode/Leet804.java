package com.algorithms.collection.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leet804
{
    public int uniqueMorseRepresentations( String[] words )
    {
        String[] arr =
            new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        Set< String > set = new HashSet<>();
        for ( String word : words )
        {
            StringBuilder sb = new StringBuilder();
            for ( char ch : word.toCharArray() )
            {
                int num = ch;
                sb.append( arr[ num - 97 ] );
            }
            set.add( sb.toString() );
        }
        return set.size();
    }
}
