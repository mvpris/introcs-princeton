public class app3111 {
    public static boolean isWatsonCrickPalindrome(String s) {
        String WC = app3110.complementWatsonCrick(s);
        String reverse = app311.reverse(WC);
        return s.equals(reverse);
    }

    public static void main(String[] args) {
        String s = args[0];
        System.out.println(isWatsonCrickPalindrome(s));
    }
}
