package checking_pgodha3;

public class Checking_pgodha3 {
    private int AccNum;
    private float Balance = 100;

    public void Deposit(float amount) {
        Balance += amount;
    }

    public int Withdraw(float amount) {
        if (amount > Balance) {
            return 0;
        } else {
            Balance -= amount;
            return 1;
        }
    }

    public static void main(String[] args) {
        Checking_pgodha3 account = new Checking_pgodha3();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Enter 'deposit' or 'withdraw':");
        String action = scanner.next();

        System.out.println("Enter amount:");
        float amount = scanner.nextFloat();

        if (action.equals("deposit")) {
            account.Deposit(amount);
            System.out.println("Deposit successful.");
            System.out.println("Balance: " + account.Balance);
        } else if (action.equals("withdraw")) {
            int result = account.Withdraw(amount);
            if (result == 0) {
                System.out.println("Your withdraw exceeds limit.");
                System.out.println("Balance: " + account.Balance);
            } else {
                System.out.println("Withdraw successful.");
                System.out.println("Balance: " + account.Balance);
            }
        }
    }
}
