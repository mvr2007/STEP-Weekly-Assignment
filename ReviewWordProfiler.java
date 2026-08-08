import java.util.Scanner;

public class ReviewWordProfiler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter review text: ");
        String review = scanner.nextLine();

        classifyWordLengths(review);
        scanner.close();
    }

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split text by whitespace
        String[] words = review.trim().split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            // Count letter characters only
            int length = word.replaceAll("[^a-zA-Z]", "").length();
            if (length == 0) {
                length = word.length();
            }

            // Categorize by length
            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }
}