package com.brunogtavares;

import java.util.HashMap;
import java.util.Map;

/**
 * Question 1 -- sortByStrings(s,t): Sort the letters in the string s by the order they occur in the string t.
 * You can assume t will not have repetitive characters. For s = "weather" and t = "therapyw", the output
 * should be sortByString(s, t) = "theeraw". For s = "good" and t = "odg", the output should be
 * sortByString(s, t) = "oodg".
 */
public class SortByStrings {

    public static void main(String[] args) {
	// write your code here
        System.out.println(sortByString("weather", "therapyw"));
        System.out.println(sortByString("good", "odg"));
    }



    public static String sortByString(String s, String t) {

        Map<Character, Integer> sCharList = new HashMap<>();
        StringBuilder sortByStringResult = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!sCharList.containsKey(letter)) {
                sCharList.put(letter, 1);
            }
            else {
                sCharList.put(letter, sCharList.get(letter) + 1);
            }
        }

        for (int k = 0; k < t.length(); k++) {
            char letter = t.charAt(k);
            if (s.indexOf(letter) != -1) {
                int times = sCharList.get(letter);
                sortByStringResult.append(repeatChar(letter, times));
            }
        }

        return sortByStringResult.toString();

    }

    private static String repeatChar(char letter, int times) {
        StringBuilder result = new StringBuilder();

        if (times < 2) return result.append(letter).toString();

        for (int i = 0; i < times;  i++) {
            result.append(letter);
        }
        return result.toString();
    }
}
