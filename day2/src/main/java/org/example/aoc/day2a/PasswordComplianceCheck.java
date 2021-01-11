/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day2a;

/**
 * @author pshipley
 */
public class PasswordComplianceCheck
{
    private static final String REGEX_FORMAT = "([^%1$s]*%1$s){%2$s}[^%1$s]*";
    private String passwordRegex;

    public PasswordComplianceCheck( final String policy )
    {
        final String[] parts = policy.split( " " );
        final String range = parts[ 0 ].replace( "-", "," ).trim();
        final String letter = parts[ 1 ].trim();

        passwordRegex = String.format( REGEX_FORMAT, letter, range );
    }

    public boolean isCompliant( final String password )
    {
        return password.matches( passwordRegex );
    }
}
