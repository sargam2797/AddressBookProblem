import com.addressbook.models.AddressDetails;
import com.addressbook.models.PersonDetails;
import com.addressbook.services.AddressBookManager;
import com.addressbook.services.AddressbookInterface;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class AddressBookTest {

    AddressbookInterface obj = new AddressBookManager();
    static String filePath = "/home/user/IdeaProjects/AddressBookProblem/src/main/resources/Details.json";
    static String destinationFile = "/home/user/IdeaProjects/AddressBookProblem/src/main/resources/";

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
        PersonDetails personDetails = obj.addPerson("sargam","pandey","kharadi","7777777777",
                new AddressDetails("pune", "mah","14"));
        Assert.assertTrue(true);
    }

    @Test
    public void ForPersonDetails_checkIfFileIsAvailable() throws IOException {
       boolean result = obj.isFileAvailable(destinationFile,"Details.json");
       Assert.assertTrue(result);
    }

    @Test
    public void ForPersonDetails_checkIfFileIsUnAvailable() throws IOException {
        boolean result = obj.isFileAvailable(filePath,"abc.json");
        Assert.assertFalse(result);
    }

    @Test
    public void ForPersonDetails_checkIfFileIsCreated() throws IOException {
        String result = obj.createNewFile(destinationFile,"Details2.json");
        Assert.assertEquals("True",result);
    }

    @Test
    public void ForPersonDetails_doesNotCreateFileIfAlreadyExists() throws IOException {
        String result = obj.createNewFile(destinationFile,"Details2.json");
        Assert.assertEquals("False",result);
    }

    @Test
    public void ForPersonDetails_deleteParticularRecordFromFileShouldReturnTrue() throws IOException {
        String result = obj.deletePerson("sargam","Details.json");
        Assert.assertEquals("record removed successfully",result);
    }

    @Test
    public void ForPersonDetails_deleteParticularRecordFromFileShouldReturnFalse_ifNotPresent() throws IOException {
        String result = obj.deletePerson("pqr","Details.json");
        Assert.assertEquals("record not present to remove",result);
    }

    @Test
    public void ForPersonDetails_deletesFileWhenAlreadyPresent() throws IOException {
        String result = obj.deleteFile(destinationFile,"Details2.json");
        Assert.assertEquals("file deleted successfully",result);
    }

    @Test
    public void ForPersonDetails_deletesFileWhenAlreadyPresentShouldReturnFalse_ifNotPresent() throws IOException {
        String result = obj.deleteFile(destinationFile,"abc.json");
        Assert.assertEquals("file not found to delete",result);
    }

    @Test
    public void forPersonDetails_editRecordsSearchedByContact() throws FileNotFoundException {
        String result = obj.editPerson("pandey","abc","9999999999",new AddressDetails(
                "hyderabad",
                "tel","23"),filePath);
        Assert.assertEquals("record edited successfully",result);
    }

    @Test
    public void forPersonDetails_doesNotEditsRecords_IfContactNotFound() throws FileNotFoundException {
        String result = obj.editPerson("pandey","abc","55555",new AddressDetails(
                "hyderabad",
                "tel","23"),filePath);
        Assert.assertEquals("no record found to edit",result);
    }
}
