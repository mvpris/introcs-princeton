public class app3117 {
    public static String web(String s) {
        String t = s.substring(s.lastIndexOf('.') + 1) +
                s.substring(s.indexOf('.'), s.lastIndexOf('.') + 1) +
                s.substring(0, s.indexOf('.'));

        return t;
    }

    public static void main(String[] args) {
        String s = args[0];
        System.out.println(web(s));
    }
}
