
import java.util.Scanner;

/**
 * ==============================================================
 * MAIN CLASS - UseCase3PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 3: Reverse String Based Palindrome Check
 *
 * Description:
 * This class checks whether a string is a palindrome
 * by reversing the string and comparing it with
 * the original value.
 *
 * At this stage, the application:
 * - Iterates the string in reverse order
 * - Builds a reversed version
 * - Compares original and reversed strings
 * - Displays the validation result
 *
 * This introduces transformation-based validation.
 *
 * @author Developer
 * @version 3.0
 */
public class UseCase3PalindromeCheckerApp {
    /**
     * Application entry point for UC3.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Welcome message
        System.out.println("===========================================");
        System.out.println("   PALINDROME CHECKER - Use Case 3");
        System.out.println("   String Reverse Based Check");
        System.out.println("===========================================");
        
        // Take user input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();
        
        // Build reversed string using loop
        String reversed = "";
        
        // Iterate from the last character to the first
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        
        // Compare original and reversed
        if (input.equals(reversed)) {
            System.out.println("\n✓ Result: \"" + input + "\" is a PALINDROME");
        } else {
            System.out.println("\n✗ Result: \"" + input + "\" is NOT a palindrome");
        }
        
        System.out.println("\nOriginal String: " + input);
        System.out.println("Reversed String: " + reversed);
        
        scanner.close();
    }
}
