package myPackage2;

//inheritance
public class Student extends Person {

    // Constructor
    public Student(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    // Polymorphism (overload)
    public Student(String name) {
        super(name, "");
    }

    //Polymorphism (toString method)
    public String toString() {
        return super.toString();
    }
}