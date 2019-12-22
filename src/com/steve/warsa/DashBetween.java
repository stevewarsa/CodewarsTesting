package com.steve.warsa;

public class DashBetween {
    public static String dashatize(int num) {
        var newString = "";
        var chars = String.valueOf(num).toCharArray();
        for (var i = 0; i < chars.length; i++) {
            if (chars[i] == '-') continue;
            newString += (Character.getNumericValue(chars[i]) % 2 != 0 ? "-" + chars[i] + "-" : chars[i]);
        }
        newString = newString.replace("--", "-");
        if (newString.startsWith("-")) {
            newString = newString.substring(1);
        }
        if (newString.endsWith("-")) {
            newString = newString.substring(0, newString.length() - 1);
        }
        return newString;
    }

    public static void main(String[] args) {
        System.out.println(dashatize(-1));
    }
}
