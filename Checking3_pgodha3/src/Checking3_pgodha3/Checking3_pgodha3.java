package Checking3_pgodha3;
import java.util.Scanner;

class Checking {
	int AccNum;
	float Balance = 100;
	
	public Checking(int accnum, float balance2) {
		this.AccNum = accnum;
		this.Balance = balance2;
	}

	public float getBalance() {
		// TODO Auto-generated method stub
		return this.Balance;
	}
	
	public void Deposit(float value) {
		this.Balance += value;
	}
	
	public int Withdraw(float value) {
		if (value > this.Balance)
			return 0;
		else {
			this.Balance -= value;
			return 1;
		}
	}
	
	
}

public class Checking3_pgodha3 {
    private static Checking[] AccInfo;
    private static Checking[] p;
    private static int NumAcc;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of checking accounts: ");
        NumAcc = input.nextInt();
        AccInfo = new Checking[NumAcc];

        getInput();
    }

    private static void getInput() {
        Scanner input = new Scanner(System.in);
        String command = "";

        while (!command.equals("exit")) {
            System.out.print("Enter a command (create, search, exit): ");
            command = input.nextLine();

            switch (command) {
                case "create":
                    AccInfo = create();
                    break;
                case "search":
                    p = BalanceSearch();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }

    private static Checking[] create() {
        Scanner input = new Scanner(System.in);
        Checking[] checks = new Checking[NumAcc];

        for (int i = 0; i < NumAcc; i++) {
            System.out.print("Enter account number: ");
            int accNum = input.nextInt();
            System.out.print("Enter balance: ");
            float balance = input.nextFloat();
            input.nextLine();
            checks[i] = new Checking(accNum, balance);
        }

        return checks;
    }

    private static Checking[] BalanceSearch() {
        if (AccInfo == null || AccInfo.length == 0) {
            System.out.println("No checking accounts to view!");
            return new Checking[0];
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter balance to search: ");
        double balance = input.nextDouble();
        input.nextLine();

        int count = 0;
        for (int i = 0; i < AccInfo.length; i++) {
            if (AccInfo[i].getBalance() == balance) {
                System.out.println("Index: " + i);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No matches found!");
            return new Checking[0];
        }

        Checking[] checks = new Checking[count];
        int index = 0;
        for (int i = 0; i < AccInfo.length; i++) {
            if (AccInfo[i].getBalance() == balance) {
                checks[index] = AccInfo[i];
                index++;
            }
        }

        return checks;
    }
}
