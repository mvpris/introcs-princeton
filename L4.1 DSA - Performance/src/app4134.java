public class app4134 {
    // a)
    public static void findDuplicateAndMissing(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long sumOfSquares = 0;
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSumOfSquares = n * (n + 1) * (2L * n + 1) / 6;
        for (int num : nums) {
            sum += num;
            sumOfSquares += (long) num * num;
        }
        long diff = expectedSum - sum;  // missing - duplicate
        long sumDiff = expectedSumOfSquares - sumOfSquares; // missing^2 - duplicate^2

        long sumValues = sumDiff / diff;    // missing + duplicate

        int missing = (int) (diff + sumValues) / 2;
        int duplicate = (int) (sumValues - missing);
        StdOut.println("Duplicate a): " + duplicate);
        StdOut.println("Missing   a): " + missing);
    }

    // b)
    public static int findDuplicateB(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int expectedSum = (n - 1) * n / 2;
        for (int num : nums) {
            sum += num;
        }
        return sum - expectedSum;
    }

    // c)
    public static int findDuplicateC(int[] nums) {
        // Floyd’s Tortoise and Hare (Cycle Detection)
        int tortoise = nums[0];
        int hare = nums[0];

        // Phase 1: Finding the intersection point
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Phase 2: Finding the entrance to the cycle
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }


    public static void main(String[] args) {
        int[] numsA = {1, 2, 3, 4, 4};
        findDuplicateAndMissing(numsA);

        int[] numsB = {1, 2, 3, 4, 4};
        int duplicateB = findDuplicateB(numsB);
        StdOut.println("Duplicate b): " + duplicateB);

        int[] numsC = {1, 3, 4, 2, 2};
        int duplicateC = findDuplicateC(numsC);
        StdOut.println("Duplicate c): " + duplicateC);
    }
}
