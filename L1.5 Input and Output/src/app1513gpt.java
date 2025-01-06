public class app1513gpt {
    public static void main(String[] args) {
        int years = Integer.parseInt(args[0]);
        double principal = Double.parseDouble(args[1]);
        double interestRate = Double.parseDouble(args[2]) / 100.0;

        double monthlyInterestRate = interestRate / 12;
        int totalMonths = years * 12;

        double monthlyPayment = (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalMonths));

        System.out.println("Month\tMonthly Payment\tRemaining Principal\tInterest Paid");

        double remainingPrincipal = principal;
        for (int month = 1; month <= totalMonths; month++) {
            double interestPaid = remainingPrincipal * monthlyInterestRate;
            double principalPaid = monthlyPayment - interestPaid;
            remainingPrincipal -= principalPaid;

            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f%n", month, monthlyPayment, remainingPrincipal, interestPaid);
        }
    }
}
