public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No data to analyze.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);

            if (c == currentColor) {
                // Streak continues
                currentLength++;
            } else {
                // Streak broken, start a new one
                currentColor = c;
                currentLength = 1;
            }

            // Update running maximum
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");   // Expected: 'G' repeated 3 times
        findLongestStreak("RRRRYYGG");   // Expected: 'R' repeated 4 times
    }
}