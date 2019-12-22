package com.steve.warsa;

import java.util.stream.Stream;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        // Write your code here
        if (text == null || text.length() == 0) {
            return 0;
        }
        //var dupCount = 0;
        //Stream.of(text.toUpperCase().split("")).forEach(str -> System.out.println(str));
        long count = Stream.of(text.toUpperCase().split(""))
                .count();
        long distinctCount = Stream.of(text.toUpperCase().split(""))
                .distinct()
                .count();
        System.out.println("Count = " + count + ", Distinct Count = " + distinctCount);
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(duplicateCount("Indivisibilities"));
    }
}
