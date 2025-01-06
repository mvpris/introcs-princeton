public class PRNG {
    private final long a = 3141592621L;
    private final long b = 2718281829L;
    private long x;

    public PRNG(int seed) {
        x = seed;
    }

    public int randomInt(int m) {
        x = (a * x + b) % m;
        return (int) x;
    }

    public void setSeed(long seed) {
        x = seed;
    }

    public static void main(String[] args) {
        PRNG random = new PRNG(31);
        int n = 10;
        for (int i = 0; i < n; i++) {
            random.setSeed(System.currentTimeMillis() % (i + 1));
            System.out.println(random.randomInt(10));
        }
    }
}
