package com.techreturners.roman_numerals_kata.app;

import com.techreturners.roman_numerals_kata.model.Numeral;

public class Converter {

    public Numeral convertNumberToNumeral(int i) {
        if(i == 1){
            return Numeral.I;
        } else{
            return null;
        }
    }
}
