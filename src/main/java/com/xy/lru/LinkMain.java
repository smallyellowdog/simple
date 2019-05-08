package com.xy.lru;

public class LinkMain {
    public static void main(String[] args) {
        MyLinkList<String> linkList = new MyLinkList<>();
        linkList.add("哈哈");
        linkList.add("嘿嘿");
        linkList.add("呵呵");
        linkList.add("嘎嘎");
        linkList.add("哦哦");
        linkList.remove(2);

        System.out.println(linkList.out());
    }
}
