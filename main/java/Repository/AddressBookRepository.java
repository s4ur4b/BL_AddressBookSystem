package Repository;

import AddressBookModel.PersonInfo;
import AddressBookService.AddressBookInterface;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AddressBookRepository implements AddressBookInterface {
    Scanner input = new Scanner(System.in);

    //Created a Hashmap to Maintain Multiple Address Books having Key as AddressBook Name and Value as ArrayList
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

        //To Ensure there is no Duplicate contact in the Address Book
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
        } else {
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
            System.out.println(entry + "-->" + personInfoDict.get(entry) + "\n");
        });

    }

    //Checks weather Address book exists in the HashTable and then initiates The Edit contact method
    @Override
    public void updateContact(String addressBookName, Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        boolean flag = findContact(addressBookName, personInfoDict);
        if (flag == true) {
            editContactDetails(addressBookName, personInfoDict);
        } else {
            System.out.println("\nNo such Address Book found to update!\n");
        }
    }

    //Checks weather Address book exists in the HashTable
    @Override
    public boolean findContact(String addressBookName, Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        for (int i = 0; i < personInfoDict.size(); i++) {
            if (personInfoDict.containsKey(addressBookName))
                return true;
        }
        return false;
    }

    @Override
    public void editContactDetails(String addressBookName, Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        System.out.print("\nEnter the first name you want to edit the details for : ");
        String fName = input.next();

        ArrayList<PersonInfo> value = personInfoDict.get(addressBookName);
        for (int j = 0; j < value.size(); j++) {
            if (value.get(j).getFirst_name().equals(fName)) {
                System.out.println("Choose your edit option: ");
                System.out.println("1. Last Name");
                System.out.println("2. Address");
                System.out.println("3. City");
                System.out.println("4. State");
                System.out.println("5. Zip");
                System.out.println("6. Phone Number");
                System.out.println("7. Email");
                int editOption = input.nextInt();

                switch (editOption) {
                    case 1:
                        System.out.println("Enter new Last Name: ");
                        value.get(j).setLast_name(input.next().toString());
                        break;
                    case 2:
                        System.out.println("Enter new Address: ");
                        value.get(j).setAddress(input.next().toString());
                        break;
                    case 3:
                        System.out.println("Enter new City: ");
                        value.get(j).setCity(input.next().toString());
                        break;
                    case 4:
                        System.out.println("Enter new State: ");
                        value.get(j).setState(input.next().toString());
                        break;
                    case 5:
                        System.out.println("Enter new Zip: ");
                        value.get(j).setZip(input.nextInt());
                        break;
                    case 6:
                        System.out.println("Enter new Phone Number: ");
                        value.get(j).setPhone_number(input.next().toString());
                        break;
                    case 7:
                        System.out.println("Enter new Email: ");
                        value.get(j).setEmail(input.next().toString());
                        break;
                }
                System.out.println("\nUpdated successfully!\n");
                break;
            } else
                System.out.println("\nNo First Name Found!\n");
        }
    }

    @Override
    public void deleteContact(String deleteAddressBookName, Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        boolean found = false;
        boolean flag = findContact(deleteAddressBookName, personInfoDict);

        if (flag == true) {
            System.out.print("\nEnter the first name you want to delete : ");
            String fName = input.next();

            ArrayList<PersonInfo> value = personInfoDict.get(deleteAddressBookName);
            for (int j = 0; j < value.size(); j++) {
                if (value.get(j).getFirst_name().equals(fName)) {
                    value.remove(j);
                    found = true;
                    break;
                }
            }
            if (found == true) {
                System.out.println("\nContact in Address Book Deleted.\n");
            } else
                System.out.println("\nNo such First Name found in the Address Book.\n");
        } else
            System.out.println("\nNo such Address Book found.\n");
    }

    //Method to Search Person by City or State and Count by City or State
    @Override
    public void searchPerson() {
        Hashtable<String,Hashtable<String,ArrayList<String>>> searchList = new Hashtable<>();

        AtomicInteger count = new AtomicInteger();

        System.out.println("Press 1 to search person by city");
        System.out.println("Press 2 to search person by state");
        int choice = input.nextInt();

        switch (choice){
            case 1:
                System.out.print("\nEnter the city name to search: ");
                String cityName = input.next();

                personInfoDict.keySet().forEach(entry -> {
                    ArrayList<PersonInfo> value = personInfoDict.get(entry);
                    List<String> city = value.stream().map(citySearch -> citySearch.getCity()).collect(Collectors.toList());
                    Hashtable<String,ArrayList<String>> person = new Hashtable<>();
                    ArrayList<String> firstName = new ArrayList<>();
                    for (int k = 0; k < city.size(); k++){
                        if (city.get(k).equals(cityName)){
                            firstName.add(value.get(k).getFirst_name());
                            count.getAndIncrement();
                        }
                        person.put(cityName,firstName);
                    }
                    searchList.put(entry,person);
                });
                break;

            case 2:
                System.out.print("\nEnter the state name to search: ");
                String stateName = input.next();

                personInfoDict.keySet().forEach(entry -> {
                    ArrayList<PersonInfo> value = personInfoDict.get(entry);
                    List<String> state = value.stream().map(searchState -> searchState.getState()).collect(Collectors.toList());
                    Hashtable<String , ArrayList<String>> person = new Hashtable<>();
                    ArrayList<String> firstName = new ArrayList<>();
                    for (int k = 0; k < state.size(); k++){
                        if (state.get(k).equals(stateName)){
                            firstName.add(value.get(k).getFirst_name());
                            count.getAndIncrement();
                        }
                        person.put(stateName, firstName);
                    }
                    searchList.put(entry, person);
                });
                break;
        }
        System.out.println("\nViewing Persons by City or State\n" +searchList);
        System.out.println("\nNumber of contact persons i.e. count by City or State is : " +count +"\n");
    }

    @Override
    public void sortPerson() {
        System.out.println("Press 1 to sort person by First Name");
        System.out.println("Press 2 to sort person by City");
        System.out.println("Press 3 to sort person by State");
        System.out.println("Press 4 to sort person by Zip");
        int choice = input.nextInt();

        switch(choice) {
            case 1:
                System.out.println("\nSorting Address Book based on First Name");
                personInfoDict.keySet().forEach(entry -> {
                    List<PersonInfo> data = personInfoDict.get(entry).stream().sorted(Comparator.comparing(p -> p.getFirst_name())).collect(Collectors.toList());
                    System.out.println(data);
                });
                break;
            case 2:
                System.out.println("\nSorting Address Book based on City");
                personInfoDict.keySet().forEach(entry -> {
                    List<PersonInfo> data = personInfoDict.get(entry).stream().sorted(Comparator.comparing(p -> p.getCity())).collect(Collectors.toList());
                    System.out.println(data);
                });
                break;
            case 3:
                System.out.println("\nSorting Address Book based on State");
                personInfoDict.keySet().forEach(entry -> {
                    List<PersonInfo> data = personInfoDict.get(entry).stream().sorted(Comparator.comparing(p -> p.getState())).collect(Collectors.toList());
                    System.out.println(data);
                });
                break;
            case 4:
                System.out.println("\nSorting Address Book based on Zip");
                personInfoDict.keySet().forEach(entry -> {
                    List<PersonInfo> data = personInfoDict.get(entry).stream().sorted(Comparator.comparing(p -> p.getZip())).collect(Collectors.toList());
                    System.out.println(data);
                });
                break;
        }
    }

}

