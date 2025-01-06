import java.awt.*;

public class PictureGraph {
    private final int width;
    private final int height;
    private final Picture picture;
    private final GraphT graph;

    public PictureGraph(Picture picture) {
        this.picture = picture;
        this.width = picture.width();
        this.height = picture.height();
        this.graph = generateGridGraph();
    }

    private GraphT generateGridGraph() {
        GraphT graph = new GraphT();
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                String v = vertexKey(col, row);
                if (col < width - 1) graph.addEdge(v, vertexKey(col + 1, row));     // Right neighbour
                if (row < height - 1) graph.addEdge(v, vertexKey(col, row + 1));    // Bottom neighbour
//                if (col > 0) graph.addEdge(v, vertexKey(col - 1, row));             // Left neighbour
//                if (row > 0) graph.addEdge(v, vertexKey(col, row - 1));             // Top neighbour
// Left and Top neighbour not needed to be added manually as addEdge() already connects both from the right and bottom neighbours
            }
        }
        return graph;
    }

    private String vertexKey(int col, int row) {
        return col + "," + row;
    }

    public void floodFill(int col, int row, Color newColor) {
        if (!isValid(col, row)) return;

        Color targetColor = picture.get(col, row);
        if (targetColor.equals(newColor)) return;

        // BFS to traverse and color all connected pixels of the same color
        SET<String> visited = new SET<>();
        Queue<String> queue = new Queue<>();
        String startVertex = vertexKey(col, row);
        queue.enqueue(startVertex);

        while (!queue.isEmpty()) {
            String vertex = queue.dequeue();
            String[] coords = vertex.split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);

            if (!isValid(x, y) || visited.contains(vertex) || !picture.get(x, y).equals(targetColor)) continue;

            picture.set(x, y, newColor);
            visited.add(vertex);

            for (String neighbour : graph.adjacentTo(vertex)) {
                if (!visited.contains(neighbour)) queue.enqueue(neighbour);
            }
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void save(String filename) {
        picture.save(filename);
    }

    public static void main(String[] args) {
        String filename = args[0];
        int col = Integer.parseInt(args[1]);
        int row = Integer.parseInt(args[2]);
        Color newColor = Color.decode(args[3]);

        Picture picture = new Picture(filename);
        PictureGraph pg = new PictureGraph(picture);

        pg.floodFill(col, row, newColor);
        pg.save("flood_filled_" + filename);

        StdOut.println("Flood fill complete. Saved as flood_filled_" + filename);
        // input: java PictureGraph image.png 10 20 "#FF00FF"
        // this input changes the left part of the image which is an orange color to a pink color
    }
}
