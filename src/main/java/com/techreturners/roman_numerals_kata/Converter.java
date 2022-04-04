package com.techreturners.roman_numerals_kata;

import java.util.Map;

import static java.util.Map.entry;

public class Converter {

    Map<Integer, String> baseNumerals = Map.ofEntries(
            entry(1, "I"),
            entry(2, "II"),
            entry(3, "III"),
            entry(4, "IV"),
            entry(5, "V"),
            entry(6, "VI"),
            entry(7, "VII"),
            entry(8, "VIII"),
            entry(9, "IX"),
            entry(10, "X"),
            entry(20, "XX"),
            entry(30, "XXX"),
            entry(40, "XL"),
            entry(50, "L"),
            entry(60, "LX"),
            entry(70, "LXX"),
            entry(80, "LXXX"),
            entry(90, "XC"),
            entry(100, "C"),
            entry(200, "CC"),
            entry(300, "CCC"),
            entry(400, "CD"),
            entry(500, "D"),
            entry(600, "DC"),
            entry(700, "DCC"),
            entry(800, "DCCC"),
            entry(900, "CM"),
            entry(1000, "M"),
            entry(2000, "MM"),
            entry(3000, "MMM")
    );

    public String convertNumberToNumeral(int i) {

        if (i < 1) return null;

        //Break int into Thousands, Hundreds, Tens and Ones
        int thousands = thousands(i);
        int hundreds = hundreds(i);
        int tens = tens(i);
        int ones = ones(i);

        //Find Numeral for each part
        String numeralsForThousands = baseNumerals.get(thousands);
        String numeralsForHundreds = baseNumerals.get(hundreds);
        String numeralForTens = baseNumerals.get(tens);
        String numeralForOnes = baseNumerals.get(ones);

        //Concat each part
        return String.format(
                "%s%s%s%s",
                numeralsForThousands == null? "" : numeralsForThousands, //Map.get() returns null if key not present
                numeralsForHundreds == null? "" : numeralsForHundreds,
                numeralForTens == null ? "" : numeralForTens,
                numeralForOnes == null ? "" : numeralForOnes
        );
    }

    /**
     * Returns the Thousands part of an int
     */
    private int thousands(int i) {
        int numberOfThousands = (i / 1000) % 10;
        return  numberOfThousands * 1000;
    }

    /**
     * Returns the Hundreds part of an int
     */
    private int hundreds(int i) {
        int numberOfHundreds = (i / 100) % 10;
        return numberOfHundreds * 100;
    }

    //returns the Tens part of an int
    private int tens(int i) {
        int numberOfTens = (i / 10) % 10;
        return numberOfTens * 10;
    }

    //returns the Ones part of an int
    private int ones(int i) {
        return i % 10;
    }
}
