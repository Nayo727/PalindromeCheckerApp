 private static final String TEST_STRING = "A man a plan a canal Panama";

    public static void main(String[] args) {
        System.out.println("===== Performance Comparison =====\n");

        // Test TwoPointerCheck
        long twoPointerTime = TwoPointerCheck(TEST_STRING);
        System.out.println("Two-Pointer Time: " + formatTime(twoPointerTime));

        // Test StackCheck
        long stackTime = StackCheck(TEST_STRING);
        System.out.println("Stack Time: " + formatTime(stackTime));

        // Test RecursiveCheck
        long recursiveTime = RecursiveCheck(TEST_STRING);
        System.out.println("Recursive Time: " + formatTime(recursiveTime));
    }

    private static long TwoPointerCheck(String s) {
        long startTime = System.nanoTime();
        PalindromeChecker.TwoPointerCheck(s);
        return System.nanoTime() - startTime;
    }

    private static long StackCheck(String s) {
        long startTime = System.nanoTime();
        PalindromeChecker.StackCheck(s);
        return System.nanoTime() - startTime;
    }

    private static long RecursiveCheck(String s) {
        long startTime = System.nanoTime();
        PalindromeChecker.RecursiveCheck(s);
        return System.nanoTime() - startTime;
    }

    private static String formatTime(long nanoTime) {
        return nanoTime + " ns";
    }
}
