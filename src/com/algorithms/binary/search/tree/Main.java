package com.algorithms.binary.search.tree;

public class Main
{
    public static void main( String[] args )
    {
        BST< Integer > bst = new BST<>();
        int[] nums = { 5, 3, 6, 8, 4, 2 };
        for ( int num : nums )
        {
            bst.add( num );
        }

        //        bst.preOrderWithoutRecursion();
        int v = bst.removeMin();
        //        System.out.println( v );
        bst.retrieveByLayer();
        //        bst.retrieveByLayer();
    }
}
