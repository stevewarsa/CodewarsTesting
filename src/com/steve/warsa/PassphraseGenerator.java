package com.steve.warsa;

public class PassphraseGenerator {
    public static String playPass(String s, int n) {
        // First shift each letter of s by n, replace any digits by it's complement to 9 and keep special characters
        var newString = "";
        var chars = s.toCharArray();
        for (var i = 0; i < chars.length; i++) {
            var currLetter = String.valueOf(chars[i]).toUpperCase();
            if (Character.isAlphabetic(chars[i])) {
                newString += shiftLetter(currLetter, n);
            } else if (Character.isDigit(chars[i])) {
                newString += replaceNumByComplementToNine(Integer.parseInt(Character.toString(chars[i])));
            } else {
                // special character or space
                newString += chars[i];
            }
        }
        var sb = new StringBuilder(newString);
        for (var i = 0; i < sb.length(); i++) {
            if (i % 2 != 0) {
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
            } else {
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            }
        }
        return sb.reverse().toString();
    }

    public static String shiftLetter(String letter, int increment) {
        if (increment == 0 || increment > 25) return letter;
        var allLetters = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        var currentPosition = allLetters.indexOf(letter);
        var newPosition = currentPosition + increment;
        if (newPosition > 25) {
            newPosition = newPosition - 26;
        }
        return String.valueOf(allLetters.charAt(newPosition));
    }

    public static String replaceNumByComplementToNine(int num) {
        return String.valueOf(9 - num);
    }
}
