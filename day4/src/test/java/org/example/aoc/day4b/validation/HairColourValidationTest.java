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
class HairColourValidationTest
{

    private HairColourValidation hairColourValidation;

    @BeforeEach
    void setUp()
    {
        hairColourValidation = new HairColourValidation();
    }

    @Test
    void shouldBeValidColour()
    {
        assertTrue( hairColourValidation.validate( "#001122" ) );
    }

    @Test
    void shouldBeInvalidColourWithNoHash()
    {
        assertFalse( hairColourValidation.validate( "001122" ) );
    }

    @Test
    void shouldBeInvalidColourIfWrongLength()
    {
        assertFalse( hairColourValidation.validate( "#00112233" ) );
    }

}
