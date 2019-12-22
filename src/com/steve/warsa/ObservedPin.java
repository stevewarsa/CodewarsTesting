package com.steve.warsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Alright, detective, one of our colleagues successfully observed our target person, Robby the robber. We followed him
 * to a secret warehouse, where we assume to find all the stolen stuff. The door to this warehouse is secured by an
 * electronic combination lock. Unfortunately our spy isn't sure about the PIN he saw, when Robby entered it.
 *
 * The keypad has the following layout:
 *
 * ┌───┬───┬───┐
 * │ 1 │ 2 │ 3 │
 * ├───┼───┼───┤
 * │ 4 │ 5 │ 6 │
 * ├───┼───┼───┤
 * │ 7 │ 8 │ 9 │
 * └───┼───┼───┘
 *     │ 0 │
 *     └───┘
 * He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could actually be another
 * adjacent digit (horizontally or vertically, but not diagonally). E.g. instead of the 1 it could also be the 2 or 4.
 * And instead of the 5 it could also be the 2, 4, 6 or 8.
 *
 * He also mentioned, he knows this kind of locks. You can enter an unlimited amount of wrong PINs, they never finally
 * lock the system or sound the alarm. That's why we can try out all possible (*) variations.
 *
 * * possible in sense of: the observed PIN itself and all variations considering the adjacent digits
 *
 * Can you help us to find all those variations? It would be nice to have a function, that returns an array (or a list
 * in Java and C#) of all variations for an observed PIN with a length of 1 to 8 digits. We could name the function getPINs
 * (get_pins in python, GetPINs in C#). But please note that all PINs, the observed one and also the results, must be
 * strings, because of potentially leading '0's. We already prepared some test cases for you.
 *
 * Detective, we count on you!
 */
public class ObservedPin {
    public static List<String> getPINs(String observed) {
        HashMap<Integer, List<Integer>> possibleAlternatesForNumber = new HashMap<>();
        Stream.of("1234567890".split(""))
                .map(ch -> Integer.valueOf(ch))
                .forEach(num -> possibleAlternatesForNumber.put(num, getAdjacentNumbers(num)));
        var possiblePins = new ArrayList<String>(){{
            add(observed);
        }};
        var enteredChars = observed.split("");
        for (var i = 0; i < enteredChars.length; i++) {
            var enteredNum = Integer.valueOf(enteredChars[i]);
            var variations = possibleAlternatesForNumber.get(enteredNum);
            for (var variation : variations) {
                var sb = new StringBuilder(observed);
                sb.setCharAt(i, String.valueOf(variation).charAt(0));
                possiblePins.add(sb.toString());
            }
        }
        return possiblePins;
    }

    static List<Integer> getAdjacentNumbers(Integer number) {
        if (number == null || number < 0 || number > 9) {
            return new ArrayList<>();
        }
        var keypad = List.of(
                List.of(1,       2,      3),
                List.of(4,       5,      6),
                List.of(7,       8,      9),
                List.of(-1,    0,      -1)
        );
        List<Integer> results = new ArrayList<>();
        for (int currRow = 0; currRow < keypad.size(); currRow++) {
            var row = keypad.get(currRow);
            var positionInRow = row.indexOf(number);
            if (positionInRow == -1) {
                continue;
            }
            // this row contains the number, check to see if number to left exists
            if (row.indexOf(number - 1) > -1 && number - 1 > -1) {
                results.add(number - 1);
            }
            // check to see if number to right exists
            if (row.indexOf(number + 1) > -1) {
                results.add(number + 1);
            }
            if (currRow - 1 >= 0) {
                var prevRow = keypad.get(currRow - 1);
                results.add(prevRow.get(positionInRow));
            }
            if (currRow + 1 < keypad.size()) {
                var nextRow = keypad.get(currRow + 1);
                var nextRowSameCol = nextRow.get(positionInRow);
                if (nextRowSameCol >= 0) {
                    results.add(nextRowSameCol);
                }
            }
        }
        return results;
    }
}
