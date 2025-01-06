public class Program1412 {
    public static void main(String[] args) {

//        read in frequency of occurrence of n values
        int n = args.length;
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            freq[i] = Integer.parseInt(args[0]);
        }

//        compute total count of all frequencies
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += freq[i];
        }

//        generate random integer with probability proportional to frequency
        int r = (int) (total * Math.random());
        int sum = 0;
        int event = -1;
        for (int i = 0; i < n && sum <= r; i++) {
            sum += freq[i];
            event = i;
        }
        
        System.out.println(event);
    }
}
