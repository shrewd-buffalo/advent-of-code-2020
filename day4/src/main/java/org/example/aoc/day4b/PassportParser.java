/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pshipley
 */
public final class PassportParser
{
    public static List<Passport> parsePassports( final List<String> lines )
    {
        final List<Passport> passports = new ArrayList<>();
        final List<String> fieldPairs = new ArrayList<>();
        for ( String line : lines )
        {
            if ( line.isBlank() )
            {
                passports.add( processFields( fieldPairs ) );
                fieldPairs.clear();
            }
            else
            {
                for ( final String fieldPair : line.split( " " ) )
                {
                    fieldPairs.add( fieldPair.trim() );
                }
            }
        }
        if ( !fieldPairs.isEmpty() )
        {
            passports.add( processFields( fieldPairs ) );
        }
        return passports;
    }

    private static Passport processFields( final List<String> fieldPairs )
    {
        final Map<PassportField, String> fields = new HashMap<>();
        fieldPairs.forEach( fieldPair ->
        {
            final String[] parts = fieldPair.split( ":" );
            final String key = parts[ 0 ];
            final String value = parts[ 1 ];
            fields.put( PassportField.findFieldByCode( key ), value );

        } );
        return new Passport( fields );
    }
}
