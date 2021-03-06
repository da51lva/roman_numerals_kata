package com.techreturners.roman_numerals_kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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


    @Test
    public void test1To100() {
        testIntegerToNumeralConversionForNumeralsInFile("numerals-1-to-99.csv");
    }

    @Test
    public void test1To3000() {
        testIntegerToNumeralConversionForNumeralsInFile("numerals-1-to-3000.csv");
    }

    private void testIntegerToNumeralConversionForNumeralsInFile(String filename){
        Scanner s = null;

        try {

            //load test resource
            URL url =  getClass().getClassLoader().getResource(filename);
            if (url == null)
                throw new FileNotFoundException();

            File numeralsFile = new File(url.getFile());
            s = new Scanner(numeralsFile);
            s.useDelimiter(",");

            //test every numeral in the test file ascending
            int i = 1;
            while (s.hasNext()) {
                assertEquals(s.next(), c.convertNumberToNumeral(i));
                i++;
            }

        } catch (FileNotFoundException e) {
            fail("Error loading test resource file: "+filename);
            e.printStackTrace();
        } finally {
            if(s != null)
                s.close();
        }
    }

    @Test
    public void testGreaterThan3000(){
        for(int i = 3001; i < Integer.MAX_VALUE; i++)
            assertEquals(null, c.convertNumberToNumeral(i));
    }

    @Test
    public void testLessThan1(){
        for(int i = 0; i > Integer.MIN_VALUE; i--)
            assertEquals(null, c.convertNumberToNumeral(i));
    }


}