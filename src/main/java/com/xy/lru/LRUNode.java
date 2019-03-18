package com.xy.lru;

public class LRUNode<T> {
    private int score;
    private T value;
    private String key;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
