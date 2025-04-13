package myPackage2;

import java.util.ArrayList;
import java.util.Scanner;

public class OOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        //Choosing menu
        while (true) {
            MainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Register(scanner, students);
                    break;
                case 2:
                    Admin(scanner, students);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    //Menus list (main)
    private static void MainMenu() {
        System.out.println("Welcome to The Garden Academy!");
        System.out.println("1. Register");
        System.out.println("2. Login as admin");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }
    
    //Registering student
    private static void Register(Scanner scanner, ArrayList<Student> students) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        if (!name.isEmpty() && !phoneNumber.isEmpty()) {
            Student student = new Student(name, phoneNumber);
            students.add(student);
            System.out.println("Student registered successfully!");
            Courses(scanner);
        } else {
            System.out.println("Please fill in all fields correctly.");
        }
    }
    
    //Courses menu
    private static void Courses(Scanner scanner) {
        System.out.println("\nChoose the course you want to purchase:");
        String[] courses = { "1. Mathematics - Mr. Mohammed Ziad",  "2. Chemistry - Mr. Tareq Mohammed",
            "3. Physics - Mr. Ahmed Al-tamimi", "4. Biology - Mr. Mousa Al-Zamil",
            "5. Arabic - Mr. Hassan Salhab" };
        for (int i = 0; i < courses.length; i++) {
            System.out.println(courses[i]);
        }
        System.out.print("Choose the course number you want to purchase: ");
        int courseChoice = scanner.nextInt();
        scanner.nextLine();
        if (courseChoice > 0 && courseChoice <= courses.length) {
            Payment(scanner);
        } else {
            System.out.println("Invalid course choice.");
        }
    }
        
        //Payment menu
        private static void Payment(Scanner scanner) {
            System.out.println("\nPlease enter your bank information: ");
            System.out.print("Card number: ");
            String cardNumber = scanner.nextLine();
            System.out.print("CSC: ");
            String csc = scanner.nextLine();
            System.out.print("Expiry date: ");
            String expiryDate = scanner.nextLine();
            System.out.println("Course successfully purchased!");
        }
    
        //Admin view 
        private static void Admin(Scanner scanner, ArrayList<Student> students) {
            System.out.print("Enter your admin pin: ");
            int pin = scanner.nextInt();
            scanner.nextLine();
            if (pin == 8471 || pin == 2801 || pin == 9452) {
                System.out.println("\nStudents' information:");
                for (int i = 0; i < students.size(); i++) {
                    System.out.println(students.get(i).toString());

                }
                }
             else {
                System.out.println("Error: Incorrect PIN");
            }
            }
            }




