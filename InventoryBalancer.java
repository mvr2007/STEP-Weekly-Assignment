import java.util.Scanner;

public class InventoryBalancer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items per section: ");
        int n = scanner.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        System.out.println("Enter quantities for Section A:");
        for (int i = 0; i < n; i++) {
            sectionA[i] = scanner.nextInt();
        }

        System.out.println("Enter quantities for Section B:");
        for (int i = 0; i < n; i++) {
            sectionB[i] = scanner.nextInt();
        }

        analyzeInventory(sectionA, sectionB);
        scanner.close();
    }

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        int highestQty = Integer.MIN_VALUE;
        String highestSection = "";
        int highestItemIndex = -1;

        // Calculate total for Section A and find max
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestSection = "Section A";
                highestItemIndex = i + 1; // 1-based index
            }
        }

        // Calculate total for Section B and find max
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestSection = "Section B";
                highestItemIndex = i + 1; // 1-based index
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA + 
                           " | Section B Total: " + totalB + 
                           " | Status: " + status + 
                           " | Highest Quantity: " + highestQty + 
                           " (" + highestSection + ", Item " + highestItemIndex + ")");
    }
}