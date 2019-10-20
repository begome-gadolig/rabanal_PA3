public class SavingsAccount {
    private static double annualInterestRate;

    public SavingsAccount(double initialSavingsBalance) {
        savingsBalance = initialSavingsBalance;
    }

    public static void modifyInterestRate(double newInterestRate) {
        annualInterestRate = newInterestRate;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = getSavingsBalance() * annualInterestRate / 12;
        setSavingsBalance(getSavingsBalance() + monthlyInterest);
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double newSavingsBalance) {
        savingsBalance = newSavingsBalance;
    }

    private double savingsBalance;
}
