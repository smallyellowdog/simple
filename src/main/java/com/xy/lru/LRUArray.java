package com.xy.lru;

/**
 * 利用数组实现lru算法（Least Recently Used）
 */
public class LRUArray<T> {

    private static final int defaultScore = 0;

    private int maxLength;

    private int defaultLength = 10;

    LRUNode<T>[] lruNodes = new LRUNode[defaultLength];

    public LRUNode<T> get(String key){
        for (LRUNode lruNode : lruNodes){
            if(lruNode.getKey().equals(key)){
                lruNode.setScore(defaultScore);
                return lruNode;
            }
        }
        return null;
    }

    public void put(String key,T t){
        if(lruNodes.length > maxLength){
            return;
        }

        LRUNode lruNode = new LRUNode();
        lruNode.setScore(defaultLength);
        lruNode.setKey(key);
        lruNode.setValue(t);


    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
