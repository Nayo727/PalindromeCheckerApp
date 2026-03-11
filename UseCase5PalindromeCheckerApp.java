
import java.util.Scanner;
import java.util.Stack;

/**
 * ==============================================================
 * MAIN CLASS - UseCase5PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 5: Stack-Based Palindrome Check
 *
 * Description:
 * This class checks whether a string is a palindrome
 * by using a Stack data structure. Characters are pushed
 * onto the stack and then popped to compare with original.
 *
 * Key Concepts:
 * - Stack (LIFO - Last In First Out)
 * - push() and pop() operations
 *
 * @author Developer
 * @version 5.0
 */
public class UseCase5PalindromeCheckerApp {
    /**
     * Application entry point for UC5.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Welcome message
        System.out.println("===========================================");
        System.out.println("   PALINDROME CHECKER - Use Case 5");
        System.out.println("   Stack-Based Check");
        System.out.println("===========================================");
        
        // Take user input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();
        
        // Create a stack and push all characters
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        
        // Build reversed string by popping from stack
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }
        
        // Compare original and reversed
        if (input.equals(reversed)) {
            System.out.println("\n✓ Result: \"" + input + "\" is a PALINDROME");
        } else {
            System.out.println("\n✗ Result: \"" + input + "\" is NOT a palindrome");
        }
        
        System.out.println("\nMethod Used: Stack (LIFO)");
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed);
        
        scanner.close();
    }
}
