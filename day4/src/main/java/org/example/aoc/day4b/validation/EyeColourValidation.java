/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b.validation;

import java.util.Arrays;
import java.util.List;

/**
 * @author pshipley
 */
public class EyeColourValidation implements FieldValidation
{
    private static final List<String> ACCEPTABLE_VALUES =
            Arrays.asList( "amb", "blu", "brn", "gry", "grn", "hzl", "oth" );

    @Override
    public boolean isRequired()
    {
        return true;
    }

    @Override
    public boolean validate( final String value )
    {
        return ACCEPTABLE_VALUES.contains( value );
    }
}
