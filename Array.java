package com.codeWithArsalon.LinearDS;

public class Array {
    private int[] items;
    private int[] newItems;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void addItem(int item) {
        resizeIfRequired();

        items[count++] = item; //place item at count index and increment the count afterwards
    }

    private void resizeIfRequired() {
        if (items.length == count) { //if the array is full, resize
            newItems = new int[count * 2];

            for (int i = 0; i < count; i++) //copy values from old array to new array
                newItems[i] = items[i];

            items = newItems; //set internal array items to new form
        }
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException(); //check if index is valid, if not return -1
        for (int i = index; i < count; i++)
            items[index] = items[index + 1]; //copying items "left" (i + 1) into location index (i)
    }

    public Array intersect(Array other) {
        var intersection = new Array(count);

        for (int item : items)
            if (other.indexOf(item) >= 0) //if item exists in second array, will return value, otherwise -1
                intersection.addItem(item); //if item returns value, it exists in second array, store in new array

        return intersection;
    }

    public int indexOf(int item){
        for (int i = 0; i < count; i++)
            if(item == items[i]) //look for item in each index
                return i; //if found, return index
            return -1; //else return -1
        }

    public int max() {
        int max = 0;
        for (int item : items)
            if (item > max)
                max = item;

        return max;
    }

    public int [] reverse (){
        int [] reverse = new int [count];

        for (int i = 0; i < count; i++)
            reverse[i] = items[count - i - 1];

        return reverse;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        resizeIfRequired();

        for (int i = count - 1; i >= index; i--) //copies "shifts" items right, until index - 1 spot
            items[i + 1] = items[i]; //breaks out of loop

        items[index] = item; //assigns items to index spot
        count++;
    }

}




