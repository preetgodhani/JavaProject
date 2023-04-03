package Checking4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Checking4_pgodha3 {

    static class Checking {
        private int AccNum;
        private String Name;
        private double Balance;

        public Checking(int AccNum, String Name, double Balance) {
            this.AccNum = AccNum;
            this.Name = Name;
            this.Balance = Balance;
        }

        public int getAccNum() {
            return AccNum;
        }

        public String getName() {
            return Name;
        }

        public double getBalance() {
            return Balance;
        }

        public void setBalance(double Balance) {
            this.Balance = Balance;
        }

        @Override
        public String toString() {
            return String.format("AccNum: %d, Name: %s, Balance: %.2f", AccNum, Name, Balance);
        }
    }

    // Write the Checking objects in the given array to a text file
    public static void WriteAcc(Checking[] AccInfo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("AccInfo.txt"));
            for (Checking acc : AccInfo) {
                writer.write(String.format("%d,%s,%.2f\n", acc.getAccNum(), acc.getName(), acc.getBalance()));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Read a text file and generate Checking objects
    public static Checking[] ReadAcc(String fileName) {
        Checking[] accArray = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int count = 0;
            while (reader.readLine() != null) {
                count++;
            }
            reader.close();

            accArray = new Checking[count];
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int index = 0;
            while (line != null) {
                String[] fields = line.split(",");
                accArray[index] = new Checking(Integer.parseInt(fields[0]), fields[1], Double.parseDouble(fields[2]));
                index++;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return accArray;
    }

    // Sort the Checking objects in the given array based on balance in descending order
    public static Checking[] SortBalanceDesc(Checking[] AccInfo) {
        int n = AccInfo.length;
        Checking[] sortedArray = Arrays.copyOf(AccInfo, n);

        // Bubble Sort algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray[j].getBalance() < sortedArray[j + 1].getBalance()) {
                    Checking temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        // print sorted array
        System.out.println("Sorted array by balance in descending order:");
        for (Checking acc : sortedArray) {
            System.out.println(acc);
        }

        return sortedArray;
    }

    // Search a value within the Checking objects in the given array and return an array with matching objects
    public static Checking[] SearchBalance(Checking[] AccInfo) {
        Checking[] matching
