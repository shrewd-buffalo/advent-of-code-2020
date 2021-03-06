/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b;

import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;
import org.example.aoc.TestInputSupplier;

/**
 * @author pshipley
 */
public class Day4b
{
    private static final Logger LOGGER = Logger.getLogger( Day4b.class.getName() );

    public static void main( final String[] args )
    {
        new Day4b().solve( new TestInputSupplier() );
    }

    public void solve( final Supplier<List<String>> inputSupplier )
    {
        final List<String> testInput = inputSupplier.get();

        final List<Passport> passports = PassportParser.parsePassports( testInput );
        LOGGER.info( String.format( "%d passports, of which %d are valid", passports.size(),
                passports.stream().filter( Passport::isValid ).count() ) );
    }
}
