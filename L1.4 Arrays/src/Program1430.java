public class Program1430 {
    public static void main(String[] args) {
        int numSimulations = 1000000; // Number of simulations to run
        int n = Integer.parseInt(args[0]); // Number of guests, including Bob
        int alice = 0; // Index of Alice

        int totalPeopleHeard = 0;
        int allHeardCount = 0;

        for (int i = 0; i < numSimulations; i++) {
            boolean[] heardRumor = new boolean[n];
            heardRumor[alice] = true; // Alice already heard the rumor
            int peopleHeard = 1; // Alice
            int currPerson = 1; // Start with Bob

            while (peopleHeard < n - 1) { // Continue until everyone except Alice heard
                int nextPerson;
                do {
                    nextPerson = (int) (Math.random() * n);
                } while (nextPerson == currPerson || heardRumor[nextPerson]);

                heardRumor[nextPerson] = true;
                peopleHeard++;
                currPerson = nextPerson;
            }

            if (peopleHeard == n - 1) {
                allHeardCount++;
            }

            totalPeopleHeard += peopleHeard;
        }

        double probabilityAllHeard = (double) allHeardCount / numSimulations;
        double avgPeopleHeard = (double) totalPeopleHeard / numSimulations;

        System.out.println("Estimated Probability that everyone heard: " + probabilityAllHeard);
        System.out.println("Estimated Average number of people heard: " + avgPeopleHeard);
    }
}
