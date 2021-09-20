package AddressBookController;

import AddressBookModel.PersonInfo;
import AddressBookService.AddressBook;
import Utility.UserInputOutput;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class AddressBookSystem {
    private static final int ADD = 1;
    private static final int EDIT = 2;
    private static final int DELETE = 3;
    private static final int DISPLAY = 4;
    private static final int SEARCH_CITY = 5;
    private static final int QUIT = 6;

    static AddressBook add_Book = new AddressBook();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Hashtable<String, ArrayList<PersonInfo>> personInfoDict = new Hashtable<>();
        boolean flag = true;
        int option;
        while (flag) {
            option = UserInputOutput.menu();
            switch (option) {
                case ADD:
                    System.out.println("\n" + "Add a new Address Book");
                    personInfoDict = add_Book.insertContactDetails();
                    //System.out.println(personInfoDict + "\n");
                    break;
                case EDIT:
                    break;
                case DELETE:
                    break;
                case DISPLAY:
                    System.out.println("\n" + "Display all contacts in the Address Book");
                    add_Book.displayCompanyContacts(personInfoDict);
                    break;


            }
        }
    }
}
