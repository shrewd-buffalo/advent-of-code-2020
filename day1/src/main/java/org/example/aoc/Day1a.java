/*
 * Copyright 2020 Applied Card Technologies Ltd
 */
package org.example.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't
 * quite adding up.
 * <p>
 * Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
 * <p>
 * For example, suppose your expense report contained the following:
 * <p>
 * 1721
 * 979
 * 366
 * 299
 * 675
 * 1456
 * In this list, the two entries that sum to 2020 are 1721 and 299.
 * Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
 *
 * @author pshipley
 */
public class Day1a
{
    private static final Logger LOGGER = Logger.getLogger( Day1a.class.getName() );

    public static void main( final String[] args )
    {
        new Day1a().solve( new TestInputSupplier() );
    }

    public void solve( final Supplier<List<String>> input )
    {
        final List<String> testInput = input.get();
        LOGGER.fine( "Using input: " + testInput );

        final List<Integer> expenseList = testInput.stream().map( Integer::valueOf ).collect( Collectors.toList() );

        final int target = 2020;

        final Integer result = processInput( expenseList, target );
        LOGGER.info( String.format( "Found multiplicative result: %d", result ) );
    }

    private Integer processInput( final List<Integer> expenseList, final int target )
    {
        for ( final Integer entry : expenseList )
        {
            final List<Integer> secondList = new ArrayList<>( expenseList );
            secondList.remove( entry );
            for ( final Integer secondEntry : secondList )
            {
                if ( entry + secondEntry == target )
                {
                    LOGGER.info( String.format( "Found results: entries %d and %d", entry, secondEntry ) );
                    return entry * secondEntry;
                }
            }
        }
        return -1;
    }

}
