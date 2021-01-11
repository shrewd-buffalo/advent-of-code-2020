/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b.validation;

/**
 * @author pshipley
 */
public class PassportIdValidation implements FieldValidation
{
    private static final String FORMAT = "\\d{9}";

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
