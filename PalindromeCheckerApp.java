import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version: 1.0");
        System.out.println("Systsem initialized succesfully");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
        // Take user input
        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();

        // Normalize the string: remove spaces and convert to lowercase for case-insensitive comparison
        String s = input.replaceAll("\\s+", "").toLowerCase();

        // Two pointers initialization
        int left = 0;
        int right = s.length() - 1;

        boolean isPalindrome = true;

        // Check palindrome using two pointers
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        // Output result
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }

        scanner.close();
    }
}
