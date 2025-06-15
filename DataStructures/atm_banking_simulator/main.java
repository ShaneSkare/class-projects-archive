public class main {
    public static void main(String[] args)
    {
        ATM machine1 = new ATM("OSU");
        ATM machine2 = new ATM(200, "BOA", "Library");

        System.out.println("===== Welcome to CSUMB ATM Machine =====");
        System.out.println(machine1);
        System.out.println("");
        System.out.println(machine2);
        System.out.println("\n===== Equality Checking =====");
        System.out.println(machine1.equals(machine2));
        System.out.println("");

        machine1.setATM(100, "BIT110");
        machine1.addFund(400.00); // In this method, assume that an ATM operator
        // adds $400.00 more cash to the machine.
        System.out.println(machine1);

        System.out.println("\n===== Withdrawal Operations =====");
        machine1.withdrawal("Alice", 7777, 10.00); // In this method, assume
        // that a user, Alice, tries to withdraw $10.00 with PIN 7777.

        machine1.withdrawal("Eric", 1234, 10.00);
        machine1.withdrawal("Alice", 1234, 10000.00);
        machine1.withdrawal("Alice", 1234, 10.00);
        machine1.withdrawal("Alice", 1234, 2000.00);

        System.out.println("\n===== Machine Status A =====");
        machine1.status();

        System.out.println("\n===== Deposit Operation =====");
        machine1.deposit("Alice", 1234, 10.00); // In this method, assume that
        // a user, Alice, tries to deposit $10.00
        // to the machine with PIN 1234.

        System.out.println("\n===== Machine Status B =====");
        machine1.status();

        System.out.println("\n===== Transfer Operations =====");
        machine1.transfer("Alice", 1234, 5010.00, "Tom"); // In this method,
        // we assume that a user "Alice" tries to transfer $5010.00
        // to "Tom". 1234 is the sender’s PIN.

        machine1.transfer("Alice", 1234, 510.00, "Tom"); // In this method,
        // we assume that a user "Alice" tries to transfer $510.00
        // to "Tom". 1234 is the sender’s PIN.

        System.out.println("\n===== Machine Status C =====");
        machine1.status();

        System.out.println("\n======== ANSWER: five failure messages for withdrawal ========\n");
        machine1.withdrawal("Byun", 1234, 10);
        machine1.withdrawal("Tom", 2001, 200);
        machine1.withdrawal("Bob", 7777, 0.01);
        machine1.withdrawal("Alice", 2020, 101);
        machine1.withdrawal("Eric", 8000, 10.50);
        System.out.println("\n======== ANSWER: BALANCE SHOULD BE $100.00 ========\n");
        System.out.println(machine1);


        System.out.println("\n===== Thank you! =====");
    }

}


