public class WebSurfer {
    private static String targetPage;
    private static double threshold;

    public static void processPage(String url) {
        In in = new In(url);
        String input = in.readAll();
        Sketch sketch = new Sketch(input, 5, 10000);
        Sketch targetSketch = new Sketch(new In(targetPage).readAll(), 5, 10000);

        if (sketch.similarTo(targetSketch) > threshold) {
            StdOut.println(url);
        }

        int from = 0;
        while ((from = input.indexOf("https://", from)) != -1) {
            int to = input.indexOf("\"", from);
            if (to != -1) {
                try {
                    processPage(input.substring(from, to));
                } catch (IllegalArgumentException e) {
                    // Ignore pages that can't be opened.
                }
            }
            from = to;
        }
    }

    public static void main(String[] args) {
        targetPage = args[1];
        threshold = Double.parseDouble(args[2]);
        processPage(args[0]);
//        java WebSurfer https://www.bbc.com/ https://www.nytimes.com/international/ 0.0
    }
}
