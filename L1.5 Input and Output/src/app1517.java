public class app1517 {
    public static void main(String[] args) {
        double aM = 0;
        double aP = 0;
        int zcpc = 0;
        double lowerLimit = -1.0;
        double upperLimit = 1.0;
        boolean zcpb = false;
        int count = 0;
        while (!StdIn.isEmpty()) {
            double num = StdIn.readDouble();
            if (num < lowerLimit || num > upperLimit) {
                StdOut.println("Invalid input. Please enter a real number between -1 and 1.");
            } else {
                aM += Math.abs(num);
                aP += Math.pow(num, 2);
                if (num > 0 && !zcpb) {
                    zcpb = true;
                    zcpc++;
                }
                if (num < 0 && zcpb) {
                    zcpb = false;
                    zcpc++;
                }
                count++;
            }
        }
        double aMa = aM / count;
        double aPa = aP / count;
        StdOut.printf("Average magnitude=%.2f, Average power=%.2f, No of zero crossing points=%d\n", aMa, aPa, zcpc);
    }
}
