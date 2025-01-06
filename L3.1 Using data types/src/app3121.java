public class app3121 {
    public static void main(String[] args) {
        In in = new In();
        Out out = new Out();
        while (!in.isEmpty()) {
            String line = in.readLine();
            if (line.trim().length() > 0) {
                out.println(line);
            }
        }
    }
}
