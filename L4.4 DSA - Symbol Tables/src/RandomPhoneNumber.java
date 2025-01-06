import java.util.TreeSet;

public class RandomPhoneNumber {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        TreeSet<String> phoneBook = new TreeSet<>();

        StdIn.readLine();
        String[] lines = StdIn.readAllLines();

        int[] codes = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] tokens = lines[i].split(",");
            codes[i] = Integer.parseInt(tokens[0]);
        }

        int duplicates = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int areaCode = codes[StdRandom.uniformInt(lines.length)];
            int n1 = StdRandom.uniformInt(100, 1000);
            int n2 = StdRandom.uniformInt(1000, 10000);
            String number = (sb.append("(").append(areaCode).append(") ").append(n1).append("-").append(n2)).toString();
            if (phoneBook.contains(number)) {
                n++;
                duplicates++;
            }
            phoneBook.add(number);
        }

        for (String number : phoneBook) StdOut.println(number);
        StdOut.println("Total phone numbers generated is = " + phoneBook.size());
        StdOut.println("Number of duplicate generated phone numbers skipped = " + duplicates);
        // input: java RandomPhoneNumber 100000 < phone-na.csv
    }
}
