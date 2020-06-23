package com.codeWithArsalon.LinearDS;

import java.util.NoSuchElementException;

public class StackUsingLinkList {
    private Node first;
    private Node last;
    private int size;

    private class Node { //embedded class "implementation detail"
        int value;
        private Node next;

        public Node (int value){ //constructor w/in the Node class
            this.value = value;
        }
    }


    public void push(int item){ //addFirst() from LinkedList / O(1) operation
        var node = new Node(item);

        if(isEmpty())
            first = last = node;

        node.next = first;
        first = node;
        size++;
    }

    public Node pop(){ //removeFirst() from LinkedList O(1) operation
        if(isEmpty())
            throw new NoSuchElementException();
        else {
            var top = first;
            var second = first.next;
            first.next = null;
            first = second;
            size--;
            return top;
        }
    }

    public void peek() {
        System.out.println(first.value);
    }

    private boolean isEmpty() {
        return first == null;
    }
}
