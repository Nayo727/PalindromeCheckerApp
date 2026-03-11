import java.util.Scanner;

/**
 * ==============================================================
 * MAIN CLASS - UseCase4PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 4: Character Array Based Palindrome Check
 *
 * Description:
 * This class checks whether a string is a palindrome
 * by converting it to a character array and comparing
 * characters from both ends moving towards the center.
 *
 * Key Concepts:
 * - Character Array (char[])
 * - Two-pointer technique
 * - Array indexing
 *
 * @author Developer
 * @version 4.0
 */
public class UseCase4PalindromeCheckerApp {
    /**
     * Application entry point for UC4.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Welcome message
        System.out.println("===========================================");
        System.out.println("   PALINDROME CHECKER - Use Case 4");
        System.out.println("   Character Array Based Check");
        System.out.println("===========================================");
        
        // Take user input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();
        
        // Convert string to character array
        char[] charArray = input.toCharArray();
        
        // Two pointers - start and end
        int left = 0;
        int right = charArray.length - 1;
        boolean isPalindrome = true;
        
        // Compare characters from both ends
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        
        // Display result
        if (isPalindrome) {
            System.out.println("\n✓ Result: \"" + input + "\" is a PALINDROME");
        } else {
            System.out.println("\n✗ Result: \"" + input + "\" is NOT a palindrome");
        }
        
        System.out.println("\nMethod Used: Character Array with Two Pointers");
        System.out.println("Array Length: " + charArray.length);
        
        scanner.close();
    }
}
