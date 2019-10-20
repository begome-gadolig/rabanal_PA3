public class SavingsAccount {
    public static double annualInterestRate;

    public void modifyInterestRate(int newInterestRate) {
        annualInterestRate = newInterestRate;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = savingsBalance * annualInterestRate / 12;
        savingsBalance += monthlyInterest;
    }

    private double savingsBalance;
}
