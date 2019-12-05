package com.addressbook.services;

import com.addressbook.models.AddressDetails;
import com.addressbook.models.PersonDetails;

import java.io.IOException;

public interface AddressbookInterface {
    public PersonDetails addPerson(String fname, String lname, String add, String contact, AddressDetails
            addressDetails) throws IOException;


    public void editPerson();

    public void deletePerson();

    public void sortByName();

    public void sortByZip();


}



