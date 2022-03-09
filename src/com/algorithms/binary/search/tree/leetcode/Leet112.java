package com.algorithms.binary.search.tree.leetcode;

public class Leet112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

//    public static boolean hasPathSumWithStack( TreeNode root, int sum )
//    {
//        if ( root == null ) return false;
//        Stack< Pair< TreeNode, Integer > > stack = new Stack<>();
//        Pair< TreeNode, Integer > rootPair = new Pair<>( root, sum - root.val );
//        stack.push( rootPair );
//        while ( !stack.isEmpty() )
//        {
//            Pair< TreeNode, Integer > pair = stack.pop();
//            int size = stack.size();
//            if ( pair.getKey().left != null )
//            {
//                stack.push( new Pair<>( pair.getKey().left, pair.getValue() - pair.getKey().left.val ) );
//            }
//
//            if ( pair.getKey().right != null )
//            {
//                stack.push( new Pair<>( pair.getKey().right, pair.getValue() - pair.getKey().right.val ) );
//            }
//            if ( pair.getValue() == 0 && stack.size() == size ) return true;
//        }
//        return false;
//
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

//        System.out.println( hasPathSumWithStack( root, 22 ) );
        //        System.out.println( 1 << 3 );
    }
}
