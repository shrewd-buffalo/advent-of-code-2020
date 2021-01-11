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
class EyeColourValidationTest
{
    private EyeColourValidation eyeColourValidation;

    @BeforeEach
    void setUp()
    {
        eyeColourValidation = new EyeColourValidation();
    }

    @ParameterizedTest
    @ValueSource( strings = { "amb", "blu", "brn", "gry", "grn", "hzl", "oth" } )
    void shouldBeValidColour( String colour )
    {
        assertTrue( eyeColourValidation.validate( colour ) );
    }
}
