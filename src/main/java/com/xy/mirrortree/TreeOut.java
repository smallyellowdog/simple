package com.xy.mirrortree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeOut {
    public static void main(String[] args) {
        TreeNode root = TreeNodeTool.initData();
        List<String> treeData = outTree(root);
        System.out.print(treeData);
    }

    /**
     *层序便利二叉树,利用队列实现
     */
    private static List<String> outTree(TreeNode root){
        if(root == null){
            return new ArrayList<String>();
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        List<String> nodeDataList = new ArrayList<String>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            nodeDataList.add(node.getData());
            if(node.getLeft() != null){
                queue.add(node.getLeft());
            }
            if(node.getRight() != null){
                queue.add(node.getRight());
            }
        }
        return nodeDataList;
    }
}
