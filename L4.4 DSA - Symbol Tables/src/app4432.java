public class app4432 {
    public static void main(String[] args) {
        String[] letters = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"};
        double[] grades = {4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.00, 0.00};
        ST<String, Double> table = new ST<>();

        for (int i = 0; i < letters.length; i++) {
            table.put(letters[i], grades[i]);
        }

        double sum = 0.0;
        int count = 0;
        while (!StdIn.isEmpty()) {
            String grade = StdIn.readString();
            sum += table.get(grade);
            count++;
        }
        double avg = sum / count;
        StdOut.println("GPA = " + avg);
    }
}
