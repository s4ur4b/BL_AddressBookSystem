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
    public void updateContact(String replacedContact, Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        addressBookRepository.updateContact(replacedContact,personInfoDict);
    }

    @Override
    public boolean findContact(String contact, Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        return addressBookRepository.findContact(contact,personInfoDict);
    }

    @Override
    public void editContactDetails(String replacedContact, Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        addressBookRepository.editContactDetails(replacedContact,personInfoDict);
    }


}
