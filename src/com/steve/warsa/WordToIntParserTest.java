package com.steve.warsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordToIntParserTest {

    @Test
    void parseInt() {
        assertEquals(1, WordToIntParser.parseInt("one"));
        assertEquals(20, WordToIntParser.parseInt("twenty"));
        assertEquals(246, WordToIntParser.parseInt("two hundred forty-six"));
        assertEquals(14597, WordToIntParser.parseInt("fourteen thousand five hundred ninety-seven"));
        assertEquals(783919, WordToIntParser.parseInt("seven hundred eighty-three thousand nine hundred nineteen"));
    }

    @Test
    void wordToNumber() {
        assertEquals(1, WordToIntParser.wordToNumber("one"));
        assertEquals(13, WordToIntParser.wordToNumber("thirteen"));
        assertEquals(14, WordToIntParser.wordToNumber("fourteen"));
        assertEquals(15, WordToIntParser.wordToNumber("fifteen"));
        assertEquals(16, WordToIntParser.wordToNumber("sixteen"));
        assertEquals(17, WordToIntParser.wordToNumber("seventeen"));
        assertEquals(18, WordToIntParser.wordToNumber("eighteen"));
        assertEquals(19, WordToIntParser.wordToNumber("nineteen"));
        assertEquals(20, WordToIntParser.wordToNumber("twenty"));
        assertEquals(30, WordToIntParser.wordToNumber("thirty"));
        assertEquals(40, WordToIntParser.wordToNumber("fourty"));
        assertEquals(50, WordToIntParser.wordToNumber("fifty"));
        assertEquals(60, WordToIntParser.wordToNumber("sixty"));
        assertEquals(70, WordToIntParser.wordToNumber("seventy"));
        assertEquals(80, WordToIntParser.wordToNumber("eighty"));
        assertEquals(90, WordToIntParser.wordToNumber("ninety"));
        assertEquals(100, WordToIntParser.wordToNumber("onehundred"));
        assertEquals(14000, WordToIntParser.wordToNumber("fourteenthousand"));
        assertEquals(1500, WordToIntParser.wordToNumber("fifteenhundred"));
    }
}