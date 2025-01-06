public class DFS {
    private static void dfs(GraphT G, String s) {
        SET<String> visited = new SET<>();
        Stack<String> stack = new Stack<>();

        stack.push(s);
        visited.add(s);

        while (!stack.isEmpty()) {
            String v = stack.pop();
            for (String w : G.adjacentTo(v)) {
                if (!visited.contains(w)) {
                    stack.push(w);
                    visited.add(w);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
