package AddressBookService;

import AddressBookModel.PersonInfo;
import Repository.AddressBookRepository;

import java.util.ArrayList;
import java.util.Hashtable;

public class AddressBook implements AddressBookInterface {
    AddressBookRepository addressBookRepository = new AddressBookRepository();

    @Override
    public Hashtable<String, ArrayList<PersonInfo>> insertContactDetails() {
        return addressBookRepository.insertContactDetails();
    }

    @Override
    public void displayCompanyContacts(Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
         addressBookRepository.displayCompanyContacts(personInfoDict);
    }



}
