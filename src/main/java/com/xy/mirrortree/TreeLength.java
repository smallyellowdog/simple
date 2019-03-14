package com.xy.mirrortree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 二叉树的深度
 */
public class TreeLength {
    public static void main(String[] args) {

    }

    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.getLeft());
        int rightHeight =  maxDepth(root.getRight());

        return Math.max(leftHeight,rightHeight) + 1;
    }
}
