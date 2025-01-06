public class app158 {
    public static void main(String[] args) {
        double product = 1;
        double harmonicSum = 0;
        int count = 0;
        while (!StdIn.isEmpty()) {
            double num = StdIn.readDouble();
            if (num < 0) {
                StdOut.println("Number is negative, pleas enter positive number");
                continue;
            }
            if (num == 0) {
                StdOut.println("Zero is not allowed, please enter positive number");
                continue;
            }
            product *= num;
            harmonicSum += 1 / num;
            count++;
        }
        double gM = Math.pow(product, 1.0 / count);
        double hM = count / harmonicSum;
        StdOut.println("Geometric mean= " + gM);
        StdOut.println("Harmonic mean= " + hM);
    }
}
