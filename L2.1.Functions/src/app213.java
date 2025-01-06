public class app213 {
    public static boolean majority(boolean b1, boolean b2, boolean b3) {
        int count = (b1 ? 1 : 0) + (b2 ? 1 : 0) + (b3 ? 1 : 0);
        return count >= 2;
    }

    public static void main(String[] args) {
        boolean b1 = Boolean.parseBoolean(args[0]);
        boolean b2 = Boolean.parseBoolean(args[1]);
        boolean b3 = Boolean.parseBoolean(args[2]);
        StdOut.println(majority(b1, b2, b3));
    }
}
