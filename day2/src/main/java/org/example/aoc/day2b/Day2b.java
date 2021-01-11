/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day2b;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;
import org.example.aoc.TestInputSupplier;

/**
 * Each policy actually describes two positions in the password, where 1 means the first character, 2 means the
 * second character, and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!) Exactly
 * one of these positions must contain the given letter. Other occurrences of the letter are irrelevant for the
 * purposes of policy enforcement.
 * <p>
 * Given the same example list from above:
 * <p>
 * 1-3 a: abcde is valid: position 1 contains a and position 3 does not.
 * 1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
 * 2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
 *
 * @author pshipley
 */
public class Day2b
{
    private static final Logger LOGGER = Logger.getLogger( Day2b.class.getName() );

    public static void main( final String[] args )
    {
        new Day2b().solve( new TestInputSupplier() );
    }

    public void solve( final Supplier<List<String>> inputSupplier )
    {
        final List<String> testInput = inputSupplier.get();
        LOGGER.fine( "Using input: " + testInput );

        final List<String> badPasswords = new ArrayList<>();
        final List<String> goodPasswords = new ArrayList<>();

        for ( String input : testInput )
        {
            final String[] parts = input.split( ":" );
            final String policy = parts[ 0 ].trim();
            final String password = parts[ 1 ].trim();

            final PasswordPositionComplianceCheck passwordPositionComplianceCheck = new PasswordPositionComplianceCheck( policy );
            if ( passwordPositionComplianceCheck.isCompliant( password ) )
            {
                goodPasswords.add( password );
            }
            else
            {
                badPasswords.add( password );
            }
        }

        if ( badPasswords.isEmpty() )
        {
            LOGGER.info( "No bad passwords - seems unlikely :(" );
        }
        else
        {
            LOGGER.info( "Bad passwords: " + badPasswords.size() );
            LOGGER.info( "Good passwords: " + goodPasswords.size() );
        }
    }
}
