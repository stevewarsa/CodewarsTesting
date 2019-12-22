package com.steve.warsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptByRuleTest {

    @Test
    void encryptThis() {
        assertEquals("72olle", EncryptByRule.encryptThis("Hello"));
        assertEquals("103doo", EncryptByRule.encryptThis("good"));
        assertEquals("104olle 119drlo", EncryptByRule.encryptThis("hello world"));
    }
}