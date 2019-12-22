package com.steve.warsa;

/**
 * You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:
 *
 * Your message is a string containing space separated words.
 * You need to encrypt each word in the message using the following rules:
 * The first letter needs to be converted to its ASCII code.
 * The second letter needs to be switched with the last letter
 * Keepin' it simple: There are no special characters in input.
 *
 * Examples:
 * Kata.encryptThis("Hello") => "72olle"
 * Kata.encryptThis("good") => "103doo"
 * Kata.encryptThis("hello world") => "104olle 119drlo"
 */
public class EncryptByRule {
    public static String encryptThis(String text) {
        if (text == null || text.trim().equals("") || text.trim().length() < 3) {
            return text;
        }
        String[] words = text.split(" ");
        String newSentence = "";
        for (String word : words) {
            if (word.length() == 1) {
                newSentence += (int)word.charAt(0) + " ";
                continue;
            }
            StringBuilder sb = new StringBuilder(word);
            sb.setCharAt(word.length() - 1, word.charAt(1));
            sb.setCharAt(1, word.charAt(word.length() - 1));
            sb.delete(0, 1);
            newSentence += (int)word.charAt(0) + sb.toString() + " ";
        }
        return newSentence.trim();
    }
}
