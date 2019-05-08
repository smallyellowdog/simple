package com.xy.lru;

/**
 * 利用链表实现LRU算法
 * 最近一段时间，最少用到的数据 淘汰
 * 新来数据->判断链表中是否有，有的话提到链表的首部，没有的话新插入首部
 */
public class LinkListLRU {
    public static void main(String[] args) {
        //假设现在规定内存，list长度最多为50个；
        MyLinkList<String> myLinkList = new MyLinkList<String>();
        for(int i=0;i<50;i++){
            myLinkList.add("h" + i );
        }

        //lruCache(myLinkList,"h50");

        //System.out.println(myLinkList.out());

        lruCache(myLinkList,"h30");
        lruCache(myLinkList,"h30");
        lruCache(myLinkList,"h30");

        System.out.println(myLinkList.out());


    }
    private static void lruCache(MyLinkList<String> myLinkList,String value){
            if(myLinkList.size() >50){
                //去除最后一个
                myLinkList.remove(myLinkList.size() - 1 );
            }
            int index = myLinkList.checkIsInList(value);
            if(index == -1){
                //插到链表的首部
                myLinkList.add(value,0,-1);
            }else{
                //删除原来的位置
                myLinkList.remove(index);
                //插到首部
                myLinkList.add(value,0,-1);

        }
    }
}
