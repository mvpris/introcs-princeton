public class app2216gpt {

    public static void main(String[] args) {
        int numSimulations = 100000000; // You can adjust the number of simulations

        int wins = 0;
        int losses = 0;

        for (int i = 0; i < numSimulations; i++) {
            if (playCraps()) {
                wins++;
            } else {
                losses++;
            }
        }

        double winProbability = (double) wins / numSimulations;
        double lossProbability = (double) losses / numSimulations;

        System.out.println("Probability of winning: " + winProbability);
        System.out.println("Probability of losing: " + lossProbability);
    }

    private static boolean playCraps() {
        int initialRoll = rollDice();

        if (initialRoll == 7 || initialRoll == 11) {
            return true; // Win
        } else if (initialRoll == 2 || initialRoll == 3 || initialRoll == 12) {
            return false; // Lose
        } else {
            // Continue rolling until a 7 or the initial roll is rolled again
            while (true) {
                int nextRoll = rollDice();
                if (nextRoll == initialRoll) {
                    return true; // Win
                } else if (nextRoll == 7) {
                    return false; // Lose
                }
            }
        }
    }

    private static int rollDice() {
        int die1 = StdRandom.uniformInt(1, 7);
        int die2 = StdRandom.uniformInt(1, 7);
        return die1 + die2;
    }
}
