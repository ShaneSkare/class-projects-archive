/**
 * Title: ATM.java
 * Description: Models an ATM machine that supports basic banking operations such as
 *              withdrawals, deposits, transfers, and balance tracking. Each operation
 *              includes validation for user name and PIN, and outputs success or failure messages.
 *              Also supports ATM configuration and status reporting.
 * Author: Shane Skare
 * Date: 09/07/2023
 */
public class ATM {
    private String bankName = "UNKNOWN";
    private int serialNumber = 0;
    private String atmLocation = "UNKNOWN";
    private double atmBalance = 100.00;

    String[] names = new String[]{"Alice", "Tom", "Monica", "Bob", "Chris"};
    int[] pins = new int[]{1234, 2000, 3000, 7777, 8000};
    double[] balances = new double[]{5000.00, 200.00, 50.00, 0.00, 500.00};

    public ATM(String location){
        setATM(location);
    }

    public ATM(int serial, String name, String location){
        setATM(serial, name, location);
    }

    public void setATM(String name){
        bankName = name;
    }
    public void setATM(int serial, String location){
        serialNumber = serial;
        atmLocation = location;
    }
    public void setATM(int serial, String name, String location){
        serialNumber = serial;
        bankName = name;
        atmLocation = location;
    }

    public String toString()
    {
        return ("Serial Number: " + serialNumber + "\nBank Name: " + bankName + "\nLocation: " + atmLocation
        + "\nBalance: " + String.format("%.2f", atmBalance));
    }
    public boolean equals(ATM otherAtm) {
        return (serialNumber == otherAtm.serialNumber) &&
                (bankName.equals(otherAtm.bankName)) &&
                (atmBalance == otherAtm.atmBalance) &&
                (atmLocation.equals(otherAtm.atmLocation));
    }
    public void addFund(double fund){
        atmBalance += fund;
    }
    public void withdrawal(String name, int pin, double amount)
    {
        int finder = 0;
        while(finder <= 4) {
            if ((names[finder].equals(name)) && (pins[finder] == pin) && (amount < atmBalance)) {
                atmBalance -= amount;
                balances[finder] -= amount;
                System.out.printf("Succeed – Withdrawal: Alice new balance: $" + "%.2f%n",balances[finder]);
                return;
            }
            finder++;
        }
        System.out.println("Fail – Withdrawal");
    }
    public void status(){
        System.out.println("Serial Number: " + serialNumber + "\nBank Name: " + bankName + "\nLocation: " + atmLocation);
        System.out.printf("Balance: " + "%.2f%n",atmBalance);
    }
    public void deposit(String name, int pin, double amount){
        int finder = 0;
        while(finder <= 4) {
            if ((names[finder].equals(name)) && (pins[finder] == pin) && amount >= 0.01) {
                atmBalance += amount;
                balances[finder] += amount;
                System.out.printf("Succeed – Deposit: Alice new balance: $" + "%.2f%n",balances[finder]);
                return;
            }
            finder++;
        }
        System.out.println("Fail – Deposit");
    }
    public void transfer(String nameA, int pin, double amount, String nameB){
        int finder = 0;
        while(finder <= 4) {
            if ((names[finder].equals(nameA)) && (pins[finder] == pin) && amount <= balances[finder]) {
                int finderB = 0;
                while(finderB <= 4) {
                    if (names[finderB].equals(nameB)){
                        balances[finder] -= amount;
                        balances[finderB] += amount;
                        System.out.printf("Succeed – Transfer: Alice new balance: $" + "%.2f%n", balances[finder]);
                        return;
                    }
                    finderB++;
                }
            }
            finder++;
        }
        System.out.println("Fail – Transfer");
    }
}
