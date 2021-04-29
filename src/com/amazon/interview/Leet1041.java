package com.amazon.interview;

public class Leet1041
{
    public boolean isRobotBounded( String instructions )
    {
        char dir = 'N';
        int x = 0;
        int y = 0;
        for ( char instruction : instructions.toCharArray() )
        {
            if ( instruction == 'G' )
            {
                if ( dir == 'N' )
                {
                    y++;
                }
                else if ( dir == 'S' )
                {
                    y--;
                }
                else if ( dir == 'W' )
                {
                    x--;
                }
                else
                {
                    x++;
                }
            }
            if ( instruction == 'L' )
            {
                if ( dir == 'N' )
                {
                    dir = 'W';
                }
                else if ( dir == 'S' )
                {
                    dir = 'E';
                }
                else if ( dir == 'W' )
                {
                    dir = 'S';
                }
                else
                {
                    dir = 'N';
                }
            }

            if ( instruction == 'R' )
            {
                if ( dir == 'N' )
                {
                    dir = 'E';
                }
                else if ( dir == 'S' )
                {
                    dir = 'W';
                }
                else if ( dir == 'W' )
                {
                    dir = 'N';
                }
                else
                {
                    dir = 'S';
                }
            }
        }
        return ( x == 0 && y == 0 ) || dir != 'N';
    }
}
