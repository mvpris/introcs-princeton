public class app3124 {
    public static void main(String[] args) {
        String name = args[0];
        int pauseTime = Integer.parseInt(args[1]);
        String delimiter = ",";
        Draw draw1 = new Draw();
        Draw draw2 = new Draw();

        In in = new In(name);
        // Skip the first line
        if (in.hasNextLine()) {
            in.readLine();
        }

        // First pass: count the number of lines
        int m = 0;
        while (in.hasNextLine()) {
            in.readLine();
            m++;
        }

        // Create arrays of the right size
        double[] prices = new double[m];
        double[] volume = new double[m];

        // Reset the file reader
        in = new In(name);
        // Skip the first line again
        if (in.hasNextLine()) {
            in.readLine();
        }

        // Second pass: read the data
        int j = 0;
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] fields = line.split(delimiter);
            prices[j] = Double.parseDouble(fields[4]);
            volume[j] = Double.parseDouble(fields[5]);
            j++;
        }

        // Plot the data
        draw1.enableDoubleBuffering();
        draw2.enableDoubleBuffering();
        draw1.setXscale(0, m);
        draw1.setYscale(0, StdStats.max(prices) * 1.25);
        draw2.setXscale(0, m);
        draw2.setYscale(0, StdStats.max(volume) * 1.25);
        draw1.text(m * 0.1, StdStats.max(prices) * 1.15, "Prices");
        draw2.text(m * 0.1, StdStats.max(volume) * 1.15, "Volume");

        for (int i = m - 1; i > 0; i--) {
            draw1.filledRectangle(m - 0.5 - i, prices[i] / 2, 0.375, prices[i] / 2);
            draw1.pause(pauseTime);
            draw1.show();

            draw2.filledRectangle(m - 0.5 - i, volume[i] / 2, 0.375, volume[i] / 2);
            draw2.pause(pauseTime);
            draw2.show();
        }
    }
}
