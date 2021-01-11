/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day3a;

import java.util.LinkedList;

/**
 * @author pshipley
 */
public class Tobaggan
{
    private LinkedList<Point> route;
    private TobagganRouteGenerator tobagganRouteGenerator;

    public Tobaggan( final int maxLayers, final Slope slope )
    {
        tobagganRouteGenerator = new TobagganRouteGenerator( slope, maxLayers );
    }

    /**
     * @return The route.
     */
    public LinkedList<Point> getRoute()
    {
        if ( route == null )
        {
            route = tobagganRouteGenerator.generateRoute();
        }
        return route;
    }

}
