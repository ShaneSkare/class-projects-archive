/**
 * Title: Main.java
 * Description: Driver program to test the Person, Vehicle, and Truck classes.
 *              Demonstrates object instantiation, inheritance, method overriding,
 *              and object comparison using `.equals()`.
 * Author: Shane Skare
 * Date: 09/28/2023
 */

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        System.out.println("p1: " + p1);

        p1.setName("Bob");
        System.out.println("p1's name is: " + p1.getName() );

        Person p2 = new Person("Joe");
        System.out.println("p2: " + p2);

        Person p3 = new Person(p1);

        // It should display "true" and then "false".
        System.out.println(p3.equals(p1));
        System.out.println(p2.equals(p1));


        Vehicle v1 = new Vehicle();
        v1.setManufacturer("Ford");
        v1.setCylinders(4);
        v1.setOwner(new Person("Joe"));

        // It should display "Ford", 4, and "Joe".
        System.out.println("v1's manufacturer is: " + v1.getManufacturer() );
        System.out.println("v1's cylinders: " + v1.getCylinders() );
        System.out.println("v1's owner is: " + v1.getOwner() );

        Vehicle v2 = new Vehicle(v1);

        // It should display "Ford", 4, and "Joe".
        System.out.println("v2: " + v2);

        Truck t1 = new Truck("Ford", 4, p1);
        t1.setLoadCap(54.36);
        t1.setTowingCap(10);

        Truck t2 = new Truck("Ford", 4, p1, 54.36, 10);
        System.out.println("t1: " + t1);

        // It should display "true"
        System.out.println(t1.equals(t2));
    }
}
