package com.techreturners.roman_numerals_kata;

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
        assertEquals("I", c.convertNumberToNumeral(1));
    }

    @Test
    public void test1To10(){
        String[] numeralsTo10 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        for(int i = 1; i < 11; i++){
            assertEquals(numeralsTo10[i-1], c.convertNumberToNumeral(i));
        }
    }

}