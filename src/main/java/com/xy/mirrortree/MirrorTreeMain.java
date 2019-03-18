package com.xy.mirrortree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一个树是否是对称树
 */
public class MirrorTreeMain {

    public static void main(String[] args) {
        TreeNode root = TreeNodeTool.initData();
        //递归方法
        boolean flag = queueTree(root);
        System.out.print(false);
        //队列迭代
        //queueTree(root);
    }
    private static boolean isMirror(TreeNode treeNode1,TreeNode treeNode2){
        if(treeNode1 == null && treeNode2 == null){
            return true;
        }
        if(treeNode1 != null && treeNode2 != null){
            return treeNode1.equals(treeNode2) &&
                    isMirror(treeNode1.getLeft(),treeNode2.getRight()) &&
                    isMirror(treeNode1.getRight(), treeNode2.getLeft());
        }
        return false;
    }

    private static boolean queueTree(TreeNode treeNode){
        Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();

        treeNodeQueue.add(treeNode);
        treeNodeQueue.add(treeNode);

        while (!treeNodeQueue.isEmpty()){
            TreeNode treeNode1 = treeNodeQueue.poll();
            TreeNode treeNode2 = treeNodeQueue.poll();

            if(treeNode1 == null && treeNode2 == null){
                continue;
            }

            if(treeNode1 == null || treeNode2 == null){
                return false;
            }

            if(!treeNode1.equals(treeNode2)){
                return false;
            }

            treeNodeQueue.add(treeNode1.getLeft());
            treeNodeQueue.add(treeNode2.getRight());
            treeNodeQueue.add(treeNode1.getRight());
            treeNodeQueue.add(treeNode2.getLeft());

        }
        return true;
    }
}
