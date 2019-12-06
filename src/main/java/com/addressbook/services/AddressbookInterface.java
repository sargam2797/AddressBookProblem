package com.addressbook.services;

import com.addressbook.models.AddressDetails;
import com.addressbook.models.PersonDetails;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface AddressbookInterface {
    public PersonDetails addPerson(String fname, String lname, String add, String contact, AddressDetails
            addressDetails) throws IOException;
    public boolean writeToFile(List<PersonDetails> personDetails, String filePath);

    public boolean isFileAvailable(String destinationFolder, String fileName);

    public String createNewFile(String destinationFolder, String fileName) throws IOException;

    public String deleteFile(String destinationFolder, String fileName) throws IOException;

    public void editPerson();

    public String deletePerson(String firstName, String fileName) throws FileNotFoundException;

    public void sortByName();

    public void sortByZip();


}



