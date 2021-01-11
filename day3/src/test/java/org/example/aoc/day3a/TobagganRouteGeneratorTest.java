/*
 * Copyright 2021 Applied Card Technologies Ltd
 */

package org.example.aoc.day3a;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;

/**
 * @author pshipley
 */
class TobagganRouteGeneratorTest
{

    private TobagganRouteGenerator tobagganRouteGenerator;

    @Test
    void generateRoute()
    {
        final int right = 3;
        final int down = 1;
        final Slope slope = new Slope( right, down );
        final int maxLayers = 5;
        tobagganRouteGenerator = new TobagganRouteGenerator( slope, maxLayers );
        final LinkedList<Point> generatedRoute = tobagganRouteGenerator.generateRoute();
        for ( int i = 1; i <= generatedRoute.size(); i++ )
        {
            final Point point = generatedRoute.pop();
            assertEquals( right * i, point.getX() );
            assertEquals( down * i, point.getY() );
        }
    }
}
