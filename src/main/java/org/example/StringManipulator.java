package org.example;

public class StringManipulator {
    public String reverseString(String input) {
        // TODO: Implement the logic to reverse the input string
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome(String input) {
        // TODO: Implement the logic to check if the input string is a palindrome
        // (A palindrome = same forwards as backwards)
        StringManipulator manipulator = new StringManipulator();
        return input.equals(manipulator.reverseString(input));
        //return false;
    }
}
