public class app2216 {
    public static void main(String[] args) {
        double prob1 = Double.parseDouble(args[0]);

        if (prob1 > 2.0 / 6) {
            throw new IllegalArgumentException("Probability of the loaded die landing on 1 must be less than 1/6.");
        }

        double[] diceProbabilities = {prob1, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6, (2.0 / 6) - prob1};

        int n = 100000000;
        int wins1 = 0;
        int losses1 = 0;
        int wins2 = 0;
        int losses2 = 0;

        for (int i = 0; i < n; i++) {
            if (playCraps()) {
                wins1++;
            } else {
                losses1++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (playCrapsLoaded(diceProbabilities)) {
                wins2++;
            } else {
                losses2++;
            }
        }

        double winProbability1 = (double) wins1 / n;
        double lossProbability1 = (double) losses1 / n;
        double winProbability2 = (double) wins2 / n;
        double lossProbability2 = (double) losses2 / n;

        StdOut.println("Probability of winning: " + winProbability1);
        StdOut.println("Probability of losing: " + lossProbability1);
        StdOut.println("Probability of winning with a loaded dice: " + winProbability2);
        StdOut.println("Probability of losing with a loaded dice: " + lossProbability2);
    }

    public static boolean playCraps() {
        int initialRoll = rollDice();

        if (initialRoll == 7 || initialRoll == 11) {
            return true;
        } else if (initialRoll == 2 || initialRoll == 3 || initialRoll == 12) {
            return false;
        } else {
            while (true) {
                int nextRoll = rollDice();
                if (nextRoll == initialRoll) {
                    return true;
                } else if (nextRoll == 7) {
                    return false;
                }
            }
        }
    }

    public static boolean playCrapsLoaded(double[] a) {
        int initialRoll = rollDiceLoaded(a);

        if (initialRoll == 7 || initialRoll == 11) {
            return true;
        } else if (initialRoll == 2 || initialRoll == 3 || initialRoll == 12) {
            return false;
        } else {
            while (true) {
                int nextRoll = rollDiceLoaded(a);
                if (nextRoll == initialRoll) {
                    return true;
                } else if (nextRoll == 7) {
                    return false;
                }
            }
        }
    }

    public static int rollDice() {
        int die1 = StdRandom.uniformInt(1, 7);
        int die2 = StdRandom.uniformInt(1, 7);

        return die1 + die2;
    }

    public static int rollDiceLoaded(double[] a) {
        int die1 = StdRandom.discrete(a);
        int die2 = StdRandom.discrete(a);

        return die1 + die2;
    }

}
