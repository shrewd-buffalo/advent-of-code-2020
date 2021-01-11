/*
 * Copyright 2021 Applied Card Technologies Ltd
 */

package org.example.aoc.day4b.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author pshipley
 */
class BirthYearValidationTest
{
    private static final int MIN_YEAR = 1920;
    private static final int MAX_YEAR = 2002;

    private BirthYearValidation birthYearValidation;

    @BeforeEach
    void setUp()
    {
        birthYearValidation = new BirthYearValidation();
    }

    @Test
    void shouldBeValidMinYear()
    {
        assertTrue( birthYearValidation.validate( Integer.toString( MIN_YEAR ) ) );
    }

    @Test
    void shouldBeValidMaxYear()
    {
        assertTrue( birthYearValidation.validate( Integer.toString( MAX_YEAR ) ) );
    }

    @Test
    void shouldBeValidYearLength()
    {
        assertTrue( birthYearValidation.validate( "1996" ) );
    }

    @Test
    void shouldBeInvalidYearLength()
    {
        assertFalse( birthYearValidation.validate( "109" ) );
    }
}
