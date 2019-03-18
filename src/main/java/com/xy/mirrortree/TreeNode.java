package com.xy.mirrortree;

public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private String data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode treeNode = (TreeNode) o;

        return data.equals(treeNode.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
