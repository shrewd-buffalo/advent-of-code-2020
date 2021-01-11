/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4a;

import java.util.Arrays;

/**
 * @author pshipley
 */
public enum PassportField
{
    BIRTH_YEAR( "byr", "Birth Year", true ),
    ISSUE_YEAR( "iyr", "Issue Year", true ),
    EXP_YEAR( "eyr", "Expiration Year", true ),
    HEIGHT( "hgt", "Height", true ),
    HAIR_COLOUR( "hcl", "Hair Color", true ),
    EYE_COLOUR( "ecl", "Eye Color", true ),
    PASSPORT_ID( "pid", "Passport ID", true ),
    COUNTRY_ID( "cid", "Country ID", false );

    private final String code;
    private final String description;
    private final boolean required;

    PassportField( final String code, final String description, boolean required )
    {
        this.code = code;
        this.description = description;
        this.required = required;
    }

    public static PassportField findFieldByCode( final String key )
    {
        return Arrays.stream( PassportField.values() )
                .filter( f -> f.getCode().equalsIgnoreCase( key ) )
                .findFirst()
                .orElseThrow( () -> new IllegalArgumentException( "Bad input code: " + key ) );
    }

    /**
     * @return The code.
     */
    public String getCode()
    {
        return code;
    }

    /**
     * @return The description.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return The required.
     */
    public boolean isRequired()
    {
        return required;
    }
}
