public class Program1312 {
    public static void main(String[] args) {
        for (int n = 16; n <= 2048; n *= 2) {
            double logn = Math.log10(n);
            double nlogn = n * Math.log(n);
            double n2 = Math.pow(n, 2);
            double n3 = Math.pow(n, 3);
            double doublen = Math.pow(2, n);
            System.out.println(logn + "\t" + nlogn + "\t" + n + "\t" + n2 + "\t" + n3 + "\t" + doublen);
        }
    }
}
