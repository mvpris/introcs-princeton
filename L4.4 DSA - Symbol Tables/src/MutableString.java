import java.util.ArrayList;

public class MutableString {
    private final ArrayList<Character> string;

    public MutableString() {
        string = new ArrayList<>();
    }

    public char get(int i) {
        return string.get(i);
    }

    public void insert(int i, char c) {
        string.add(i, c);
    }

    public void delete(int i) {
        string.remove(i);
    }

    public int length() {
        return string.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Character c : string) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        MutableString string = new MutableString();
        string.insert(0, 't');
        string.insert(1, 'e');
        string.insert(2, 'x');
        string.insert(3, 'x');
        string.insert(4, 't');
        string.delete(2);
        StdOut.println("string.length() = " + string.length());
        StdOut.println("string.get(2) = " + string.get(2));
        StdOut.println("string = " + string);
    }
}
