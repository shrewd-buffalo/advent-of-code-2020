/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author pshipley
 */
public class HeightValidation implements FieldValidation
{
    private static final Pattern PATTERN = Pattern.compile( "(?<value>\\d+)(?<units>cm|in)" );
    private static final int MIN_CM = 150;
    private static final int MAX_CM = 193;
    private static final int MIN_INCHES = 59;
    private static final int MAX_INCHES = 76;
    private static final String CM = "cm";
    private static final String INCHES = "in";

    @Override
    public boolean isRequired()
    {
        return true;
    }

    @Override
    public boolean validate( final String value )
    {
        final Matcher matcher = PATTERN.matcher( value );
        if ( matcher.matches() )
        {
            final String height = matcher.group( "value" );
            final String units = matcher.group( "units" );
            return validateRange( units, Integer.parseInt( height ) );
        }
        return false;
    }

    private boolean validateRange( final String units, final int height )
    {
        if ( CM.equals( units ) )
        {
            return isBetween( height, MIN_CM, MAX_CM );
        }
        else if ( INCHES.equals( units ) )
        {
            return isBetween( height, MIN_INCHES, MAX_INCHES );
        }

        return false;
    }

    private boolean isBetween( final int value, final int min, final int max )
    {
        return value >= min && value <= max;
    }
}
