package com.palindromechecker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class UC11ObjectOrientedPalindromeServiceTest {

    private PalindromeCheckerService service;

    @BeforeEach
    public void setUp() {
        service = new PalindromeCheckerService();
    }

    @Test
    public void testPalindromeWithService() {
        assertTrue(service.checkPalindrome("racecar"), "racecar should be a palindrome");
    }

    @Test
    public void testNonPalindromeWithService() {
        assertFalse(service.checkPalindrome("hello"), "hello should not be a palindrome");
    }

    @Test
    public void testCaseInsensitiveWithService() {
        assertTrue(service.checkPalindrome("RaceCar"), "RaceCar should be a palindrome ignoring case");
    }

    @Test
    public void testWithSpacesAndPunctuation() {
        assertTrue(service.checkPalindrome("A man, a plan, a canal: Panama"), "Should be a palindrome");
    }

    // Inner class representing the Palindrome Checker Service
    // Demonstrates encapsulation and Single Responsibility Principle
    static class PalindromeCheckerService {
        
        public boolean checkPalindrome(String input) {
            if (input == null || input.isEmpty()) {
                return true;
            }
            
            String normalized = normalizeString(input);
            return isPalindrome(normalized);
        }

        private String normalizeString(String str) {
            // Remove non-alphanumeric characters and convert to lowercase
            return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        }

        private boolean isPalindrome(String str) {
            if (str.isEmpty()) {
                return true;
            }

            int left = 0;
            int right = str.length() - 1;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
    }
}
