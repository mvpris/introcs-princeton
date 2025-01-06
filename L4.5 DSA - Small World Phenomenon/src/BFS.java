public class BFS {
    private static void bfs(GraphT G, String s) {
        SET<String> visited = new SET<>();
        Queue<String> queue = new Queue<>();

        queue.enqueue(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            for (String w : G.adjacentTo(v)) {
                if (!visited.contains(w)) {
                    queue.enqueue(w);
                    visited.add(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
