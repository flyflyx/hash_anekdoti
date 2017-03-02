package ru.mirea.hash;

import java.util.ArrayList;

public class MyHashTable {

    private ArrayList<Bucket> buckets = new ArrayList<>();

    public MyHashTable(int n) {
        for (int i = 0; i < n; i++) {
            buckets.add(new Bucket());
        }
    }

    private Bucket getBucket(String k) {
        int h = Math.abs(k.hashCode() % buckets.size());
        return buckets.get(h);
    }

    public String get(String k) {
        Bucket b = getBucket(k);
        for (Pair p : b.list) {
            if (p.key.equals(k)) {
                return p.value;
            }
        }
        return null;
    }

    public void add(String k, String v) {
        Bucket b = getBucket(k);
        for (Pair p : b.list) {
            if (p.key.equals(k)) {
                p.value = v;
                return;
            }
        }
        b.list.add(new Pair(k, v));
    }
}
