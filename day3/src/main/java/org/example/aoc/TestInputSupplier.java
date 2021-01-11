/*
 * Copyright 2020 Applied Card Technologies Ltd
 */
package org.example.aoc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author pshipley
 */
public final class TestInputSupplier implements Supplier<List<String>>
{
    private static final String INPUT = "input.txt";

    private List<String> readFileResource( final String filename )
    {
        try
        {
            return Files.readAllLines(
                    Paths.get( TestInputSupplier.class.getClassLoader().getResource( filename ).toURI() ) );
        }
        catch ( IOException | URISyntaxException e )
        {
            throw new TestInputException( "Failed to read input", e );
        }
    }

    @Override
    public List<String> get()
    {
        return readFileResource( INPUT );
    }
}
