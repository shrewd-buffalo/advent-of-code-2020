/*
 * Copyright 2021 Applied Card Technologies Ltd
 */

package aoc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import org.example.aoc.Point;
import org.example.aoc.Slope;
import org.example.aoc.TobogganRouteGenerator;
import org.junit.jupiter.api.Test;

/**
 * @author pshipley
 */
class TobogganRouteGeneratorTest
{

    private TobogganRouteGenerator tobogganRouteGenerator;

    @Test
    void generateRoute()
    {
        final int right = 3;
        final int down = 1;
        final Slope slope = new Slope( right, down );
        final int maxLayers = 5;
        tobogganRouteGenerator = new TobogganRouteGenerator( slope, maxLayers );
        final LinkedList<Point> generatedRoute = tobogganRouteGenerator.generateRoute();
        for ( int i = 1; i <= generatedRoute.size(); i++ )
        {
            final Point point = generatedRoute.pop();
            assertEquals( right * i, point.getX() );
            assertEquals( down * i, point.getY() );
        }
    }
}
