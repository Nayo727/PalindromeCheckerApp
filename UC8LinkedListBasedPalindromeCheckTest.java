package com.palindromechecker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC8LinkedListBasedPalindromeCheckTest {

    static class ListNode {
        char val;
        ListNode next;
        
        ListNode(char val) {
            this.val = val;
            this.next = null;
        }
    }

    @Test
    public void testPalindromeUsingLinkedList() {
        String input = "racecar";
        assertTrue(isPalindromeUsingLinkedList(input), "racecar should be a palindrome using Linked List");
    }

    @Test
    public void testNonPalindromeUsingLinkedList() {
        String input = "hello";
        assertFalse(isPalindromeUsingLinkedList(input), "hello should not be a palindrome using Linked List");
    }

    @Test
    public void testSingleCharacterUsingLinkedList() {
        String input = "a";
        assertTrue(isPalindromeUsingLinkedList(input), "Single character should be a palindrome");
    }

    @Test
    public void testEmptyStringUsingLinkedList() {
        String input = "";
        assertTrue(isPalindromeUsingLinkedList(input), "Empty string should be considered a palindrome");
    }

    @Test
    public void testEvenLengthPalindrome() {
        String input = "abba";
        assertTrue(isPalindromeUsingLinkedList(input), "abba should be a palindrome");
    }

    private boolean isPalindromeUsingLinkedList(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        if (cleanedStr.isEmpty()) {
            return true;
        }

        // Convert string to linked list
        ListNode head = new ListNode(cleanedStr.charAt(0));
        ListNode current = head;
        
        for (int i = 1; i < cleanedStr.length(); i++) {
            current.next = new ListNode(cleanedStr.charAt(i));
            current = current.next;
        }

        // Find middle using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode secondHalf = reverseList(slow);

        // Compare first half with reversed second half
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}
