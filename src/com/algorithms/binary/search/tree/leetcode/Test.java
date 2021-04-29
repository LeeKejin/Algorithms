package com.algorithms.binary.search.tree.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Test
{
    class Node
    {
        public int val;
        public Node left;
        public Node right;

        public Node()
        {
        }

        public Node( int _val )
        {
            val = _val;
        }

        public Node( int _val, Node _left, Node _right )
        {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public class ListNode
    {
        int val;
        ListNode next;

        ListNode()
        {
        }

        ListNode( int val )
        {
            this.val = val;
        }

        ListNode( int val, ListNode next )
        {
            this.val = val;
            this.next = next;
        }
    }

    public TreeNode deserialize( String data )
    {
        if ( data == "[]" ) return null;
        String str = data.substring( 1, data.length() - 1 );
        String[] arr = str.split( "," );
        TreeNode root = new TreeNode( Integer.parseInt( arr[ 0 ] ) );

        Queue< TreeNode > queue = new LinkedList<>();
        queue.add( root );
        int i = 1;
        while ( i < arr.length )
        {
            TreeNode node = queue.poll();
            if ( arr[ i ] != "null" )
            {
                node.left = new TreeNode( Integer.parseInt( arr[ i ] ) );
                queue.add( node.left );
            }
            i++;
            if ( i < arr.length && arr[ i ] != null )
            {
                node.right = new TreeNode( Integer.parseInt( arr[ i ] ) );
                queue.add( node.right );
            }
            i++;
        }
        return root;
    }

    public static void main( String[] args )
    {
        Test t = new Test();
        //        t.lengthOfLongestSubstring( "abcabcbb" );
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 3 );
        //        root.left.left = new TreeNode( 5 );
        //        root.left.right = new TreeNode( 1 );

        //        root.right.left.right = new TreeNode( 7 );
        //        root.left.right.left = new TreeNode( 7 );
        //        root.left.right.right = new TreeNode( 4 );
        //        String s = t.serialize( root );
        //        System.out.println( s );
        //        TreeNode n = t.deserialize(
        //            "[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]" );
        //        System.out.println( n.val );
        //        String s = t.serialize( n );
        //        System.out.println( s );
        //        inorder( root );

        //        root.right.left = new TreeNode( 6 );
        //        root.right.right = new TreeNode( 9 );

        //        int b = t.maxDepth( root, 1 );
        //        System.out.println( b );
        //
        //        root.right.right = new TreeNode( 3 );
        //        root.right.right.right = new TreeNode( 4 );
        //        List< List< Integer > > l = t.levelOrder( root );
        //        System.out.println( l );
        //        boolean b = t.isBalanced( root );
        //        System.out.println( b );
        //        TreeNode root = new TreeNode( 2 );
        //        root.left = new TreeNode( 1 );
        //        root.right = new TreeNode( 3 );
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

    }

}
