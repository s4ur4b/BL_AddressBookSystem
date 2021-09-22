package Files;

import AddressBookModel.PersonInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;

public class ReadWriteOperations {
    String filePath = "src/main/java/Files/AddressBookData";


    public void writeInAddressBook(Hashtable<String, ArrayList<PersonInfo>> personInfoDict) {
        StringBuffer empBuffer = new StringBuffer();
        personInfoDict.forEach( (companyName, personInfos) -> {
            String empDataString = companyName.concat(personInfos.toString().concat("\n"));
            empBuffer.append(empDataString);
        });

        try {
            Files.write(Paths.get(filePath) , empBuffer.toString().getBytes());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromAddressBook() {
        try {
            Files.lines(new File(filePath).toPath())
                    .forEach(System.out::println);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
