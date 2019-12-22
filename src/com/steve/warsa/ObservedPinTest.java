package com.steve.warsa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObservedPinTest {
    @Test
    void testAdjacent() {
        Integer[] adjacentNumbers = ObservedPin.getAdjacentNumbers(1).toArray(new Integer[0]);
        assertArrayEquals(new Integer[] {2, 4}, adjacentNumbers);
        adjacentNumbers = ObservedPin.getAdjacentNumbers(2).toArray(new Integer[0]);
        assertArrayEquals(new Integer[] {1, 3, 5}, adjacentNumbers);
        adjacentNumbers = ObservedPin.getAdjacentNumbers(3).toArray(new Integer[0]);
        assertArrayEquals(new Integer[] {2, 6}, adjacentNumbers);
        adjacentNumbers = ObservedPin.getAdjacentNumbers(4).toArray(new Integer[0]);
        assertArrayEquals(new Integer[] {5, 1, 7}, adjacentNumbers);
        adjacentNumbers = ObservedPin.getAdjacentNumbers(5).toArray(new Integer[0]);
        assertArrayEquals(new Integer[] {4, 6, 2, 8}, adjacentNumbers);
        adjacentNumbers = ObservedPin.getAdjacentNumbers(6).toArray(new Integer[0]);
        assertArrayEquals(new Integer[] {5, 3, 9}, adjacentNumbers);
        adjacentNumbers = ObservedPin.getAdjacentNumbers(7).toArray(new Integer[0]);
        assertArrayEquals(new Integer[] {8, 4}, adjacentNumbers);
        adjacentNumbers = ObservedPin.getAdjacentNumbers(8).toArray(new Integer[0]);
        assertArrayEquals(new Integer[] {7, 9, 5, 0}, adjacentNumbers);
        adjacentNumbers = ObservedPin.getAdjacentNumbers(9).toArray(new Integer[0]);
        assertArrayEquals(new Integer[] {8, 6}, adjacentNumbers);
        adjacentNumbers = ObservedPin.getAdjacentNumbers(0).toArray(new Integer[0]);
        assertArrayEquals(new Integer[] {8}, adjacentNumbers);
    }
    public static HashMap<String, String[]> expectations = new HashMap<>() {
        {
            put("8", new String[]{"5", "7", "8", "9", "0"});
            put("11", new String[]{"11", "21", "41", "12", "22", "42", "14", "24", "44"});
            put("369", new String[]{"236", "238", "239", "256", "258", "259", "266", "268", "269", "296", "298", "299", "336", "338", "339", "356", "358", "359", "366", "368", "369", "396", "398", "399", "636", "638", "639", "656", "658", "659", "666", "668", "669", "696", "698", "699"});
        }
    };
    private final static Comparator<String> comp = Comparator.naturalOrder();

    @Test
    public void testPins() {
        for (String entered : expectations.keySet()) {
            test(entered, Arrays.asList(expectations.get(entered)), ObservedPin.getPINs(entered));
        }
    } // testPins

    private void test(String entered, List<String> expected, List<String> result) {
        result.sort(comp);
        expected.sort(comp);
        assertEquals(expected, result, "For String '" + entered + "' the following results were expected");
    }
}