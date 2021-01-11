/*
 * Copyright 2021 Applied Card Technologies Ltd
 */
package org.example.aoc.day4b;

import java.util.Arrays;

/**
 * @author pshipley
 */
public enum PassportField
{
    BIRTH_YEAR( "byr", "Birth Year"),
    ISSUE_YEAR( "iyr", "Issue Year"),
    EXP_YEAR( "eyr", "Expiration Year"),
    HEIGHT( "hgt", "Height"),
    HAIR_COLOUR( "hcl", "Hair Color"),
    EYE_COLOUR( "ecl", "Eye Color"),
    PASSPORT_ID( "pid", "Passport ID"),
    COUNTRY_ID( "cid", "Country ID");

    private final String code;
    private final String description;

    PassportField( final String code, final String description )
    {
        this.code = code;
        this.description = description;
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

}
