import java.util.*;

public class StopWordFilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        Set<String> stopWords = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
        );

        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleaned.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (!stopWords.contains(word)) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}