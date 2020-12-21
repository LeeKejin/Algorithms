package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test
{
    static class Node
    {
        public int val;
        public List< Node > neighbors;

        public Node()
        {
            val = 0;
            neighbors = new ArrayList< Node >();
        }

        public Node( int _val )
        {
            val = _val;
            neighbors = new ArrayList< Node >();
        }

        public Node( int _val, ArrayList< Node > _neighbors )
        {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map< Node, Node > visited = new HashMap<>();

    public Node cloneGraph( Node node )
    {
        if ( node == null ) return null;
        if ( node.neighbors.size() == 0 )
        {
            Node copiedNode = new Node( node.val );
            return copiedNode;
        }

        return dfs( node );
    }

    private Node dfs( Node node )
    {
        if ( visited.containsKey( node ) )
        {
            return visited.get( node );
        }
        Node clonedNode = new Node( node.val, new ArrayList<>() );
        visited.put( node, clonedNode );
        for ( Node neighbor : node.neighbors )
        {
            clonedNode.neighbors.add( dfs( neighbor ) );
        }
        return clonedNode;
    }

    public static void main( String[] args )
    {
        Test t = new Test();
        Node n1 = new Node( 1 );
        Node n2 = new Node( 2 );
        Node n3 = new Node( 3 );
        Node n4 = new Node( 4 );

        List< Node > l1 = new ArrayList<>();
        l1.add( n2 );
        l1.add( n4 );
        n1.neighbors.addAll( l1 );

        List< Node > l2 = new ArrayList<>();
        l2.add( n1 );
        l2.add( n3 );
        n2.neighbors.addAll( l2 );

        List< Node > l3 = new ArrayList<>();
        l3.add( n2 );
        l3.add( n4 );
        n3.neighbors.addAll( l3 );

        List< Node > l4 = new ArrayList<>();
        l4.add( n1 );
        l4.add( n3 );
        n4.neighbors.addAll( l4 );
        Node n = t.cloneGraph( n1 );
        System.out.println( n.val );

        TreeNode root = new TreeNode( 1 );
        root.right = new TreeNode( 2 );
        root.right.left = new TreeNode( 3 );
        //        root.left.left = new TreeNode( 6 );
        //        root.left.right = new TreeNode( 2 );
        //        root.right.left = new TreeNode( 4 );
        //        root.right.right = new TreeNode( 5 );
        //        root.right.left.left = new TreeNode( 6 );
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
