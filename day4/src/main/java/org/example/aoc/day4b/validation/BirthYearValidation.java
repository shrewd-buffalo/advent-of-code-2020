/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b.validation;

/**
 * @author pshipley
 */
public class BirthYearValidation implements FieldValidation
{
    private static final int MIN_YEAR = 1920;
    private static final int MAX_YEAR = 2002;
    private static final int NUM_DIGITS = 4;

    @Override
    public boolean isRequired()
    {
        return true;
    }

    @Override
    public boolean validate( final String value )
    {
        final int year = Integer.parseInt( value );
        return value.length() == NUM_DIGITS && year >= MIN_YEAR && year <= MAX_YEAR;
    }
}
