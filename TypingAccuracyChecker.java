import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original text: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed text: ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);
        scanner.close();
    }

    public static void checkTypingAccuracy(String original, String typed) {
        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ', typedChar = ' ';

        int minLen = Math.min(original.length(), typed.length());

        for (int i = 0; i < minLen; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based position[cite: 1]
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        // If length differs and no earlier mismatch was caught
        if (firstMismatchPos == -1 && original.length() != typed.length()) {
            firstMismatchPos = minLen + 1;
            origChar = original.length() > minLen ? original.charAt(minLen) : ' ';
            typedChar = typed.length() > minLen ? typed.charAt(minLen) : ' ';
        }

        double accuracy = ((double) matched / total) * 100; // Calculate accuracy percentage[cite: 1]

        if (firstMismatchPos != -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n", 
                              matched, total, accuracy, firstMismatchPos, origChar, typedChar); //[cite: 1]
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n", 
                              matched, total, accuracy); //[cite: 1]
        }
    }
}