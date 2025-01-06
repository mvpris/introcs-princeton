public class app3115 {
    public static boolean isCircularShift(String s, String t) {
        return (s.length() == t.length()) && ((s + s).indexOf(t) != -1);
    }

    public static void main(String[] args) {
        String s = args[0];
        String t = args[1];
        System.out.println(isCircularShift(s, t));
    }
}
