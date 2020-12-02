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
 * The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over
 * from a past vacation. They offer you a second one if you can find three numbers in your expense report that meet
 * the same criteria.
 * <p>
 * Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together
 * produces the answer, 241861950.
 * <p>
 * In your expense report, what is the product of the three entries that sum to 2020?
 *
 * @author pshipley
 */
public class Day1b
{
    private static final Logger LOGGER = Logger.getLogger( Day1b.class.getName() );

    public static void main( String[] args )
    {
        new Day1b().solve( new TestInputSupplier() );
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
                final List<Integer> thirdList = new ArrayList<>( expenseList );
                thirdList.remove( entry );
                thirdList.remove( secondEntry );
                for ( final Integer thirdEntry : thirdList )
                {
                    if ( entry + secondEntry + thirdEntry == target )
                    {
                        LOGGER.info( String.format( "Found results: entries %d and %d and %d", entry, secondEntry,
                                thirdEntry ) );
                        return entry * secondEntry * thirdEntry;
                    }
                }
            }
        }
        return -1;
    }
}
