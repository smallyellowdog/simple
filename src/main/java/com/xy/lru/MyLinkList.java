package com.xy.lru;

import java.util.LinkedList;
import java.util.List;

/**
 * 自定义链表,线程不安全
 */
public class MyLinkList<T> {

    private Node<T> first;

    private Node<T> last;

    private int size = 0;

    private int modifyCount = 0;

    /**
     * 添加元素
     * @param t
     */
    public void add(T t){
        Node<T> node = last;
        Node<T> newNode = new Node<>(node,null,t);
        last = newNode;
        if(node == null){
            first = newNode;
        }else{
            node.setNext(newNode);
        }
        size++;
        modifyCount++;
    }

    /**
     * 指定位置添加元素
     * @param t data,index 下角标,dir 前后
     */
    public void add(T t,int index,int dir){
        Node<T> node = node(index);
        if(dir == 1){//next
           Node<T> newNode = new Node<T>(node,node.getNext(),t);
            node.setNext(newNode);
            if(index == size - 1){
                last = newNode;
            }
        }else{//pre
            Node<T> newNode = new Node<T>(node.getPre(),node,t);
            node.setPre(newNode);
            if(index == 0){
                first = newNode;
            }
        }
        size++;
        modifyCount++;
    }


    /**
     * 删除元素
     * @param index
     */
    public void remove(int index){

        modifyCount++;
        size--;

        Node node = node(index);

        if(index == 0){
            node.getNext().setPre(null);
            first = node.getNext();
            return;
        }

        if(index == size - 1){
            node.getPre().setNext(null);
            last = node.getPre();
            return;
        }

        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());

    }

    /**
     * 通过下角标获取元素
     * @param index
     * @return
     */
    public T get(int index){
        return node(index).getData();
    }

    /**
     * 获取节点
     * @param index
     * @return
     */
    public Node<T> getNode(int index){
        return node(index);
    }

    /**
     * 判断元素是否在list里面
     */

    /**
     * 输出所有的元素
     * @return
     */
    public String out(){
        StringBuffer stringBuffer = new StringBuffer();
        Node<T> node = first;
        while (node.getNext() != null){
            stringBuffer.append(node.toString()+",");
            node = node.getNext();
        }
        /**
         *最后一个元素
         */
        stringBuffer.append(node.toString());
        return stringBuffer.toString();
    }
    private Node<T> node(int index){
        Node<T> node = null;
        /**
         * TODO 这个地方可以优化,如何集合元素很大的话可以递归二分
         */
        if(index == 0){
            return first;
        }
        if(index == size -1){
            return last;
        }

        if(index < (size >> 2)){
            node = first;
            for (int i = 0; i < index ; i++){
                node = node.getNext();
            }
        }else{
            node = last;
            for(int x=size-1;x>index;x--){
                node = node.getPre();
            }
        }
        return node;
    }

    /**
     * 判断元素是否在即集合里
     * @param t
     * @return
     */
    public int checkIsInList(T t){
        Node<T> node = first;
        int index = 0;
        if(node == null){
            return -1;
        }
        while(node.getNext() != null){
            if(node.getData().equals(t)){
                return index;
            }
            node = node.getNext();
            index++;
        }
        return -1;
    }

    /**
     * 链表长度
     * @return
     */
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkList{" +
                "last=" + last +
                '}';
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

}
