/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b.validation;

/**
 * @author pshipley
 */
public class HairColourValidation implements FieldValidation
{
    private static final String FORMAT = "#[0-9a-f]{6}";

    @Override
    public boolean isRequired()
    {
        return true;
    }

    @Override
    public boolean validate( final String value )
    {
        return value.matches( FORMAT );
    }
}
