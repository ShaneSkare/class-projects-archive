public class Main {
    /*
     * Name: Test Case 6
     * Purpose: The program tests if there are no accounts created and someone tries to close an
     * account the program does not crash.
     * Expected Result: The program should not crash and just end after it attempts to close the
     * account.
     */

    public static void main(String[] args) {
        Bank2 testBank = new Bank2();
        testBank.setBankName("CSUMB");

        System.out.println(testBank.closeAccount(2000));
    }
}
// Display the current account(s) information on the screen.

//                testBank.printAllAccounts();

//                        System.out.println(testBank.closeAccount(3000));

//                testBank.printAllAccounts();

//            System.out.println(testBank.openAccount("Bob", 1000, 1,0));