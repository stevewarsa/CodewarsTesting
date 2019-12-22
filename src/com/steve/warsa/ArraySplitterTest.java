package com.steve.warsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySplitterTest {

    @Test
    void splitAndAdd() {
        var inputArray = new int[] {4, 2, 5, 3, 2, 5, 7};
        var result = ArraySplitter.splitAndAdd(inputArray, 2);
        var expected = new int[] {10, 18};
        assertArrayEquals(expected, result);
    }

    @Test
    void splitArray() {
        var splitArray = ArraySplitter.splitArray(new int[]{4, 2, 5, 3, 2, 5, 7});
        assertArrayEquals(new int[] {0, 4, 2, 5},splitArray[0]);
        assertArrayEquals(new int[] {3, 2, 5, 7},splitArray[1]);
    }

    @Test
    void addArrays() {
        var addedArrayResult = ArraySplitter.addArrays(new int[][]{{0, 4, 2, 5}, {3, 2, 5, 7}});
        assertArrayEquals(new int[] {3, 6, 7, 12}, addedArrayResult);
    }

    @Test
    void equalizeArraySizes() {
        var equalizedArrays = ArraySplitter.equalizeArraySizes(new int[][]{{4, 2, 5}, {3, 2, 5, 7}});
        assertArrayEquals(equalizedArrays[0], new int[] {0, 4, 2, 5});
        assertArrayEquals(equalizedArrays[1], new int[] {3, 2, 5, 7});
    }

    @Test
    void increaseAndFillArray() {
        var increasedArray = ArraySplitter.increaseAndFillArray(new int[]{4, 2, 5}, 4);
        assertArrayEquals(new int[] {0, 4, 2, 5}, increasedArray);
        increasedArray = ArraySplitter.increaseAndFillArray(new int[]{4, 2, 5}, 5);
        assertArrayEquals(new int[] {0, 0, 4, 2, 5}, increasedArray);
        increasedArray = ArraySplitter.increaseAndFillArray(new int[]{4, 2, 5}, 6);
        assertArrayEquals(new int[] {0, 0, 0, 4, 2, 5}, increasedArray);
        increasedArray = ArraySplitter.increaseAndFillArray(new int[]{4, 2, 5}, 3);
        assertArrayEquals(new int[] {4, 2, 5}, increasedArray);
    }
}