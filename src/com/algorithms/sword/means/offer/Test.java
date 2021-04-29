package com.algorithms.sword.means.offer;

public class Test
{
    class Node
    {
        int val;
        Node next;
        Node random;

        public Node( int val )
        {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private void swap( String[] strs, int i, int j )
    {
        String tmp = strs[ i ];
        strs[ i ] = strs[ j ];
        strs[ j ] = tmp;

    }

    public static void main( String[] args )
    {
        Test t = new Test();
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 3 );
        root.left.left = new TreeNode( 4 );
        root.right.left = new TreeNode( 5 );
        //        System.out.println( t.longestOnes( new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3 ) );
        System.out.println( t.jump( new int[] { 2, 3, 1, 1, 4 } ) );

    }

    public void test()
    {
        Node head = new Node( 7 );
        Node n13 = new Node( 13 );
        Node n11 = new Node( 11 );
        Node n10 = new Node( 10 );
        Node n1 = new Node( 1 );
        head.next = n13;
        head.random = null;

        n13.next = n11;
        n13.random = head;

        n11.next = n10;
        n11.random = n1;

        n10.next = n1;
        n10.random = n11;

        n1.random = head;
        //        copyRandomList( head );
    }
}
