/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day2a;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;
import org.example.aoc.TestInputSupplier;

/**
 * Each line gives the password policy and then the password. The password policy indicates the lowest and highest
 * number of times a given letter must appear for the password to be valid. For example, 1-3 a means that the
 * password must contain a at least 1 time and at most 3 times.
 *
 * @author pshipley
 */
public class Day2a
{
    private static final Logger LOGGER = Logger.getLogger( Day2a.class.getName() );

    public static void main( final String[] args )
    {
        new Day2a().solve( new TestInputSupplier() );
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
            final String policy= parts[ 0 ].trim();
            final String password = parts[ 1 ].trim();

            final PasswordComplianceCheck passwordComplianceCheck = new PasswordComplianceCheck( policy );
            if ( passwordComplianceCheck.isCompliant( password ) )
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
