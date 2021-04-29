package com.algorithms.others;

public class Leet146
{

    public static void main( String[] args )
    {
        LRUCacheWithNode cache = new LRUCacheWithNode( 2 );
        cache.put( 1, 1 );
        cache.put( 2, 2 );
        System.out.println( cache.get( 1 ) );       // 返回  1
        cache.put( 3, 3 );    // 该操作会使得密钥 2 作废
        System.out.println( cache.get( 2 ) );       // 返回 -1 (未找到)
        cache.put( 4, 4 );    // 该操作会使得密钥 1 作废
        System.out.println( cache.get( 1 ) );       // 返回 -1 (未找到)
        System.out.println( cache.get( 3 ) );       // 返回  3
        System.out.println( cache.get( 4 ) );

    }
}
