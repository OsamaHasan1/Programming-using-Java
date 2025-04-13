package myPackage3;


import java.util.ArrayList;
import java.util.Scanner;

public class Procedural {
    public static void main(String[] args) {
    	//Students's information listing
        ArrayList<String> students = new ArrayList<>();
        ArrayList<String> phoneNumbers = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        
        //adding menus 
        while (true) {
            System.out.println("Welcome to The Garden Academy!");
            System.out.println("1. Register");
            System.out.println("2. Login as admin");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            //Choosing menu
            switch (choice) {
                case 1:
                    register(students, phoneNumbers, scanner);
                    break;
                case 2:
                    Admin(students, phoneNumbers, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
       //Registering student
       private static void register(ArrayList<String> students, ArrayList<String> phoneNumbers, Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        if (!name.isEmpty() && !phoneNumber.isEmpty()) {
            students.add(name);
            phoneNumbers.add(phoneNumber);
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
        System.out.print("Choose a course number: ");
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
        System.out.println("\nPlease enter your bank information");
        System.out.print("Card number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("CSC: ");
        String csc = scanner.nextLine();
        System.out.print("Expiry date: ");
        String expiryDate = scanner.nextLine();
        System.out.println("Course successfully purchased!");
    }
        //Admin view 
        private static void Admin(ArrayList<String> students, ArrayList<String> phoneNumbers, Scanner scanner) {
        System.out.print("Enter your admin pin: ");
        String pin = scanner.nextLine();
        if (pin.equals("8471") || pin.equals("2801") || pin.equals("9452")) {
            System.out.println("\nStudents' informations:");
            for (int i = 0; i < students.size(); i++) {
                System.out.println("Name: " + students.get(i) + " - Phone Number: " + phoneNumbers.get(i));
            }
        } else {
            System.out.println("Error: Incorrect PIN");
        }
    }
}