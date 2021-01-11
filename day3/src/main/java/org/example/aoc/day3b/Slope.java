/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day3b;

/**
 * @author pshipley
 */
public class Slope
{
    private int right;
    private int down;

    public Slope( final int right, final int down )
    {
        if ( right > 0 && down > 0 )
        {
            this.right = right;
            this.down = down;
        }
        else
        {
            throw new IllegalArgumentException( "Slope must use positive numbers." );
        }
    }

    /**
     * @return The right.
     */
    public int getRight()
    {
        return right;
    }

    /**
     * @return The down.
     */
    public int getDown()
    {
        return down;
    }
}
