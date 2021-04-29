package com.algorithms.binary.search.tree.leetcode;

public class Leet236_1
{
    public TreeNode lowestCommonAncestor1( TreeNode root, TreeNode p, TreeNode q )
    {
        if ( root == null || root == p || root == q ) return root;
        TreeNode left = lowestCommonAncestor( root.left, p, q );
        TreeNode right = lowestCommonAncestor( root.right, p, q );
        if ( left == null ) return right;
        if ( right == null ) return left;
        return root;
    }

    public static TreeNode lowestCommonAncestorSlowSolution( TreeNode root, TreeNode p, TreeNode q )
    {
        if ( root == null || root.val == p.val || root.val == q.val ) return root;
        if ( find( root.left, p ) && find( root.left, q ) ) return lowestCommonAncestorSlowSolution( root.left, p, q );
        if ( find( root.right, p ) && find( root.right, q ) )
            return lowestCommonAncestorSlowSolution( root.right, p, q );
        return root;

    }

    private static boolean find( TreeNode root, TreeNode node )
    {
        if ( root == null ) return false;
        if ( root.val == node.val ) return true;
        return find( root.left, node ) || find( root.right, node );
    }

    public static TreeNode lowestCommonAncestor( TreeNode root, TreeNode p, TreeNode q )
    {
        if ( root == null || root.val == p.val || root.val == q.val ) return root;
        TreeNode left = lowestCommonAncestor( root.left, p, q );
        TreeNode right = lowestCommonAncestor( root.right, p, q );
        if ( left == null )
        {
            return right;
        }

        if ( right == null )
        {
            return left;
        }
        return root;
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 3 );
        root.left = new TreeNode( 5 );
        root.right = new TreeNode( 1 );
        root.left.left = new TreeNode( 6 );
        root.left.right = new TreeNode( 2 );
        root.left.right.left = new TreeNode( 7 );
        root.left.right.right = new TreeNode( 4 );
        root.right.left = new TreeNode( 0 );
        root.right.right = new TreeNode( 8 );
        lowestCommonAncestor( root, new TreeNode( 5 ), new TreeNode( 4 ) );
        //        System.out.println( 1 << 3 );
    }
}
