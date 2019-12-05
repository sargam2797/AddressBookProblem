import com.addressbook.models.AddressDetails;
import com.addressbook.models.PersonDetails;
import com.addressbook.services.AddressBookManager;
import com.addressbook.services.AddressbookInterface;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {

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
}
