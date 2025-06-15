/**
 * Title: Bank2.java
 * Description: A simple banking system class that can hold up to five accounts.
 *              Supports opening, closing, and printing of account data. Each account
 *              is stored as an `Account2` object.
 * Author: Shane Skare
 * Date: 09/05/2023
 */
public class Bank2 {
    private Account2[] accounts;
    private String bankName;
    private int numOfAccounts;

    // Default constructor
    public Bank2() {
        accounts = new Account2[5];
        bankName = "UNKNOWN";
        numOfAccounts = 0;
    }


    public String toString() {
        return("Bank name: " + bankName + "\nNumber of accounts: " + numOfAccounts);
    }


    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    // Open an account based on the user's input.
    public boolean openAccount(String name, int number, int type, double balance ) {
        for (int i = 0; i < numOfAccounts; i++)
            if (number == (accounts[i].getNum()) || numOfAccounts > 4)
                return false;

        accounts[numOfAccounts] = new Account2();
        accounts[numOfAccounts].setAccount(name, number, type, balance);
        numOfAccounts++;
        return true;
    }


    public boolean closeAccount(int num) {
        for (int i = 0; i < numOfAccounts; i++) {
             if (num == (accounts[i].getNum())) {
                 accounts[i] = null;
                 int j = i;
                 i++;
                 while (accounts[i]!= null){
                     accounts[j] = accounts[i];
                     accounts[i] = null;
                     i++;
                     j++;
                 }
                 numOfAccounts--;
                 return true;
             }
        }
        return false;
}

    //Prints out all the accounts' information
    public void printAllAccounts() {
        for (int i = 0; i < numOfAccounts; i++) {
            accounts[i].printAccount();

        }
}
}
