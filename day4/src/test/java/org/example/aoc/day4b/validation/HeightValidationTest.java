/*
 * Copyright 2021 Applied Card Technologies Ltd
 */

package org.example.aoc.day4b.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author pshipley
 */
class HeightValidationTest
{
    private HeightValidation heightValidation;

    @BeforeEach
    void setUp()
    {
        heightValidation = new HeightValidation();
    }

    @ParameterizedTest
    @ValueSource( strings = { "150cm", "190cm", "193cm", "59in", "65in", "76in" } )
    void shouldBeValidHeight( String height )
    {
        assertTrue( heightValidation.validate( height ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "150", "150in", "190in", "193in", "59cm", "65cm", "76cm", "76" } )
    void shouldBeInvalidHeight( String height )
    {
        assertFalse( heightValidation.validate( height ) );
    }
}
