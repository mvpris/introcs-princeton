public class app3122 {
    public static boolean isValid(String s, String start, String stop) {
        return s.startsWith(start) && s.endsWith(stop);
    }

    public static void main(String[] args) {
        String s = args[0];
        String start = args[1];
        String stop = args[2];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length() + 1; j++) {
                String temp = s.substring(i, j);
                if (isValid(temp, start, stop)) System.out.println(temp);
            }
        }
    }
}
