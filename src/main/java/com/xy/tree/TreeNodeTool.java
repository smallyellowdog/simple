package com.xy.tree;

public class TreeNodeTool {
    public static TreeNode initData(){
        TreeNode root = new TreeNode();
        root.setData("1");

        TreeNode left1 = new TreeNode();
        left1.setData("2");

        TreeNode right1 = new TreeNode();
        right1.setData("3");

        root.setLeft(left1);
        root.setRight(right1);

        TreeNode left1Left = new TreeNode();
        left1Left.setData("4");

        TreeNode left1Right = new TreeNode();
        left1Right.setData("5");

        left1.setLeft(left1Left);
        left1.setRight(left1Right);

        TreeNode right1Left = new TreeNode();
        right1Left.setData("6");

        TreeNode right1Right = new TreeNode();
        right1Right.setData("7");

        right1.setLeft(right1Left);
        right1.setRight(right1Right);

        return root;
    }
}
