package com.codeWithArsalon.LinearDS;

import java.util.LinkedList;
//Big-O analysis
//put is O(1) for array and 0(1) for collision values, bcuz addLast & addFirst = O(1) LinkedList
//getEntry is O(n) operation, iterate a LinkedList
//remove is O(n) because iterate LinkedList search by value

public class HashMap {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5]; //Underlying data structure: Array w/ embedded LinkedLists

    private int hash(int key) {
        return Math.abs(key) % entries.length; //returns index position in an array of n length
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }
        getOrCreateBucket(key).addLast(new Entry(key, value)); //returns Entry object
    }
    public String getValue(int key) {
        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);
        var bucket = entries[index];
        if (bucket == null)
            entries[index] = new LinkedList<>();

        return bucket;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);

    }
}
