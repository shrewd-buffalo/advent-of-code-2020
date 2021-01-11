/*
 * Copyright 2020 Applied Card Technologies Ltd
 */
package org.example.aoc;

/**
 * @author pshipley
 */
public class TestInputException extends RuntimeException
{
    /**
     * @param message Error message
     * @param cause Error cause
     */
    public TestInputException( final String message, final Throwable cause )
    {
        super( message, cause );
    }
}
