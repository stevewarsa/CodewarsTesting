package com.steve.warsa;

import static org.junit.jupiter.api.Assertions.*;

class CountingDuplicatesTest {

    @org.junit.jupiter.api.Test
    void duplicateCount() {
        assertEquals(4, CountingDuplicates.duplicateCount("abcdeaReturnsOne"));
    }
}