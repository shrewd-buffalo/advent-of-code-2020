/*
 * Copyright 2021 Applied Card Technologies Ltd
 */

package org.example.aoc.day4a;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author pshipley
 */
class PassportParserTest
{

    @Test
    void shouldParseListOfPassports()
    {
        final List<String> input = new ArrayList<>();
        input.add( "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884" );
        input.add( "hcl:#cfa07d byr:1929" );
        input.add( "" );
        input.add( "hcl:#ae17e1 iyr:2013" );
        input.add( "eyr:2024" );
        input.add( "ecl:brn pid:760753108 byr:1931" );
        input.add( "hgt:179cm" );

        final List<Passport> parsedPassports = PassportParser.parsePassports( input );
        assertEquals( 2, parsedPassports.size() );
        assertEquals( 7, parsedPassports.get( 0 ).getFields().size() );
        assertEquals( 7, parsedPassports.get( 1 ).getFields().size() );
    }

}
