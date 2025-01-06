public class app4124 {
    public static void main(String[] args) {
        int n = Integer.MAX_VALUE / (int) Math.pow(2, 15);
        int[][] a = new int[n][n];
        StdOut.println("done");
        
//        java -Xmx17000m app4124
//        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//        at app4124.main(app4124.java:4)

//        java -Xmx17500m app4124
//                done
    }
}
