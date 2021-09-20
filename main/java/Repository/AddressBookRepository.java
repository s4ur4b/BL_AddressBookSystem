package Repository;

import AddressBookModel.PersonInfo;
import AddressBookService.AddressBookInterface;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookRepository implements AddressBookInterface {
    Scanner input = new Scanner(System.in);
    Hashtable<String, ArrayList<PersonInfo>> personInfoDict = new Hashtable<>();
    PersonInfo personInfo = null;
    ArrayList<PersonInfo> pList = new ArrayList<>();

    //Adds contact into an AddressBook
    @Override
    public Hashtable<String, ArrayList<PersonInfo>> insertContactDetails() {
        boolean found = false;

        personInfo = new PersonInfo();
        System.out.println("Enter the Address Book Name: ");
        String addressBookName = input.next();
        System.out.print("Enter the First Name: ");
        personInfo.setFirst_name(input.next().toString());
        System.out.print("Enter the Last Name: ");
        personInfo.setLast_name(input.next().toString());
        System.out.print("Enter the Address: ");
        personInfo.setAddress(input.next().toString());
        System.out.print("Enter the City: ");
        personInfo.setCity(input.next().toString());
        System.out.print("Enter the State: ");
        personInfo.setState(input.next().toString());
        System.out.print("Enter the Zip: ");
        personInfo.setZip(input.nextInt());
        System.out.print("Enter the Phone Number: ");
        personInfo.setPhone_number(input.next().toString());
        System.out.print("Enter the Email: ");
        personInfo.setEmail(input.next().toString());

        if (personInfoDict.containsKey(addressBookName)) {
            ArrayList<PersonInfo> value = personInfoDict.get(addressBookName);
            for (int j = 0; j < value.size(); j++) {

//              List<String> names = value.stream().map(PersonInfo::getFirst_name).collect(Collectors.toList());
                List<String> names = value.stream().map(person -> person.getFirst_name()).collect(Collectors.toList());
                for (int k = 0; k < names.size(); k++) {
                    if (names.get(j).equals(personInfo.getFirst_name())) {
                        found = true;
                        break;
                    }
                }
            }
            if (found == true)
                System.out.println("\nDuplicate First Name in Address Book!\n");
            else {
                value.add(personInfo);
                personInfoDict.put(addressBookName, value);
            }
        }
        else {
            pList = new ArrayList<>();
            pList.add(personInfo);
            personInfoDict.put(addressBookName, pList);
        }

                return personInfoDict;
    }

    //Display all contacts in the AddressBook
    @Override
    public void displayCompanyContacts(Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
            personInfoDict.keySet().forEach(entry -> {
                System.out.println(entry+ "-->"+personInfoDict.get(entry)+"\n");
            });

    }


}
