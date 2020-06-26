package com.algorithms.binary.search.tree;

public class Main
{
    public static void main( String[] args )
    {
        BST< Integer > bst = new BST<>();
        int[] nums = { 41, 22, 58, 15, 33, 50, 60, 13, 37, 42, 53, 59, 63 };
        for ( int num : nums )
        {
            bst.add( num );
        }
        bst.removeNode( 53 );
        bst.retrieveByLayer();
    }
}
