package com.steve.warsa;

import java.util.HashMap;
import java.util.Map;

public class WordToIntParser {
    static Map<String, Integer> numbers = new HashMap<>() {
        {
            put("one", 1);
            put("two", 2);
            put("twen", 2);
            put("three", 3);
            put("thir", 3);
            put("four", 4);
            put("for", 4);
            put("five", 5);
            put("fif", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("eigh", 8);
            put("nine", 9);
            put("ten", 10);
            put("eleven", 11);
            put("twelve", 12);
        }
    };
    public static int parseInt(String numStr) {
        numStr = numStr.replace(" hundred", "hundred").replace(" thousand", "thousand").replace('-', ' ');
        System.out.println("Here is the new number string: " + numStr);
        var words = numStr.split(" ");
        int runningValue = 0;
        for (var word : words) {
            runningValue += wordToNumber(word);
        }
        return runningValue;
    }

    static int wordToNumber(String word) {
        if (numbers.containsKey(word)) {
            return numbers.get(word);
        }
        if (word.endsWith("teen")) {
            var firstPart = word.split("teen")[0];
            return numbers.get(firstPart) + 10;
        } else if (word.endsWith("ty")) {
            var firstPart = word.split("ty")[0];
            return numbers.get(firstPart) * 10;
        } else if (word.endsWith("hundred")) {
            var firstPart = word.split("hundred")[0];
            if (numbers.containsKey(firstPart)) {
                return numbers.get(firstPart) * 100;
            } else {
                return wordToNumber(firstPart) * 100;
            }
        } else if (word.endsWith("thousand")) {
            var firstPart = word.split("thousand")[0];
            if (numbers.containsKey(firstPart)) {
                return numbers.get(firstPart) * 1000;
            } else {
                return wordToNumber(firstPart) * 1000;
            }
        }
        return -1;
    }
}
