/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day3b;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;
import org.example.aoc.Grid;
import org.example.aoc.Slope;
import org.example.aoc.TestInputSupplier;
import org.example.aoc.Toboggan;
import org.example.aoc.TobogganRun;

/**
 * Due to the local geology, trees in this area only grow on exact integer coordinates in a grid. You make a map
 * (your puzzle input) of the open squares (.) and trees (#) you can see. For example:
 * <p>
 * ..##.......
 * #...#...#..
 * .#....#..#.
 * ..#.#...#.#
 * .#...##..#.
 * ..#.##.....
 * .#.#.#....#
 * .#........#
 * #.##...#...
 * #...##....#
 * .#..#...#.#
 * <p>
 * These aren't the only trees, though; due to something you read about once involving arboreal genetics and biome
 * stability, the same pattern repeats to the right many times:
 * <p>
 * -- part 2
 * Time to check the rest of the slopes - you need to minimize the probability of a sudden arboreal stop, after all.
 * <p>
 * Determine the number of trees you would encounter if, for each of the following slopes, you start at the top-left
 * corner and traverse the map all the way to the bottom:
 * <p>
 * Right 1, down 1.
 * Right 3, down 1. (This is the slope you already checked.)
 * Right 5, down 1.
 * Right 7, down 1.
 * Right 1, down 2.
 *
 * @author pshipley
 */
public class Day3b
{
    private static final Logger LOGGER = Logger.getLogger( Day3b.class.getName() );

    public static void main( final String[] args )
    {
        new Day3b().solve( new TestInputSupplier() );
    }

    public void solve( final Supplier<List<String>> inputSupplier )
    {
        final List<String> testInput = inputSupplier.get();
        final List<Long> treeCarnage = new ArrayList<>();
        final List<Slope> slopesToTest = new ArrayList<>();
        slopesToTest.add( new Slope( 1, 1 ) );
        slopesToTest.add( new Slope( 3, 1 ) );
        slopesToTest.add( new Slope( 5, 1 ) );
        slopesToTest.add( new Slope( 7, 1 ) );
        slopesToTest.add( new Slope( 1, 2 ) );

        slopesToTest.forEach( slope ->
        {
            final Grid grid = Grid.parse( testInput );
            final Toboggan toboggan = new Toboggan( grid.getWorldHeight(), slope );
            final TobogganRun tobogganRun = grid.render( toboggan.getRoute() );
            LOGGER.info( String.format( "Slope %d,%d hit %d trees", slope.getRight(), slope.getDown(),
                    tobogganRun.getTreesHit() ) );
            treeCarnage.add( ( long ) tobogganRun.getTreesHit() );
        } );
        final Long totalCarnage = treeCarnage.stream().reduce( 1L, ( a, b ) -> a * b );
        LOGGER.info( totalCarnage + " trees hit" );

    }
}
