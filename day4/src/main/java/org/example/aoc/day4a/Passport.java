/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4a;

import java.util.Map;

/**
 * @author pshipley
 */
public class Passport
{
    private Map<PassportField, String> fields;

    public Passport( final Map<PassportField, String> fields )
    {
        this.fields = fields;
    }

    public boolean isValid()
    {
        for ( final PassportField passportField : PassportField.values() )
        {
            if ( passportField.isRequired() )
            {
                if ( !fields.containsKey( passportField ) )
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return The fields.
     */
    public Map<PassportField, String> getFields()
    {
        return fields;
    }
}
