package com.xy.lru;

/**
 * 节点
 * @param <T>
 */
public class Node<T> {
    private Node<T> pre;
    private Node<T> next;
    private T data;

    public Node<T> getPre() {
        return pre;
    }

    public void setPre(Node<T> pre) {
        this.pre = pre;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node(Node<T> pre, Node<T> next, T data) {
        this.pre = pre;
        this.next = next;
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
