public class InvertConcordance {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ST<String, Queue<Integer>> st = new ST<>();

        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] firstSplit = line.split(":");
            String[] secondSplit = firstSplit[1].split(" ");
            Queue<Integer> queue = new Queue<>();
            for (int i = 1; i < secondSplit.length; i++) {
                queue.enqueue(Integer.parseInt(secondSplit[i]));
            }
            st.put(firstSplit[0], queue);
        }

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (String key : st.keys()) {
                for (Integer val : st.get(key)) {
                    if (val.equals(i)) {
                        StdOut.print(key + " ");
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
        }
        StdOut.println();
    }
}
