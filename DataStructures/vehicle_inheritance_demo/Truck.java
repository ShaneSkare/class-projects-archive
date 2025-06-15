/**
 * Title: Truck.java
 * Description: A subclass of Vehicle that adds truck-specific fields such as
 *              load capacity and towing capacity. Implements equality checking
 *              and method overrides.
 * Author: Shane Skare
 * Date: 09/28/2023
 */

public class Truck extends Vehicle{
    private double loadCapacity;
    private int towingCapacity;

    public Truck() {
        super();
        this.loadCapacity = 0.0;
        this.towingCapacity = 0;
    }
    public Truck(String man, int cyl, Person owner) {
        super(man, cyl, owner);
        this.loadCapacity = 0.0;
        this.towingCapacity = 0;
    }
    public Truck(String man, int cyl, Person owner, double load, int tow) {
        super(man, cyl, owner);
        this.loadCapacity = load;
        this.towingCapacity = tow;
    }

    public double getLoadCap() {
        return loadCapacity;
    }

    public void setLoadCap(double theLoadCapacity) {
        this.loadCapacity = theLoadCapacity;
    }

    public int getTowingCap() {
        return towingCapacity;
    }

    public void setTowingCap(int theTowingCapacity) {
        this.towingCapacity = theTowingCapacity;
    }
    public boolean equals (Object other) {
        if (this == other)
            return true;

        Truck truck = (Truck)other;
        return (this.loadCapacity == truck.loadCapacity) && (this.towingCapacity == truck.towingCapacity) &&
                (this.getManufacturer().equals(truck.getManufacturer())) && (this.getOwner().equals(truck.getOwner())) &&
                (this.getCylinders() == truck.getCylinders());
    }
}
