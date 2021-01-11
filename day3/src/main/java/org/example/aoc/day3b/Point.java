/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day3b;

/**
 * @author pshipley
 */
public class Point
{
    private int x;
    private int y;

    public Point( final int x, final int y )
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @return The x.
     */
    public int getX()
    {
        return x;
    }

    /**
     * @param x The x to set.
     */
    public void setX( final int x )
    {
        this.x = x;
    }

    /**
     * @return The y.
     */
    public int getY()
    {
        return y;
    }

    /**
     * @param y The y to set.
     */
    public void setY( final int y )
    {
        this.y = y;
    }
}

