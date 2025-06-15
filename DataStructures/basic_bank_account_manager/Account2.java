/**
 * Title: Account2.java
 * Description: Represents a bank account with attributes for name, account number,
 *              type (1: Checking, 2: Savings), and balance. Supports deposit and
 *              withdrawal operations with basic validation.
 * Author: Shane Skare
 * Date: 09/05/2023
 */

    public class Account2 {
        private String name;
        private int number;
        private int type;
        private double balance;

        public Account2() {
            this.name = "UNKNOWN";
            this.number = 0;
            this.type = 0;
            this.balance = 0;
        }


        public Account2(String name, int number, int type, double balance) {
            this.name = name;
            this.number = number;
            this.type = type;
            this.balance = balance;
        }


        public void setAccount(String name, int number, int type, double balance) {
            this.name = name;
            this.number = number;
            this.type = type;
            this.balance = balance;
        }


        public boolean deposit(double fund) {
            if (fund < 0.0)
            {
                System.out.println("Error: no negative amount to deposit.");
                return false;
            }
            else
            {
                balance += fund;
                return true;
            }
        }
        public int getNum(){
            return number;
     }


        public boolean withdrawal(double fund) {
            if (fund > balance)
            {
                System.out.println("Error: insufficient balance to withdraw.");
                return false;
            }
            else
            {
                balance -= fund;
                return true;
            }
        }


        public void printAccount() {
            System.out.println("Account holder's name: " + name +
                    "\nAccount number: " + number +
                    "\nAccount type: " + type +
                    "\nBalance: " + balance + "\n");
        }
 }
