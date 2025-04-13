package myPackage;

public class Person {
    private String name;
    private String phoneNumber;

    //Constructor
    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter for name
    public String getName() {
        return name;
    }
    
    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter for phone Number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter for phoneNumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString method
    public String toString() {
        return "Name: " + name + ", Phone number: " + phoneNumber;
    }
    
    // CompareTo method to compare names (for the bubbleSort)
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}