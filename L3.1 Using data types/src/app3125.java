public class app3125 {
    public static void main(String[] args) {
        String name = args[0];
        int n = Integer.parseInt(args[1]);
        String delimiter = args[2];

        Out out = new Out(name + ".csv");
        In[] ins = new In[n];
        for (int i = 0; i < n; i++) {
            ins[i] = new In(name + i + ".txt");
        }

        while (!ins[0].isEmpty()) {
            for (int i = 0; i < n; i++) {
                String line = ins[i].readLine();
                out.print(line);
                if (i != n - 1) {
                    out.print(delimiter);
                }
            }
            out.println();
        }
    }
}
