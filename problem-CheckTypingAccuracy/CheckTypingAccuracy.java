public class CheckTypingAccuracy {

    static void checkTypingAccuracy(String original, String typed) {
        int totalChars = original.length();
        int matchedChars = 0;
        int firstMismatchPos = -1;
        char originalChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < totalChars; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedChars++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1;
                    originalChar = original.charAt(i);
                    typedChar = typed.charAt(i);
                }
            }
        }

        double accuracy = ((double) matchedChars / totalChars) * 100;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matchedChars, totalChars, accuracy);

        if (firstMismatchPos == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println("First Mismatch at position " + firstMismatchPos +
                    " ('" + originalChar + "' vs '" + typedChar + "')");
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\nTest 2:");
        checkTypingAccuracy("coding", "coding");
    }
}