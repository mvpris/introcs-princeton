public class GaussianRandomNumbers1227 {
    public static void main(String[] args) {
        double u = Math.random();
        double v = Math.random();
        double r = Math.sin(2 * Math.PI * v) * Math.pow((-2 * Math.log(u)), 0.5);
        System.out.println("Random number from Gaussian distribution = " + r);
    }
}
