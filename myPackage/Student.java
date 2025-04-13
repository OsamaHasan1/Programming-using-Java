package myPackage;

//inheritance
public class Student extends Person {

  // Constructor
  public Student(String name, String phoneNumber) {
      super(name, phoneNumber);
  }

  // Polymorphism (Overload)
  public Student(String name) {
      super(name, "");
  }

  //Polymorphism toString method(Override)
  public String toString() {
      return super.toString();
  }
}