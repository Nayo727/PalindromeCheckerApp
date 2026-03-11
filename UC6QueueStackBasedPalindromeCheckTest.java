package com.palindromechecker;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import static org.junit.jupiter.api.Assertions.*;

public class UC6QueueStackBasedPalindromeCheckTest {

    @Test
    public void testPalindromeUsingQueueAndStack() {
        String input = "racecar";
        assertTrue(isPalindromeUsingQueueAndStack(input), "racecar should be a palindrome using Queue and Stack");
    }

    @Test
    public void testNonPalindromeUsingQueueAndStack() {
        String input = "hello";
        assertFalse(isPalindromeUsingQueueAndStack(input), "hello should not be a palindrome using Queue and Stack");
    }

    @Test
    public void testSingleCharacterUsingQueueAndStack() {
        String input = "a";
        assertTrue(isPalindromeUsingQueueAndStack(input), "Single character should be a palindrome");
    }

    @Test
    public void testEmptyStringUsingQueueAndStack() {
        String input = "";
        assertTrue(isPalindromeUsingQueueAndStack(input), "Empty string should be considered a palindrome");
    }

    private boolean isPalindromeUsingQueueAndStack(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : cleanedStr.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {
            if (queue.poll() != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
