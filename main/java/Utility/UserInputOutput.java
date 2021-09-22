package Utility;

import java.util.Scanner;

public class UserInputOutput {

    private static Scanner scanner = new Scanner(System.in);

    public static String getCustomerFirstName(){
        System.out.println("Enter the First Name : ");
        return scanner.next();
    }

    public static String getCustomerLastName(){
        System.out.println("Enter the Last Name : ");
        return scanner.next();
    }

    public static String getCustomerEmailAddress(){
        System.out.println("Enter the Email Address : ");
        return scanner.next();
    }

    public static String getCustomerHomeAddress(){
        scanner.nextLine();
        System.out.println("Enter the Home Address : ");
        return scanner.nextLine();
    }

    public static String getCustomerCityName(){
        System.out.println("Enter the City Name : ");
        return scanner.next();
    }

    public static String getCustomerStateName(){
        System.out.println("Enter the State Name : ");
        return scanner.next();
    }

    public static String getCustomerMobileNumber(){
        System.out.println("Enter the Mobile Number : ");
        return scanner.next();
    }

    public static String getCustomerPinCode(){
        System.out.println("Enter the Pin Code : ");
        return scanner.next();
    }

    public static int menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nSelect option: ");
        System.out.println("1. Add a new contact in the address book.");
        System.out.println("2. Edit contact in the address book.");
        System.out.println("3. Delete contact in the address book.");
        System.out.println("4. Display all values from address book.");
        System.out.println("5. Search Address Book based on City or State.");
        System.out.println("6. Sort Address Book.");
        System.out.println("7. Quit.");
        int option = input.nextInt();

        return option;
    }
}
