package com.palindromechecker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC10CaseInsensitiveSpaceIgnoredPalindromeCheckTest {

    @Test
    public void testCaseInsensitivePalindrome() {
        String input = "RaceCar";
        assertTrue(isCaseInsensitiveSpaceIgnoredPalindrome(input), "RaceCar should be a palindrome ignoring case");
    }

    @Test
    public void testSpaceIgnoredPalindrome() {
        String input = "race car";
        assertTrue(isCaseInsensitiveSpaceIgnoredPalindrome(input), "race car should be a palindrome ignoring spaces");
    }

    @Test
    public void testCaseAndSpaceIgnoredPalindrome() {
        String input = "A man a plan a canal Panama";
        assertTrue(isCaseInsensitiveSpaceIgnoredPalindrome(input), "Should be a palindrome ignoring case and spaces");
    }

    @Test
    public void testNonPalindromeCaseInsensitive() {
        String input = "Hello World";
        assertFalse(isCaseInsensitiveSpaceIgnoredPalindrome(input), "Hello World should not be a palindrome");
    }

    @Test
    public void testEmptyString() {
        String input = "";
        assertTrue(isCaseInsensitiveSpaceIgnoredPalindrome(input), "Empty string should be considered a palindrome");
    }

    @Test
    public void testWithPunctuation() {
        String input = "Was it a car or a cat I saw?";
        assertTrue(isCaseInsensitiveSpaceIgnoredPalindrome(input), "Should be a palindrome ignoring case, spaces, and punctuation");
    }

    private boolean isCaseInsensitiveSpaceIgnoredPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        // Normalize: remove non-alphanumeric characters and convert to lowercase
        String normalizedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (normalizedStr.isEmpty()) {
            return true;
        }

        // Check if normalized string is palindrome
        int left = 0;
        int right = normalizedStr.length() - 1;

        while (left < right) {
            if (normalizedStr.charAt(left) != normalizedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
