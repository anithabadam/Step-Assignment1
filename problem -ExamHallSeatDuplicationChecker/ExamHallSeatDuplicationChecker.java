public class ExamHallSeatDuplicationChecker {

    public ExamHallSeatDuplicationChecker() {
    }

    static void checkDuplicateSeats(int[] seats) {

        boolean duplicateFound = false;

        for (int i = 0; i < seats.length; i++) {

            boolean alreadyChecked = false;

            // Check whether this seat number was already checked
            for (int j = 0; j < i; j++) {
                if (seats[i] == seats[j]) {
                    alreadyChecked = true;
                    break;
                }
            }

            if (!alreadyChecked) {

                for (int j = i + 1; j < seats.length; j++) {

                    if (seats[i] == seats[j]) {
                        System.out.println(
                            "Duplicate Seat Number Found: " + seats[i]
                        );

                        duplicateFound = true;
                        break;
                    }
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seat Numbers Found");
        }
    }

    public static void main(String[] args) {

        int[] seats = {101, 102, 103, 102, 105, 106, 103};

        checkDuplicateSeats(seats);
    }
}