/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day3b;

import java.util.LinkedList;

/**
 * @author pshipley
 */
public class TobagganRouteGenerator
{
    private final Slope slope;
    private final int maxLayers;
    private final LinkedList<Point> route = new LinkedList<>();

    public TobagganRouteGenerator( final Slope slope, final int maxLayers )
    {
        this.slope = slope;
        this.maxLayers = maxLayers;
    }

    public LinkedList<Point> generateRoute()
    {
        for ( int y = 0; y < maxLayers; y += slope.getDown() )
        {
            addPoint( slope.getRight(), slope.getDown() );
        }
        return route;
    }

    private void addPoint( final int right, final int down )
    {
        final Point previousPoint = route.isEmpty() ? new Point( 0, 0 ) : route.getLast();
        route.add( new Point( previousPoint.getX() + right, previousPoint.getY() + down ) );
    }

    public LinkedList<Point> getRoute()
    {
        return route;
    }
}
