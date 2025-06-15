public class Vehicle {
    private String manufacturer;
    private int cylinders;
    private Person owner;

    public Vehicle() {
        this.manufacturer = "Unknown";
        this.cylinders = 0;
        this.owner = null;
    }
    public String toString() {
        return manufacturer + ", " + cylinders + ", " + owner;
    }
    public Vehicle(Vehicle v) {
        this.manufacturer = v.getManufacturer();
        this.cylinders = v.getCylinders();
        this.owner = v.getOwner();
    }
    public Vehicle(String theManufacturer, int theCylinders, Person theOwner) {
        this.manufacturer = theManufacturer;
        this.cylinders = theCylinders;
        this.owner = theOwner;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String theManufacturer) {
        this.manufacturer = theManufacturer;
    }
    public int getCylinders() {
        return cylinders;
    }
    public void setCylinders(int theCylinders) {
        this.cylinders = theCylinders;
    }
    public Person getOwner() {
        return owner;
    }
    public void setOwner(Person theOwner) {
        this.owner = theOwner;
    }
}
