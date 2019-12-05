package com.addressbook.services;

import com.addressbook.models.AddressDetails;
import com.addressbook.models.PersonDetails;

public interface AddressbookInterface {
    public PersonDetails addPerson(String fname, String lname, String add, String contact, AddressDetails
            addressDetails);

    public void editPerson();

    public void deletePerson();

    public void sortByName();

    public void sortByZip();

}



