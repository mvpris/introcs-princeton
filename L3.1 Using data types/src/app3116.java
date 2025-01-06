public class app3116 {
    public static String topLevelDomain(String s) {
        return s.substring(s.lastIndexOf('.') + 1);
    }

    public static void main(String[] args) {
        String s = args[0];
        System.out.println(topLevelDomain(s));
    }
}
