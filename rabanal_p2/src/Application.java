public class Application {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);
        SavingsAccount.modifyInterestRate(0.04);

        for (int i = 1; i <= 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.println("Month " + i + ":\tsaver1: $" + saver1.getSavingsBalance() + "\tsaver2: $" + saver2.getSavingsBalance());
        }

        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("After change to 5% interest:");
        System.out.println("Month 13:\tsaver1: $" + saver1.getSavingsBalance() + "\tsaver2: $" + saver2.getSavingsBalance());
    }
}
