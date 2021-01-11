/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day3a;

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
 *
 * @author pshipley
 */
public class Day3a
{
    private static final Logger LOGGER = Logger.getLogger( Day3a.class.getName() );

    public static void main( final String[] args )
    {
        new Day3a().solve( new TestInputSupplier() );
    }

    public void solve( final Supplier<List<String>> inputSupplier )
    {
        final List<String> testInput = inputSupplier.get();

        final Grid grid = Grid.parse( testInput );
        final Slope slope = new Slope( 3, 1 );
        final Toboggan toboggan = new Toboggan( grid.getWorldHeight(), slope );

        final TobogganRun tobogganRun = grid.render( toboggan.getRoute());
        LOGGER.info( tobogganRun.getRender() );
        LOGGER.info( tobogganRun.getTreesHit() + " trees hit" );

    }
}
