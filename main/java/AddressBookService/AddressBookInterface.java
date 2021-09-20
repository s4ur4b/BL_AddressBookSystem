package AddressBookService;

import AddressBookModel.PersonInfo;

import java.util.ArrayList;
import java.util.Hashtable;

public interface AddressBookInterface {
    abstract Hashtable<String, ArrayList<PersonInfo>> insertContactDetails();
    abstract void displayCompanyContacts(Hashtable<String, ArrayList<PersonInfo>> personInfoDict);

}
