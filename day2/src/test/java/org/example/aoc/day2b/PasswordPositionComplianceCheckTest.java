/*
 * Copyright 2021 Applied Card Technologies Ltd
 */

package org.example.aoc.day2b;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author pshipley
 */
class PasswordPositionComplianceCheckTest
{
    @Test
    void shouldBeCompliantWhenOnePositionMatches()
    {
        final String password = "abcde";
        final String policy = "1-3 a";
        assertTrue( new PasswordPositionComplianceCheck(  policy ).isCompliant( password ) );
    }

    @Test
    void shouldNotBeCompliantWhenBothPositionMatch()
    {
        final String password = "cdefg";
        final String policy = "1-3 b";
        assertFalse( new PasswordPositionComplianceCheck( policy ).isCompliant( password ) );
    }

    @Test
    void shouldNotBeCompliantWhenNoPositionMatch()
    {
        final String password = "ccccccccc";
        final String policy = "2-9 c";
        assertFalse( new PasswordPositionComplianceCheck( policy ).isCompliant( password ) );
    }
}
