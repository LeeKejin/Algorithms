package com.amazon.interview.bfs;

import com.algorithms.binary.search.tree.leetcode.TreeNode;

/*
原题	力扣解题	重点
0112-路径总和	链接	任意顺序遍历+BFS
0102-二叉树的层序遍历	链接	递归+BFS
0145-二叉树的后序遍历	链接	后序遍历(递归+迭代)
0144-二叉树的前序遍历	链接	前序遍历(递归+迭代)
0199-二叉树的右视图	链接	BFS
0094-二叉树的中序遍历	链接	中序遍历(递归+迭代)
0173-二叉搜索树迭代器	链接	中序遍历(递归+迭代)
0783-二叉搜索树节点最小距离	链接	中序遍历(递归+迭代)
0230-二叉搜索树中第K小的元素	链接	中序遍历(递归)
0285-二叉搜索树中的中序后继	链接	中序遍历(递归+迭代)
0671-二叉树中第二小的节点	链接	中序遍历(递归)
0098-验证二叉搜索树	链接	中序遍历(递归)
 */
public class Leet98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    long pre = Long.MIN_VALUE;

    public boolean isValidBSTFasterSolution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    TreeNode prev = null;

    public boolean isValidBSTNode(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (!left) return false;
        if (prev != null && root.val <= prev.val) return false;
        prev = root;
        return isValidBST(root.right);
    }
}
