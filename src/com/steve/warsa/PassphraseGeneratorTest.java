package com.steve.warsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassphraseGeneratorTest {

    @Test
    void playPass() {
        var passPhrase = PassphraseGenerator.playPass("BORN IN 2015!", 1);
        // Phase 1, 2, 3 only
        // assertEquals("CPSO JO 7984!", passPhrase);
        // Phase 1,2,3,4
        // assertEquals("CpSo jO 7984!", passPhrase);
        // Phase 1,2,3,4,5
        assertEquals("!4897 Oj oSpC", passPhrase);
        assertEquals("4897 NkTrC Hq fT67 GjV Pq aP OqTh gOcE CoPcTi aO", PassphraseGenerator.playPass("MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015", 2));
    }

    @Test
    void shiftLetter() {
        assertEquals("B", PassphraseGenerator.shiftLetter("A", 1));
        assertEquals("C", PassphraseGenerator.shiftLetter("A", 2));
        assertEquals("A", PassphraseGenerator.shiftLetter("Z", 1));
        assertEquals("B", PassphraseGenerator.shiftLetter("Z", 2));
        assertEquals("A", PassphraseGenerator.shiftLetter("Y", 2));
    }

    @Test
    void replaceNumByComplementToNine() {
        assertEquals("2", PassphraseGenerator.replaceNumByComplementToNine(7));
        assertEquals("9", PassphraseGenerator.replaceNumByComplementToNine(0));
        assertEquals("-11", PassphraseGenerator.replaceNumByComplementToNine(20));
        assertEquals("10", PassphraseGenerator.replaceNumByComplementToNine(-1));
    }
}