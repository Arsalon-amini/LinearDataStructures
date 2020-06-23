package com.codeWithArsalon.LinearDS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>(); //O(2n) or O(n) operation because iterate str.toCharArray x 2

        var chars = str.toCharArray(); //cast string into another type (character Array)
        for (var ch : chars) { //O(n) operation
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }
        for (var ch : chars) //O(n) operation
            if (map.get(ch) == 1) //O(1) operation pass key, return value
                return ch;

        return Character.MIN_VALUE;
    }

    public char findFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();
        for (var ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE; //none of the characters are repeated!
    }
}
