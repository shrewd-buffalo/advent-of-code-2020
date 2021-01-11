/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b;

import java.util.Map;
import org.example.aoc.day4b.validation.FieldValidation;
import org.example.aoc.day4b.validation.ValidationFactory;

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
            final FieldValidation fieldValidator = ValidationFactory.getValidation( passportField );
            if ( fieldValidator.isRequired() )
            {
                if ( !fields.containsKey( passportField ) )
                {
                    return false;
                }
                if ( !fieldValidator.validate( fields.get( passportField ) ) )
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
