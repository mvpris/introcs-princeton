public class app4220client {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 2};  // correct answer should be 2, as sorted a={1,2,2,3,4} and median is a[2]=2;
        int[] b = {1, 1, 6, 4};     // correct answer should be 2.5, as sorted a={1,1,4,6} and median is (a[1]+a[2])/2=2.5;
        StdOut.println("median(a)=" + StdStats.median(a));
        StdOut.println("median(b)=" + StdStats.median(b));
//        .../src> java app4220client
//        median(a)=2.0
//        median(b)=2.5
    }
}
