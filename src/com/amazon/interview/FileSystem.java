package com.amazon.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem
{
    public class File
    {
        boolean isfile = false;
        Map< String, File > files = new HashMap<>();
        String content = "";
    }

    File root;

    public FileSystem()
    {
        root = new File();
    }

    public List< String > ls( String path )
    {
        File file = root;
        List< String > res = new ArrayList<>();
        if ( !path.equals( "/" ) )
        {
            String[] depth = path.split( "/" );
            for ( int i = 1; i < depth.length; i++ )
            {
                file = file.files.get( depth[ i ] );
            }
            if ( file.isfile )
            {
                res.add( depth[ depth.length - 1 ] );
                return res;
            }
        }
        res.addAll( file.files.keySet() );
        Collections.sort( res );
        return res;
    }

    public void mkdir( String path )
    {
        File file = root;
        String[] depth = path.split( "/" );
        for ( int i = 1; i < depth.length; i++ )
        {
            if ( !file.files.containsKey( depth[ i ] ) )
            {
                file.files.put( depth[ i ], new File() );
            }
            file = file.files.get( depth[ i ] );
        }
    }

    public void addContentToFile( String filePath, String content )
    {
        File file = root;
        String[] depth = filePath.split( "/" );

        for ( int i = 1; i < depth.length - 1; i++ )
        {
            file = file.files.get( depth[ i ] );
        }
        if ( !file.files.containsKey( depth[ depth.length - 1 ] ) )
        {
            file.files.put( depth[ depth.length - 1 ], new File() );
        }
        file = file.files.get( depth[ depth.length - 1 ] );
        file.content += content;
        file.isfile = true;
    }

    public String readContentFromFile( String filePath )
    {
        File file = root;
        String[] depth = filePath.split( "/" );
        for ( int i = 1; i < depth.length; i++ )
        {
            file = file.files.get( depth[ i ] );
        }
        return file.content;
    }

    public static void main( String[] args )
    {
        FileSystem fileSystem = new FileSystem();
        fileSystem.mkdir( "/a/b" );
        fileSystem.mkdir( "/a/c" );
        //        fileSystem.addContentToFile( "/a/b/c/d", "hello" );
        System.out.println( fileSystem.ls( "/a" ) );
    }
}
