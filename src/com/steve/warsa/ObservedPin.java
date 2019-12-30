package com.steve.warsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Alright, detective, one of our colleagues successfully observed our target person, Robby the robber. We followed him
 * to a secret warehouse, where we assume to find all the stolen stuff. The door to this warehouse is secured by an
 * electronic combination lock. Unfortunately our spy isn't sure about the PIN he saw, when Robby entered it.
 * <p>
 * The keypad has the following layout:
 * <p>
 * ┌───┬───┬───┐
 * │ 1 │ 2 │ 3 │
 * ├───┼───┼───┤
 * │ 4 │ 5 │ 6 │
 * ├───┼───┼───┤
 * │ 7 │ 8 │ 9 │
 * └───┼───┼───┘
 * │ 0 │
 * └───┘
 * He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could actually be another
 * adjacent digit (horizontally or vertically, but not diagonally). E.g. instead of the 1 it could also be the 2 or 4.
 * And instead of the 5 it could also be the 2, 4, 6 or 8.
 * <p>
 * He also mentioned, he knows this kind of locks. You can enter an unlimited amount of wrong PINs, they never finally
 * lock the system or sound the alarm. That's why we can try out all possible (*) variations.
 * <p>
 * * possible in sense of: the observed PIN itself and all variations considering the adjacent digits
 * <p>
 * Can you help us to find all those variations? It would be nice to have a function, that returns an array (or a list
 * in Java and C#) of all variations for an observed PIN with a length of 1 to 8 digits. We could name the function getPINs
 * (get_pins in python, GetPINs in C#). But please note that all PINs, the observed one and also the results, must be
 * strings, because of potentially leading '0's. We already prepared some test cases for you.
 * <p>
 * Detective, we count on you!
 */
public class ObservedPin {
    public static List<String> getPINs(String observed) {
        HashMap<String, String[]> adjacents = new HashMap<>();
        adjacents.put("1", new String[]{"1", "2", "4"});
        adjacents.put("2", new String[]{"1", "2", "3", "5"});
        adjacents.put("3", new String[]{"2", "3", "6"});
        adjacents.put("4", new String[]{"1", "4", "5", "7"});
        adjacents.put("5", new String[]{"2", "4", "5", "6", "8"});
        adjacents.put("6", new String[]{"3", "5", "6", "9"});
        adjacents.put("7", new String[]{"4", "7", "8"});
        adjacents.put("8", new String[]{"5", "7", "8", "9", "0"});
        adjacents.put("9", new String[]{"6", "8", "9"});
        adjacents.put("0", new String[]{"0", "8"});

        StringBuilder pinBuilder = new StringBuilder(observed);
        char[] observedPin = observed.toCharArray();
        String[] firstPositionValues = adjacents.get(String.valueOf(observedPin[0]));
        List<String> pins = new ArrayList<>();
        for (String value : firstPositionValues) {
            pinBuilder.setCharAt(0, value.charAt(0));
            int currentDigit = 1; //Start from the first digit after the first
            int[] currentPermutation = new int[observedPin.length]; //Keeps track of how many potential permutations for a given number
            if (observedPin.length > 1) {
                //Loop through the rest of the pin checking each possible permutation
                while (currentDigit != observedPin.length && currentDigit > 0) {
                    //Get all the possible alternative values for the current digit in the pin
                    String[] values = adjacents.get(String.valueOf(observedPin[currentDigit]));
                    if (currentDigit == observedPin.length - 1) {
                        //if the current permutation is less than the possible values
                        if (currentPermutation[currentDigit] < values.length) {
                            for (String val : values) {
                                pinBuilder.setCharAt(currentDigit, val.charAt(0));
                                if (currentPermutation[currentDigit] < values.length) {
                                    currentPermutation[currentDigit]++;
                                }
                                //Don't add duplicates
                                if (pins.indexOf(pinBuilder.toString()) == -1) {
                                    pins.add(pinBuilder.toString());
                                }
                            }
                        } else {
                            currentPermutation[currentDigit] = 0;
                            currentDigit = currentDigit - 1;
                        }
                    } else {
                        if (currentPermutation[currentDigit] < values.length) {
                            pinBuilder.setCharAt(currentDigit, values[currentPermutation[currentDigit]].charAt(0));
                            currentPermutation[currentDigit]++;
                            currentDigit++;
                        } else {
                            currentPermutation[currentDigit] = 0;
                            currentDigit = currentDigit - 1;
                        }
                    }
                }
            }

            if (pins.indexOf(pinBuilder.toString()) == -1) {
                pins.add(pinBuilder.toString());
            }
        }
        return pins;
    }

    static List<Integer> getAdjacentNumbers(Integer number) {
        if (number == null || number < 0 || number > 9) {
            return new ArrayList<>();
        }
        var keypad = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9),
                List.of(-1, 0, -1)
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
