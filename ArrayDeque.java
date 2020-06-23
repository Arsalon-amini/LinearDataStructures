package com.codeWithArsalon.LinearDS;

import java.util.Arrays;

//

public class ArrayDeque {
    private int [] items;
    private int rear;
    private int front;
    private int count;


    public ArrayDeque(int capacity){
         this.items = new int [capacity]; //pass in capacity of queue
    }

    public void enqueue(int item){
        if(count == items.length)
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length; //set rear at next index position (circular indexing formula)
        count ++;
        }

     public int dequeue(){
        var item = items[front]; //storing the item at front
        items[front] = 0;
        front = (front + 1) % items.length; //circular array index formula
        count--;
        return item; //returning the item replace by zero
     }

     public int peek (){
        return items[front];
     }

     public boolean isEmpty(){
        return count == 0;
     }

    @Override
    public String toString(){
        return Arrays.toString(items); //using Array class toString method to convert items array into a string.

    }
}



