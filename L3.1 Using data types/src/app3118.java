public class app3118 {
    public static String mystery(String s) {
        int n = s.length();
        if (n <= 1) return s;
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2, n);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        String s = args[0];
        System.out.println(mystery(s));
    }
}
