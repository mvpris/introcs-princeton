public class app212 {
    public static boolean odd(boolean b1, boolean b2, boolean b3) {
        int count = 0;
        if (!b1) count++;
        if (!b2) count++;
        if (!b3) count++;
        return count % 2 != 0;
    }

    public static void main(String[] args) {
        boolean b1 = Boolean.parseBoolean(args[0]);
        boolean b2 = Boolean.parseBoolean(args[1]);
        boolean b3 = Boolean.parseBoolean(args[2]);
        StdOut.println(odd(b1, b2, b3));
    }
}
