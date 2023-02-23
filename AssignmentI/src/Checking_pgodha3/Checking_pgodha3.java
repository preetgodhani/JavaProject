package Checking_pgodha3;
import java.util.Scanner;

public class Checking_pgodha3 {

		  int AccountNumber;
		  static float InterestRate;
		
		  public void ChangAccNum(int newAccNum) {
		    AccountNumber = newAccNum;
		  }
		  
		  public static void SetInterest(float newInterestRate) {
		    InterestRate = newInterestRate;
		  }
		  
		  public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    
		    // Average of three numbers
		    System.out.print("Enter three numbers: ");
		    int num1 = sc.nextInt();
		    int num2 = sc.nextInt();
		    int num3 = sc.nextInt();
		    int average = (num1 + num2 + num3) / 3;
		    System.out.println("The average of the three numbers is: " + average);
		    
		    sc.nextLine(); // to clear user input
		    
		    // Length and third character of a string
		    System.out.print("Enter a string: ");
		    String inputString = sc.nextLine();
		    int length = inputString.length();
		    char thirdChar = inputString.charAt(2);
		    System.out.println("Length of the string: " + length + " Third character: " + thirdChar);
		    
		    // Change account number
		    System.out.print("Enter a number for account number: ");
		    int newAccNum = sc.nextInt();
		    Checking_pgodha3 checking = new Checking_pgodha3();
		    checking.ChangAccNum(newAccNum);
		    System.out.println("Account number changed to: " + checking.AccountNumber);
		    
		    // Change interest rate
		    System.out.print("Enter a number for interest rate: ");
		    float newInterestRate = sc.nextFloat();
		    Checking_pgodha3.SetInterest(newInterestRate);
		    System.out.println("Interest rate changed to: " + Checking_pgodha3.InterestRate);
		  }
		

	}


