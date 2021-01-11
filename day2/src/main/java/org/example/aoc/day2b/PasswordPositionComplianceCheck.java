/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day2b;

/**
 * @author pshipley
 */
public class PasswordPositionComplianceCheck
{
    private final char letter;
    private final int position1;
    private final int position2;

    public PasswordPositionComplianceCheck( final String policy )
    {
        final String[] parts = policy.split( " " );
        final String[] positions = parts[ 0 ].trim().split( "-" );
        letter = parts[ 1 ].trim().charAt( 0 );
        // Not 0 based input
        position1 = Integer.parseInt( positions[ 0 ] ) - 1;
        position2 = Integer.parseInt( positions[ 1 ] ) - 1;

    }

    public boolean isCompliant( final String password )
    {
        return ( letter == password.charAt( position1 ) ^ letter == password.charAt( position2 ) );
    }
}
