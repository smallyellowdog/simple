package com.xy.lru;

/**
 * 利用数组实现lr算法（Least Recently Used）
 */
public class LRUArray<T> {

    private int maxLength;

    private int defaultLength = 10;

    LRUNode<T>[] lruNodes = new LRUNode[defaultLength];


    public LRUArray(int maxLength) {
        this.maxLength = maxLength;
    }

    public LRUNode<T> get(String key){

        return null;
    }
}
