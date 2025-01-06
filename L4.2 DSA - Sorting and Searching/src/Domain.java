public class Domain implements Comparable<Domain> {
    private final StringBuilder sb = new StringBuilder();

    public Domain(String name) {
        String[] split = name.split("\\.");
        int n = split.length;
        for (int i = 0; i < n; i++) {
            sb.append(split[n - 1 - i]);
            if (i != n - 1) sb.append(".");
        }
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    @Override
    public int compareTo(Domain that) {
        return sb.compareTo(that.sb);
    }

    public static void main(String[] args) {
        String s = "cs.princeton.edu";
        Domain domain = new Domain(s);
        StdOut.println(domain.toString());
    }
}
