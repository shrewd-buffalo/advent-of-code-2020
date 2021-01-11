/*
 * Copyright 2021 Applied Card Technologies Ltd
 */

package org.example.aoc.day2a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author pshipley
 */
class PasswordComplianceCheckTest
{
    @Test
    void shouldBeCompliant()
    {
        final String password = "svsssszslpsp";
        final String policy = "6-8 s";
        assertTrue( new PasswordComplianceCheck( policy ).isCompliant( password ) );

    }
}
