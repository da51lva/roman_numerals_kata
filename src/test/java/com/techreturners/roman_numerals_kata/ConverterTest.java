package com.techreturners.roman_numerals_kata;

import com.techreturners.roman_numerals_kata.app.Converter;
import com.techreturners.roman_numerals_kata.model.Numeral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {

    @Test
    public void test1(){
        Converter c = new Converter();

        assertEquals(Numeral.I, c.convertNumberToNumeral(1));
    }

}