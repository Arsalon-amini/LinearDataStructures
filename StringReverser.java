package com.codeWithArsalon.LinearDS;


import java.util.Stack;

public class StringReverser {

    public String reverse (String input) {
        if (input == null)
            throw new IllegalArgumentException(); //prevents null edge case

        var stack = new Stack<>();

        for (char ch : input.toCharArray()) //push each character in string to stack
            stack.push(ch);

        var reversed = new StringBuffer();
        while(!stack.empty())
            reversed.append(stack.pop()); //pop each character into reverse string (LIFO)

        return reversed.toString();
    }
}
