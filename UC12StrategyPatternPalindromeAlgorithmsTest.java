package com.palindromechecker;

import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import static org.junit.jupiter.api.Assertions.*;

public class UC12StrategyPatternPalindromeAlgorithmsTest {

    // Strategy Interface
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // Stack-based Strategy Implementation
    static class StackStrategy implements PalindromeStrategy {
        @Override
        public boolean check(String input) {
            if (input == null || input.isEmpty()) return true;
            String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            
            Stack<Character> stack = new Stack<>();
            for (char c : cleaned.toCharArray()) {
                stack.push(c);
            }
            
            for (char c : cleaned.toCharArray()) {
                if (c != stack.pop()) return false;
            }
            return true;
        }
    }

    // Deque-based Strategy Implementation
    static class DequeStrategy implements PalindromeStrategy {
        @Override
        public boolean check(String input) {
            if (input == null || input.isEmpty()) return true;
            String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : cleaned.toCharArray()) {
                deque.addLast(c);
            }
            
            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) return false;
            }
            return true;
        }
    }

    // Context class that uses the strategy
    static class PalindromeChecker {
        private PalindromeStrategy strategy;
        
        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }
        
        public boolean checkPalindrome(String input) {
            if (strategy == null) {
                throw new IllegalStateException("Strategy not set");
            }
            return strategy.check(input);
        }
    }

    @Test
    public void testPalindromeWithStackStrategy() {
        PalindromeChecker checker = new PalindromeChecker();
        checker.setStrategy(new StackStrategy());
        
        assertTrue(checker.checkPalindrome("racecar"), "racecar should be palindrome with Stack strategy");
        assertFalse(checker.checkPalindrome("hello"), "hello should not be palindrome with Stack strategy");
    }

    @Test
    public void testPalindromeWithDequeStrategy() {
        PalindromeChecker checker = new PalindromeChecker();
        checker.setStrategy(new DequeStrategy());
        
        assertTrue(checker.checkPalindrome("racecar"), "racecar should be palindrome with Deque strategy");
        assertFalse(checker.checkPalindrome("hello"), "hello should not be palindrome with Deque strategy");
    }

    @Test
    public void testStrategySwitch() {
        PalindromeChecker checker = new PalindromeChecker();
        
        // Use Stack strategy
        checker.setStrategy(new StackStrategy());
        assertTrue(checker.checkPalindrome("level"));
        
        // Switch to Deque strategy
        checker.setStrategy(new DequeStrategy());
        assertTrue(checker.checkPalindrome("noon"));
    }
}
