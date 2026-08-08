public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        int highestValue = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1;

        // Sum Section A and track its max
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestValue) {
                highestValue = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        // Sum Section B and track its max
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestValue) {
                highestValue = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA +
                " | Section B Total: " + totalB +
                " | Status: " + status +
                " | Highest Quantity: " + highestValue +
                " (" + highestSection + ", Item " + (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
        // Expected: Section A Total: 65 | Section B Total: 65 | Status: Balanced | Highest Quantity: 30 (Section A, Item 3)
    }
}