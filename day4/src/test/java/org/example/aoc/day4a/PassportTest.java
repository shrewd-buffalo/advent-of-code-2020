/*
 * Copyright 2021 Applied Card Technologies Ltd
 */

package org.example.aoc.day4a;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * @author pshipley
 */
class PassportTest
{

    @Test
    void shouldBeValidPassport()
    {
        final Map<PassportField, String> fields = new HashMap<>();
        fields.put( PassportField.ISSUE_YEAR, "2017" );
        fields.put( PassportField.EYE_COLOUR, "gry" );
        fields.put( PassportField.COUNTRY_ID, "147" );
        fields.put( PassportField.EXP_YEAR, "2020" );
        fields.put( PassportField.PASSPORT_ID, "860033327" );
        fields.put( PassportField.HAIR_COLOUR, "#fffffd" );
        fields.put( PassportField.BIRTH_YEAR, "1937" );
        fields.put( PassportField.HEIGHT, "183cm" );

        final Passport passport = new Passport( fields );
        assertTrue( passport.isValid() );
    }

    @Test
    void shouldBeInvalidPassport()
    {
        final Map<PassportField, String> fields = new HashMap<>();
        fields.put( PassportField.ISSUE_YEAR, "2013" );
        fields.put( PassportField.EYE_COLOUR, "amb" );
        fields.put( PassportField.COUNTRY_ID, "350" );
        fields.put( PassportField.EXP_YEAR, "2023" );
        fields.put( PassportField.PASSPORT_ID, "028048884" );
        fields.put( PassportField.HAIR_COLOUR, "#cfa07d" );
        fields.put( PassportField.BIRTH_YEAR, "1929" );

        final Passport passport = new Passport( fields );
        assertFalse( passport.isValid() );
    }

    @Test
    void shouldBeConsideredValidPassport()
    {
        final Map<PassportField, String> fields = new HashMap<>();
        fields.put( PassportField.ISSUE_YEAR, "2013" );
        fields.put( PassportField.EYE_COLOUR, "brn" );
        fields.put( PassportField.EXP_YEAR, "2024" );
        fields.put( PassportField.PASSPORT_ID, "760753108" );
        fields.put( PassportField.HAIR_COLOUR, "#ae17e1" );
        fields.put( PassportField.BIRTH_YEAR, "1931" );
        fields.put( PassportField.HEIGHT, "179cm" );

        final Passport passport = new Passport( fields );
        assertTrue( passport.isValid() );
    }

}
