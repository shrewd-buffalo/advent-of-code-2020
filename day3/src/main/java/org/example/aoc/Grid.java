/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author pshipley
 */
public class Grid
{
    private static final Logger LOGGER = Logger.getLogger( Grid.class.getName() );
    private static final char OPEN_SPACE = '.';
    private static final char OPEN_SPACE_VISITED = 'X';
    private static final char TREE = '#';
    private static final char TREE_HIT = 'X';

    /**
     * The world using x,y coords.
     */
    private final int numLayers;
    private final int defaultWidth;
    private char[][] world;

    private Grid( char[][] world )
    {
        this.world = world;
        numLayers = world[ 0 ].length;
        defaultWidth = world.length;
    }

    /**
     * Create a fixed height grid using fixed length strings.
     *
     * @param input Test input
     * @return
     */
    public static Grid parse( List<String> input )
    {
        final char[][] world = new char[ input.get( 0 ).length() ][ input.size() ];
        for ( int y = 0; y < input.size(); y++ )
        {
            final String line = input.get( y );
            for ( int x = 0; x < line.length(); x++ )
            {
                world[ x ][ y ] = line.charAt( x );
            }

        }
        return new Grid( world );
    }

    public TobogganRun render( LinkedList<Point> tobagganRoute )
    {
        final StringBuilder sb = new StringBuilder();
        final LinkedList<Point> route = new LinkedList<>( tobagganRoute );

        if ( route.getLast().getX() > world.length )
        {
            expandWorldToFit( route.getLast().getX() / defaultWidth + 1 );
        }

        Point routeNode = route.getFirst();
        sb.append( '\n' );
        int treesHit = 0;
        int openSpacesVisited = 0;
        for ( int y = 0; y < numLayers; y++ )
        {
            for ( int x = 0; x < getWorldWidth(); x++ )
            {
                char marker = world[ x ][ y ];
                if ( routeNode != null && x == routeNode.getX() && y == routeNode.getY() )
                {
                    if ( isTree( routeNode ) )
                    {
                        marker = TREE_HIT;
                        treesHit++;
                    }
                    else if ( isOpen( routeNode ) )
                    {
                        marker = OPEN_SPACE_VISITED;
                        openSpacesVisited++;
                    }
                    tobagganRoute.remove();
                    routeNode = tobagganRoute.peek();
                }
                sb.append( marker );

            }
            sb.append( '\n' );

        }
        sb.append( '\n' );
        return new TobogganRun( sb.toString(), treesHit, openSpacesVisited );
    }

    public int getWorldWidth()
    {
        return world.length;
    }

    public int getWorldHeight()
    {
        return numLayers;
    }

    private void expandWorldToFit( final int numExpansions )
    {
        char[][] newWorld = new char[ defaultWidth * numExpansions + 1 ][ numLayers ];

        char[][] copy = Arrays.stream( world ).map( char[]::clone ).toArray( char[][]::new );
        for ( int i = 0; i < numExpansions; i++ )
        {
            arrayCopy( world, newWorld, defaultWidth * i );
        }

        world = newWorld;
    }

    private static void arrayCopy( char[][] aSource, char[][] aDestination, final int offset )
    {
        for ( int i = 0; i < aSource.length; i++ )
        {
            System.arraycopy( aSource[ i ], 0, aDestination[ i + offset ], 0, aSource[ i ].length );
        }
    }

    public boolean isOpen( Point point )
    {
        return world[ point.getX() ][ point.getY() ] == OPEN_SPACE;
    }

    public boolean isTree( Point point )
    {
        return world[ point.getX() ][ point.getY() ] == TREE;
    }
}
