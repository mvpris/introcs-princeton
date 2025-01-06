public class app311 {
    public static String reverse(String s) {
        int n = s.length();
        String result = "";
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(n - 1 - i);
            result += temp;
        }
        return result;
    }

    public static String reverse2(String s) {
        int n = s.length();
        String result = "";
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            result = temp + result;
        }
        return result;
    }

    public static String reverseSB(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(n - 1 - i);
            result.append(temp);
        }
        return result.toString();
    }

    public static String reverseSBreverse(String s) {
        StringBuilder result = new StringBuilder();
        result.append(s);
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        String s = args[0];
        System.out.println(reverse(s));
        System.out.println(reverse2(s));
        System.out.println(reverseSB(s));
        System.out.println(reverseSBreverse(s));
    }
}
