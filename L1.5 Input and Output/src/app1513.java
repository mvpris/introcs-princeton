public class app1513 {
    public static void main(String[] args) {
        int years = Integer.parseInt(args[0]);
        int principal = Integer.parseInt(args[1]);
        double interestRate = Double.parseDouble(args[2]) / 100;

        double monthlyInterestRate = interestRate / 12;
        StdOut.println(monthlyInterestRate);
        int totalMonths = years * 12;
        double monthlyPayment = principal * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalMonths)) / (Math.pow(1 + monthlyInterestRate, totalMonths) - 1));
        StdOut.println(monthlyPayment);
        double remainingPrincipal = principal;

        StdOut.println("Month\tMonthly Payment\tRemaining Principal\tInterest Paid");
        for (int month = 1; month <= totalMonths; month++) {
            double interestPaid = remainingPrincipal * monthlyInterestRate;
            double principalPaid = monthlyPayment - interestPaid;
            remainingPrincipal -= principalPaid;

            StdOut.printf("%d\t%.2f\t\t%.2f\t\t%.2f\n", month, monthlyPayment, remainingPrincipal, interestPaid);
        }
    }
}
