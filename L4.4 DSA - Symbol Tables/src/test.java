import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i + "..");
        }
        StdOut.println(list.toString());
    }
}
