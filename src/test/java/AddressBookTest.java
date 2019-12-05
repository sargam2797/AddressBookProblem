import com.addressbook.models.AddressDetails;
import com.addressbook.models.PersonDetails;
import com.addressbook.services.AddressBookManager;
import com.addressbook.services.AddressbookInterface;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {

    AddressbookInterface obj = new AddressBookManager();
    static String filePath = "/home/user/IdeaProjects/AddressBookProblem/src/main/resources/";

    @Test
    public void givenPersonDetailsClass_CheckIfObjectsAreInitialised() {
        PersonDetails personDetails = new PersonDetails("Sargam", "Pandey", "Kharadi",
                "7040969495", new AddressDetails("Pune","MAH","411014"));
        Assert.assertEquals("Sargam",personDetails.getFirstName());
        Assert.assertEquals("Pandey",personDetails.getLastName());
        Assert.assertEquals("Kharadi",personDetails.getAddress());
        Assert.assertEquals("7040969495",personDetails.getContact());
        Assert.assertEquals("Pune",personDetails.getAddressDetailsObject().getCity());
        Assert.assertEquals("MAH",personDetails.getAddressDetailsObject().getState());
        Assert.assertEquals("411014",personDetails.getAddressDetailsObject().getZip());
    }

    @Test
    public void givenAddressBookManagerClass_checkIfPersonDetailsAreAdded() throws IOException {
        PersonDetails personDetails = obj.addPerson("sargam","pandey","kharadi","1234",
                new AddressDetails("pune", "mah","14"));
        Assert.assertEquals("sargam", personDetails.getFirstName());
        Assert.assertEquals("pandey",personDetails.getLastName());
        Assert.assertEquals("kharadi",personDetails.getAddress());
        Assert.assertEquals("1234",personDetails.getContact());
        Assert.assertEquals("14",personDetails.getAddressDetailsObject().getZip());
        Assert.assertEquals("pune",personDetails.getAddressDetailsObject().getCity());
        Assert.assertEquals("mah",personDetails.getAddressDetailsObject().getState());
    }

    @Test
    public void ForPersonDetails_checkIfFieldsAreGettingAddedToJsonFile() throws IOException {
        PersonDetails personDetails = obj.addPerson("sargam","pandey","kharadi","1234",
                new AddressDetails("pune", "mah","14"));
        AddressBookManager addressBookManager = new AddressBookManager();
        boolean result = addressBookManager.writeToFile(personDetails,filePath);
        Assert.assertTrue(true);
    }

    @Test
    public void ForPersonDetails_checkIfFileIsAvailable() throws IOException {
       boolean result = obj.isFileAvailable(filePath,"Details.json");
       Assert.assertTrue(result);
    }

    @Test
    public void ForPersonDetails_checkIfFileIsUnAvailable() throws IOException {
        boolean result = obj.isFileAvailable(filePath,"abc.json");
        Assert.assertFalse(result);
    }

    @Test
    public void ForPersonDetails_checkIfFileIsCreated() throws IOException {
        String result = obj.createNewFile(filePath,"Details2.json");
        Assert.assertEquals("True",result);
    }

    @Test
    public void ForPersonDetails_doesNotCreateFileIfAlreadyExists() throws IOException {
        String result = obj.createNewFile(filePath,"Details2.json");
        Assert.assertEquals("False",result);
    }

}
