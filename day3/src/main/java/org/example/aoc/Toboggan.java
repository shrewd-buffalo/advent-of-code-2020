/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc;

import java.util.LinkedList;

/**
 * @author pshipley
 */
public class Toboggan
{
    private LinkedList<Point> route;
    private TobogganRouteGenerator tobogganRouteGenerator;

    public Toboggan( final int maxLayers, final Slope slope )
    {
        tobogganRouteGenerator = new TobogganRouteGenerator( slope, maxLayers );
    }

    /**
     * @return The route.
     */
    public LinkedList<Point> getRoute()
    {
        if ( route == null )
        {
            route = tobogganRouteGenerator.generateRoute();
        }
        return route;
    }

}
