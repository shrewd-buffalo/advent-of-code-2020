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
class ExpirationYearValidationTest
{
    private static final int MIN_YEAR = 2020;
    private static final int MAX_YEAR = 2030;

    private ExpirationYearValidation expirationYearValidation;

    @BeforeEach
    void setUp()
    {
        expirationYearValidation = new ExpirationYearValidation();
    }

    @Test
    void shouldBeValidMinYear()
    {
        assertTrue( expirationYearValidation.validate( Integer.toString( MIN_YEAR ) ) );
    }

    @Test
    void shouldBeValidMaxYear()
    {
        assertTrue( expirationYearValidation.validate( Integer.toString( MAX_YEAR ) ) );
    }

    @Test
    void shouldBeValidYearLength()
    {
        assertTrue( expirationYearValidation.validate( "2025" ) );
    }

    @Test
    void shouldBeInvalidYearLength()
    {
        assertFalse( expirationYearValidation.validate( "109" ) );
    }
}
