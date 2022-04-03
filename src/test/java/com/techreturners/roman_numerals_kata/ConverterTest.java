package com.techreturners.roman_numerals_kata;

import com.techreturners.roman_numerals_kata.app.Converter;
import com.techreturners.roman_numerals_kata.model.Numeral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {

    Converter c;

    @BeforeEach
    public void setUp() {
        c = new Converter();
    }

    @Test
    public void test0() {
        assertEquals(null, c.convertNumberToNumeral(0));
    }

    @Test
    public void test1() {
        assertEquals(Numeral.I, c.convertNumberToNumeral(1));
    }

}