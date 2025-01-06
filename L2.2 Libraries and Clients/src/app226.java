public class app226 {
    //     Method to linearly scale values in the array between ymin and ymax
    public static void linearScale(double ymin, double ymax, double[] a) {

        // Check if ymin is strictly less than ymax
        if (!(ymin < ymax)) throw new IllegalArgumentException("ymin is not less than ymax");
        int n = a.length;

        // Find the minimum and maximum values in the array
        double min = StdStats.min(a);
        double max = StdStats.max(a);

        // Calculate the scaling factor
        double scaleFactor = (ymax - ymin) / (max - min);

        // Scale each value in the array
        for (int i = 0; i < n; i++) {
            a[i] = ymin + scaleFactor * (a[i] - min);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double ymin = Double.parseDouble(args[1]);
        double ymax = Double.parseDouble(args[2]);

        // Example usage
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

        // Linearly scale the values
        linearScale(ymin, ymax, a);

        // Print the scaled values
        StdArrayIO.print(a);

    }
}
