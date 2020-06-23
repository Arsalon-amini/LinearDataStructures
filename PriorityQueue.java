package com.codeWithArsalon.LinearDS;

import java.util.Arrays;

public class PriorityQueue {
    //priority queue using an array

    private int [] items = new int[5];
    private int [] newItems;
    private int count;

    public void enqueue(int item) {
        resizeIfRequired();

        int i = shiftItemsToInsert(item);
        items[i] = item; //inserting at i + 1 position (next right spot)
        count++;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) { //sorting algorithm
            if (items[i] < item) //smallest numbers to the right
                items[i + 1] = items[i]; //shifting "copying" items right to make space to insert value at index
            else
                break;
        }
        return i + 1; //to return exact index
    }

    private void resizeIfRequired() {
        if(isFull()) {
            newItems = new int[count * 2]; //creating a 2x larger array
            for (int i = 0; i < count; i++)
                newItems[i] = items[i]; //copying values at each index into the new array
            items = newItems;
        }
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

       return items[--count]; //changes count but doesn't remove item from array, could use circular array/shifting
    }

    public boolean isEmpty(){
        return count == 0 ;
    }


    private boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }

}
