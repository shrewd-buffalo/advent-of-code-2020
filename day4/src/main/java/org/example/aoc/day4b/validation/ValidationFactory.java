/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b.validation;

import org.example.aoc.day4b.PassportField;

/**
 * @author pshipley
 */
public final class ValidationFactory
{
    public static FieldValidation getValidation( final PassportField passportField )
    {
        switch ( passportField )
        {
            case PASSPORT_ID:
                return new PassportIdValidation();
            case BIRTH_YEAR:
                return new BirthYearValidation();
            case EXP_YEAR:
                return new ExpirationYearValidation();
            case EYE_COLOUR:
                return new EyeColourValidation();
            case HAIR_COLOUR:
                return new HairColourValidation();
            case HEIGHT:
                return new HeightValidation();
            case ISSUE_YEAR:
                return new IssueYearValidation();
            case COUNTRY_ID:
                return new OptionalFieldValidation();
            default:
                throw new IllegalArgumentException( "No such field validation" );
        }
    }
}
