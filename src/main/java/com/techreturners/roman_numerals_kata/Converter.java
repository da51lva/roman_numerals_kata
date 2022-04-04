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
            entry(90, "XC")
    );

    public String convertNumberToNumeral(int i) {

        if (i < 1) return null;

        int tens = tens(i);
        int ones = ones(i);

        String numeralForTens = baseNumerals.get(tens);
        String numeralForOnes = baseNumerals.get(ones);

        return String.format(
                "%s%s",
                numeralForTens == null ? "" : numeralForTens, //Map.get() returns null if key not present
                numeralForOnes == null ? "" : numeralForOnes
        );
    }

    //returns the Tens part of an int
    private int tens(int i) {
        return (i / 10) * 10; // i / 10 automatically rounds down
    }

    //returns the Ones part of an int
    private int ones(int i) {
        return i % 10;
    }
}
