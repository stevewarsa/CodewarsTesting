package com.steve.warsa;

import java.util.Arrays;

public class ArraySplitter {
    public static int[] splitAndAdd(int[] numbers, int n) {
        // Best solution from codewars.com
        while (numbers.length > 1 && n-- > 0) {
            int[] tmp = Arrays.copyOfRange(numbers, numbers.length/2, numbers.length);
            for (int i = 0 ; i < numbers.length/2 ; i++) {
                tmp[i + numbers.length % 2] += numbers[i];
            }
            numbers = tmp;
        }
        return numbers;

        // this was my first try solution... (not great - too complicated)
//        int[] addResult = numbers;
//        for (var round = 0; round < n; round++) {
//            addResult = addArrays(splitArray(addResult));
//            if (addResult.length == 1) {
//                return addResult;
//            }
//        }
//        return addResult;
    }

    public static int[][] splitArray(int[] input) {
        int halfwayPoint = input.length / 2;
        var part1 = Arrays.copyOfRange(input, 0, halfwayPoint);
        var part2 = Arrays.copyOfRange(input, halfwayPoint, input.length);
        return equalizeArraySizes(new int[][] {part1, part2});
    }

    public static int[] addArrays(int[][] input) {
        var newArray = new int[input[0].length];
        for (var i = 0; i < input[0].length; i++) {
            newArray[i] = input[0][i] + input[1][i];
        }
        return newArray;
    }

    public static int[][] equalizeArraySizes(int[][] input) {
        // 2 example input arrays:
        //       {4, 2, 5}
        //       {3, 2, 5, 7}
        // Output for this example:
        //       {0, 4, 2, 5}
        //       {3, 2, 5, 7}
        if (input[0].length == input[1].length) {
            return input;
        }
        else if (input[0].length > input[1].length) {
            return new int[][] {increaseAndFillArray(input[1], input[0].length), input[0]};
        } else {
            // input[1].length > input[0].length
            return new int[][] {increaseAndFillArray(input[0], input[1].length), input[1]};
        }
    }

    public static int[] increaseAndFillArray(int[] input, int toSize) {
        var newArray = new int[toSize];
        Arrays.fill(newArray, 0);
        var copyStartRange = toSize - input.length;
        for (var i = copyStartRange; i < newArray.length; i++) {
            newArray[i] = input[i - copyStartRange];
        }
        return newArray;
    }
}
