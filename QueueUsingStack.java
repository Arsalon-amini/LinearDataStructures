package com.codeWithArsalon.LinearDS;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> stackOne = new Stack<>();
    private Stack<Integer> stackTwo = new Stack<>();

    //O(1) operation
    public void enqueue(int item) {
        stackOne.push(item);
    }

    //O(n) operation
    public int dequeue() {
        if (isEmpty()) //more meaningful exception
            throw new IllegalStateException();
        moveStackOneToStackTwo(); //refactored
        return stackTwo.pop();
    }


    public int peek() {
        if (isEmpty()) //more meaningful exception
            throw new IllegalStateException();
        moveStackOneToStackTwo(); //refactored
        return stackTwo.peek();

    }

    private void moveStackOneToStackTwo() {
        if (stackTwo.isEmpty()) {
            while (!stackOne.isEmpty())
                stackTwo.push(stackOne.pop()); //reversing stack order
        }
    }

    public boolean isEmpty () {
            return stackOne.isEmpty() && stackTwo.isEmpty();
        }

}
