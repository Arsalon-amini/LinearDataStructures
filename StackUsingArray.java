package com.codeWithArsalon.LinearDS;

import java.util.Arrays;

public class StackUsingArray {

    private int [] items = new int[5];
    private int [] newItems;
    private int count;


    public void push (int item){
            resizeIfRequired();

        items[count++] = item;
    }

    private void resizeIfRequired() {
        if (items.length == count) {
            newItems = new int[count * 2];

            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
    }

    public int pop (){
        if(count == 0)
            throw new IllegalStateException();
        return items[--count];
    }

    public int peek(){
        if(count == 0)
            throw new IllegalStateException();

        return items[count - 1];
    }

    public boolean isEmpty(){
        return count == 0;
    }


    @Override
    public String toString(){
        var array = Arrays.copyOfRange(items, 0 , count); //copies array contents from 0 to count into separate array
        return Arrays.toString(array);
    }

    public int [] getStack(){
        return items;
    }
}
