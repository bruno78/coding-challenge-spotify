package com.brunogtavares;

import java.util.Stack;

/**
 * Question 2 -- decodeString(s): Given an encoded string, return its corresponding decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is
 * repeated exactly k times. Note: k is guaranteed to be a positive integer.
 *
 * For s = "4[ab]", the output should be decodeString(s) = "abababab"
 * For s = "2[b3[a]]", the output should be decodeString(s) = "baaabaaa"
 *
 */
public class DecodeString {

    public static void main(String[] args) {
        // write your code here
        System.out.println(decodeString("4[ab]"));
        System.out.println(decodeString("2[b3[a]]"));
    }

    public static String decodeString(String string) {
        Stack<StringSequence> stringSequenceStack = new Stack<>();
        stringSequenceStack.push(new StringSequence(1));
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

           if (Character.isDigit(c)) {
               int number = Integer.parseInt(Character.toString(c));
               count = count * 10 + number;
           }
           if (c == '[') {
               stringSequenceStack.push(new StringSequence(count));
               // reset counts
               count = 0;
           }
           if (Character.isAlphabetic(c)) {
               stringSequenceStack.peek().addToSequence(Character.toString(c));
           }
           if (c ==']') {

               int times = stringSequenceStack.peek().getNumOfRepeats();
               String sequence = stringSequenceStack.pop().getSequence();

               while(times > 0) {
                   stringSequenceStack.peek().addToSequence(sequence);
                   times --;
               }
           }
        }
        return stringSequenceStack.pop().getSequence();
    }

    public static class StringSequence {
        private int mNumOfRepeats;
        private StringBuilder mSequence;

        public StringSequence(int repeatingTimes) {
            mNumOfRepeats = repeatingTimes;
            mSequence = new StringBuilder();
        }

        public void addToSequence(String sequence) {
            mSequence.append(sequence);
        }

        public String getSequence() {
            return mSequence.toString();
        }

        public int getNumOfRepeats() {
            return mNumOfRepeats;
        }

    }


}
