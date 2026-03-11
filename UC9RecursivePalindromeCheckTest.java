package com.palindromechecker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC9RecursivePalindromeCheckTest {

    @Test
    public void testPalindromeUsingRecursion() {
        String input = "racecar";
        assertTrue(isPalindromeRecursive(input), "racecar should be a palindrome using recursion");
    }

    @Test
    public void testNonPalindromeUsingRecursion() {
        String input = "hello";
        assertFalse(isPalindromeRecursive(input), "hello should not be a palindrome using recursion");
    }

    @Test
    public void testSingleCharacterUsingRecursion() {
        String input = "a";
        assertTrue(isPalindromeRecursive(input), "Single character should be a palindrome");
    }

    @Test
    public void testEmptyStringUsingRecursion() {
        String input = "";
        assertTrue(isPalindromeRecursive(input), "Empty string should be considered a palindrome");
    }

    @Test
    public void testTwoCharacterPalindrome() {
        String input = "aa";
        assertTrue(isPalindromeRecursive(input), "aa should be a palindrome");
    }

    @Test
    public void testTwoCharacterNonPalindrome() {
        String input = "ab";
        assertFalse(isPalindromeRecursive(input), "ab should not be a palindrome");
    }

    private boolean isPalindromeRecursive(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return checkPalindromeRecursive(cleanedStr, 0, cleanedStr.length() - 1);
    }

    private boolean checkPalindromeRecursive(String str, int start, int end) {
        // Base condition: if start index crosses or meets end index, it's a palindrome
        if (start >= end) {
            return true;
        }

        // Compare characters at start and end positions
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call with narrowed range
        return checkPalindromeRecursive(str, start + 1, end - 1);
    }
}
