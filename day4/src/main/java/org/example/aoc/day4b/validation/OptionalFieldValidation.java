/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b.validation;

/**
 * @author pshipley
 */
public class OptionalFieldValidation implements FieldValidation
{
    @Override
    public boolean isRequired()
    {
        return false;
    }

    @Override
    public boolean validate( final String value )
    {
        return true;
    }
}
