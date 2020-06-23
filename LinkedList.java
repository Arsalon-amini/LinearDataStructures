package com.codeWithArsalon.LinearDS;

import java.util.NoSuchElementException;
    // addFirst - O(1)
    // addLast - O(1)
    // removeFirst - O(1) - update head to point to next item
    // RemoveLast - O(n)
    // contains - O(n) - traverses entire list to look for item (worst case))
    // indexOf - O(n) - traverses entire list to look for item (worst case))
    //toArray - O(n) - traverse entire list of nodes, storing into an array
    //getPrevious - O(n) - traverse entire list
    //reverse - O(n) -

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) { //constructor for the node class
            this.value = value;
        }
    }

    public void addFirst(int item) {
        //O(1) operation, just update tail's direction

        var node = new Node(item); //create a new node object, set .value = item

        if (isEmpty())  //sets first and last to this new node
            first = last = node;
        else {
            node.next = first; //otherwise prepend to list (set head)
            first = node;
        }

        size ++;
    }

    public void addLast(int item) {
        //O(1) operation - because don't have to traverse the list of nodes

        var node = new Node(item); //creating a new Node with the value set to item passed in as argument

        if (isEmpty())  //if list is empty, sets first and last to this node
            first = last = node;
        else {
            last.next = node; //add node after last node
            last = node; //update last to point to this new node in the list
        }
        size ++;
    }

    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last)  //means we have a single node (item) in list
            first = last = null; //set single node to null, don't execute following logic
        else {
            var second = first.next; //store the reference to the second node + other node (chain) in the list
            first.next = null; //removes link to other nodes
            first = second; //sets second node to first
        }
        size--;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last)  //means single node in list
            first = last = null; //set the single node to null
        else{
            var previous = getPrevious(last); //O(n) operation
            last = previous; //shrinks our list (makes tail second to last node)
            last.next = null; //cuts the connection with the end node
        }
        size --;
    }

    public int indexOf(int item) {
        int index = 0; //declare a variable to keep track index = 0 ; increment index

        var current = first;
        while (current != null) {  //means haven't reached end of our list
            if (current.value == item)
                return index; //iterate over the list comparing index of current node with parameter index
            current = current.next; //move current variable reference to next node in list
            index++;
        }
        return -1;

    }

    public boolean contains(int item) {

        return indexOf(item) != -1; //if this evaluates true, we have item in list, returns true

    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null){
            if(current.next == node) return current; //if the next node is our value, we got previous node, return current
            current = current.next; //else, update pointer to next node in the list
        }
        return null; //if the node isn't found
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int size (){
        return size;
    }

    public int [] toArray(){
        int [] array = new int[size];

        var current = first;
        var index = 0;

        while(current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse(){
        if(isEmpty()) return;

        var previous = first;
        var current = first.next;
        while(current != null){
            var next = current.next; //set point a
            current.next = previous;//reverse link
            previous = current; //move point a
            current = next; //move point b
        }

        last = first; //sets the last node
        last.next = null; //de-links old reference of the final node
        first = previous;
    }

    public int getKthFromEnd(int k){
        if(isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;

        for(int i = 0; i < k - 1; i++) { //setting point a kth distance behind b
            b = b.next;
            if (b == null) //moving b to an invalid k value parameter
                throw new IllegalArgumentException();
        }

        while(b != last) {
            b = b.next; //move point b forward until end of list
            a = a.next; //move point a forward until b is at end of list
        }
        return a.value; //return value of kth node at position a
    }



}



