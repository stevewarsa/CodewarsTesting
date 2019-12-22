package com.steve.warsa;

import java.util.regex.Pattern;

public class DeadFish {
    /**
     * Write a simple parser that will parse and run Deadfish.
     *
     * Deadfish has 4 commands, each 1 character long:
     *
     * i increments the value (initially 0)
     * d decrements the value
     * s squares the value
     * o outputs the value into the return array
     * Invalid characters should be ignored.
     *
     * Deadfish.parse("iiisdoso") =- new int[] {8, 64};
     *
     * @param data
     * @return
     */
    public static int[] parse(String data) {
        // create an array the size of the number of "o" (output) in the string
        int[] retVal = new int[((int) Pattern.compile("o").matcher(data).results().count())];
        int currentInsertIndex = 0;
        int currentValue = 0;
        for (int i = 0; i < data.length(); i++) {
            char currChar = data.charAt(i);
            switch (currChar) {
                case 'i':
                    currentValue++;
                    break;
                case 'd':
                    currentValue--;
                    break;
                case 's':
                    currentValue = currentValue * currentValue;
                    break;
                case 'o':
                    retVal[currentInsertIndex++] = currentValue;
                    break;
            }
        }
        return retVal;
    }
}
