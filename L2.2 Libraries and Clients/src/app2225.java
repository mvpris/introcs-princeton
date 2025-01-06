public class app2225 {
    public static int binomial(int population, double p) {
        int result = 0;
        for (int i = 0; i < population; i++) {
            if (StdRandom.bernoulli(p)) result++;
        }

        return result;
    }

    private static void simulateElection(int population, double voteForACandidateA, double errorRate) {
        int votesForCandidateA = binomial(population, voteForACandidateA);
        int votesForCandidateB = population - votesForCandidateA;

        int incorrectVotesForA = binomial(votesForCandidateA, errorRate);
        int incorrectVotesForB = binomial(votesForCandidateB, errorRate);

        int totalIncorrectVotes = incorrectVotesForA + incorrectVotesForB;

        int finalVotesForA = votesForCandidateA - incorrectVotesForA;
        int finalVotesForB = votesForCandidateB - incorrectVotesForB;

        System.out.println("Simulating Election Results:");
        System.out.println("Votes for Candidate A: " + finalVotesForA);
        System.out.println("Votes for Candidate B: " + finalVotesForB);
        System.out.println("Total Incorrect Votes: " + totalIncorrectVotes);

        if (finalVotesForA > finalVotesForB) {
            System.out.println("Candidate A wins!");
        } else if (finalVotesForA < finalVotesForB) {
            System.out.println("Candidate B wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        int population = 100000000; // 100 million voters
        double voteForACandidateA = 0.51; // 51% vote for candidate A
        double errorRate = 0.05; // 5% error rate

        simulateElection(population, voteForACandidateA, errorRate);
    }
}
