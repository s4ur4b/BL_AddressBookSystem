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

    @Override
    public void updateContact(String addressBookName, Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        addressBookRepository.updateContact(addressBookName,personInfoDict);
    }

    @Override
    public boolean findContact(String addressBookName, Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        return addressBookRepository.findContact(addressBookName,personInfoDict);
    }

    @Override
    public void editContactDetails(String addressBookName, Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        addressBookRepository.editContactDetails(addressBookName,personInfoDict);
    }

    @Override
    public void deleteContact(String deletedName, Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        addressBookRepository.deleteContact(deletedName,personInfoDict);
    }

    @Override
    public void searchPerson() {
        addressBookRepository.searchPerson();
    }


}
