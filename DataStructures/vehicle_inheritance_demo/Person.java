public class Person {
    private String name;

    public Person() {
        this.name = "UNKNOWN NAME";
    }

    public Person (Person person) {
       this(person.name);
    }
    public String toString() {
        return name;
    }
    public Person (String theName) {
        if (theName == null) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        this.name = theName;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String theName) {
        this.name = theName;
    }

    public boolean equals (Object other) {
        if (this == other)
            return true;

        Person person = (Person)other;
        return this.name.equals(person.name);
    }
}
