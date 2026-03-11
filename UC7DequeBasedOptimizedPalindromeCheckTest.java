
package com.palindromechecker;

import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;
import java.util.Deque;
import static org.junit.jupiter.api.Assertions.*;

public class UC7DequeBasedOptimizedPalindromeCheckTest {

    @Test
    public void testPalindromeUsingDeque() {
        String input = "racecar";
        assertTrue(isPalindromeUsingDeque(input), "racecar should be a palindrome using Deque");
    }

    @Test
    public void testNonPalindromeUsingDeque() {
        String input = "hello";
        assertFalse(isPalindromeUsingDeque(input), "hello should not be a palindrome using Deque");
    }

    @Test
    public void testSingleCharacterUsingDeque() {
        String input = "a";
        assertTrue(isPalindromeUsingDeque(input), "Single character should be a palindrome");
    }

    @Test
    public void testEmptyStringUsingDeque() {
        String input = "";
        assertTrue(isPalindromeUsingDeque(input), "Empty string should be considered a palindrome");
    }

    @Test
    public void testPalindromeWithSpaces() {
        String input = "A man a plan a canal Panama";
        assertTrue(isPalindromeUsingDeque(input), "Should be a palindrome ignoring spaces and case");
    }

    private boolean isPalindromeUsingDeque(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : cleanedStr.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}
