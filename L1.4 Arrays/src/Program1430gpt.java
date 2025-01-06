import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Program1430gpt {
    public static void main(String[] args) {
        int numSimulations = 1000000; // Number of simulations to run
        int n = Integer.parseInt(args[0]); // Number of guests, including Bob
        int alice = 0; // Index of Alice

        int totalPeopleHeard = 0;
        int allHeardCount = 0;

        for (int i = 0; i < numSimulations; i++) {
            Set<Integer> heardRumor = new HashSet<>();
            heardRumor.add(alice); // Alice already heard the rumor
            int peopleHeard = 1; // Alice
            int currPerson = 1; // Start with Bob

            while (heardRumor.size() < n - 1) { // Continue until everyone except Alice heard
                int nextPerson = getRandomPerson(n, currPerson, heardRumor);
                if (heardRumor.contains(nextPerson)) { // Person heard the rumor before
                    break;
                }
                heardRumor.add(nextPerson);
                peopleHeard++;
                currPerson = nextPerson;
            }

            if (heardRumor.size() == n - 1) {
                allHeardCount++;
            }

            totalPeopleHeard += peopleHeard;
        }

        double probabilityAllHeard = (double) allHeardCount / numSimulations;
        double avgPeopleHeard = (double) totalPeopleHeard / numSimulations;

        System.out.println("Estimated Probability that everyone heard: " + probabilityAllHeard);
        System.out.println("Estimated Average number of people heard: " + avgPeopleHeard);
    }

    // Returns a random person to whom the rumor will be propagated
    private static int getRandomPerson(int n, int currPerson, Set<Integer> heardRumor) {
        Random rand = new Random();
        int nextPerson;
        do {
            nextPerson = rand.nextInt(n);
        } while (nextPerson == currPerson || heardRumor.contains(nextPerson));
        return nextPerson;
    }
}
