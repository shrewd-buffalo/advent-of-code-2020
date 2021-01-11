/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b.validation;

/**
 * @author pshipley
 */
public interface FieldValidation
{
    boolean isRequired();

    boolean validate( String value );
}
